package com.gammasoft.busfinder.view.fragment.visualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.AnimRes
import androidx.core.content.ContextCompat
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.MapaEvento
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaVisualizarRutaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.mapa.ApiService
import com.gammasoft.busfinder.model.mapa.RutaResponse
import com.gammasoft.busfinder.model.mapa.RutaTiempo
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.vibrate
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TarjetaRuta(private val fragment: TarjetaBase,
                  private val bin: FragmentAdministradorBinding,
                  private val titulo: String,
                  private val id: String): BaseBlurPopup(), OnMapReadyCallback{
    private var _binding: TarjetaVisualizarRutaBinding? = null
    private val binding get() = _binding!!

    private lateinit var localDB: Crud

    private lateinit var evento: MapaEvento
    private lateinit var map: GoogleMap

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaRuta(fragment, bin, titulo, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaVisualizarRutaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

        val mapa = childFragmentManager.findFragmentById(R.id.mapaRuta) as SupportMapFragment
        mapa.getMapAsync(this)

        bin.btnAgregar.visibility = View.GONE

        localDB.getRutaById(id.toInt()).observe(viewLifecycleOwner){ ruta ->
            if(ruta != null) if(ruta.getNombre() == titulo){
                binding.btnBorrar.setOnClickListener{
                    fragment.context?.vibrate(80L)
                    fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaRuta(localDB, bin, ruta).mostrar())
                    dismiss()
                }

                binding.btnModificar.setOnClickListener{
                    fragment.context?.vibrate(50L)
                    fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaRuta(localDB, bin, ruta).mostrar())
                    dismiss()
                }
            }
        }
    }

    private fun drawRoute(routeResponse: RutaResponse?, timeResponse: RutaTiempo?){
        val polylineOptions = PolylineOptions()

        routeResponse?.features?.first()?.geometry?.coordinates?.forEach{
            polylineOptions.add(LatLng(it[1], it[0]))
            polylineOptions.width(15f)
            polylineOptions.color(ContextCompat.getColor(requireContext(), R.color.color11))

            activity?.runOnUiThread{
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(it[1], it[0]), 18f))
            }
        }

        activity?.runOnUiThread{
            val poly = map.addPolyline(polylineOptions)
            poly.startCap = RoundCap()
            poly.endCap = RoundCap()
            poly.isClickable = true
            map.setOnPolylineClickListener{
                val time = timeResponse?.features?.first()?.properties?.summary?.duration
                Toast.makeText(requireContext(), "Duración: $time", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openrouteservice.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun crearRutas(inicio: String, fin: String){
        CoroutineScope(Dispatchers.IO).launch{
            val call = getRetrofit().create(ApiService::class.java).getRuta("5b3ce3597851110001cf6248ea69c2e44f1b4c03af75022305d4da4b", inicio, fin)
            val time = getRetrofit().create(ApiService::class.java).getTiempo("5b3ce3597851110001cf6248ea69c2e44f1b4c03af75022305d4da4b", inicio, fin)

            if(call.isSuccessful){
                drawRoute(call.body(), time.body())
                withContext(Dispatchers.IO){ Thread.sleep(100) }
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap

        map.setMinZoomPreference(10f)
        map.setMaxZoomPreference(19f)

        evento = MapaEvento(this, map)
        map.setOnMyLocationButtonClickListener(evento)
        map.setOnMyLocationClickListener(evento)

        if(id != "Nada que mostrar") localDB.getRutaById(id.toInt()).observe(viewLifecycleOwner){ ruta ->
            if(ruta != null) if(ruta.getNombre() == titulo){
                binding.txtRuta.text = ruta.getNombre()

                localDB.getCoordenadasIDByRutaID(ruta.getId()).observe(viewLifecycleOwner){ cRs ->
                    if(cRs.isNotEmpty()) localDB.getCoordenadaById(cRs[0].getCoordenadaID()).observe(viewLifecycleOwner){ c ->
                        var inicio = "${c.getLongitud()},${c.getLatitud()}"
                        for(i in 1 until cRs.size){
                            localDB.getCoordenadaById(cRs[i].getCoordenadaID()).observe(viewLifecycleOwner){ coor ->
                                if(coor != null){
                                    val fin = "${coor.getLongitud()},${coor.getLatitud()}"
                                    crearRutas(inicio, fin)
                                    inicio = fin
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        bin.btnAgregar.visibility = View.VISIBLE
        _binding = null
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): View = binding.tarjeta

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout
}