package com.gammasoft.busfinder.view.fragment.agregar

import android.content.Context
import android.content.SharedPreferences
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
import com.gammasoft.busfinder.databinding.TarjetaAgregarRutaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.model.mapa.ApiService
import com.gammasoft.busfinder.model.mapa.RutaResponse
import com.gammasoft.busfinder.model.mapa.RutaTiempo
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TarjetaRuta(private val bin: FragmentAdministradorBinding): BaseBlurPopup(), OnMapReadyCallback{
    private var _binding: TarjetaAgregarRutaBinding? = null
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences
    private lateinit var localDB: Crud

    private lateinit var evento: MapaEvento
    private lateinit var map: GoogleMap

    private var start = ""
    private var end = ""

    private val polylines = ArrayList<Polyline>()
    private val oldStarts = ArrayList<String>()
    private val coordenadas = ArrayList<Coordenada>()

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaRuta(bin).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaAgregarRutaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        localDB = LocalDataBase.getDB(requireContext()).crud()

        val mapa = childFragmentManager.findFragmentById(R.id.mapaAgregarRuta) as SupportMapFragment
        mapa.getMapAsync(this)

        binding.btnAtras.setOnClickListener{
            if(polylines.isEmpty() && oldStarts.isEmpty()){
                start = ""
                end = ""
                Toast.makeText(requireContext(), "No hay caminos que deshacer", Toast.LENGTH_SHORT).show()
            }else{
                polylines[polylines.size-1].remove()
                polylines.removeAt(polylines.size-1)

                val menos = if(oldStarts.size == 1) 1
                else 2

                start = oldStarts[oldStarts.size-menos]
                oldStarts.removeAt(oldStarts.size-1)
            }
        }

        binding.btnLimpiar.setOnClickListener{
            map.clear()

            polylines.clear()
            oldStarts.clear()
            coordenadas.clear()
            start = ""
            end = ""

            Toast.makeText(requireContext(), "¡Mapa liampiado!", Toast.LENGTH_LONG).show()
        }

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnAgregar.setOnClickListener{
            val ruta = binding.txtRuta.text.toString()
            finalizar()

            if(ruta.isNotEmpty() && coordenadas.isNotEmpty()){
                prefs = requireActivity().getSharedPreferences(activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
                localDB.getCuentaAdministradorByCorreo(prefs.getString("correo", null)!!).observe(viewLifecycleOwner){
                    localDB.getAdministradorByUsuario(it.getAdminUsuario()).observe(viewLifecycleOwner){ a ->
                        val r = Ruta(ruta, a.getRfc())

                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.addRutas(r)
                        }

                        for(coor in coordenadas){
                            CoroutineScope(Dispatchers.IO).launch{
                                coor.setAdministrador(r.getAdministrador())
                                localDB.addCoordenadas(coor)
                            }
                        }

                        localDB.getRutas().observe(viewLifecycleOwner){ rutas ->
                            localDB.getCoordenadas().observe(viewLifecycleOwner){ coors ->
                                val inicio = coors.size - coordenadas.size
                                for(i in inicio until coors.size){
                                    CoroutineScope(Dispatchers.IO).launch{
                                        val rC = RutaCoordenada(rutas.last().getId(), coors[i].getId())
                                        localDB.addRutaCoordenadas(rC)
                                        CloudDataBase.addRuta(rutas.last())
                                        CloudDataBase.addCoordenada(coors[i])
                                        CloudDataBase.addRutaCoordenada(rC)
                                    }
                                }
                            }
                        }

                        Toast.makeText(requireContext(), "¡Ruta agregada con éxito!", Toast.LENGTH_LONG).show()
                        bin.btnAgregar.visibility = View.VISIBLE
                        dismiss()
                    }
                }
            }else if(ruta.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar la Ruta").show(parentFragmentManager, "Advertencia")
            else if(coordenadas.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe dibujar una Ruta").show(parentFragmentManager, "Advertencia")
        }
    }

    private fun finalizar(){
        coordenadas.clear()
        if(polylines.isNotEmpty()){
            coordenadas.add(Coordenada(polylines[0].points.first().longitude, polylines[0].points.first().latitude, ""))
            coordenadas.add(Coordenada(polylines[0].points.last().longitude, polylines[0].points.last().latitude, ""))

            for(i in 1 until polylines.size)
                polylines[i].points.last{
                    coordenadas.add(Coordenada(it.longitude, it.latitude, ""))
                }
        }
    }

    private fun addPolyline(newPolyline: Polyline){
        polylines.add(newPolyline)
        oldStarts.add(start)
    }

    private fun drawRoute(routeResponse: RutaResponse?, timeResponse: RutaTiempo?){
        val polylineOptions = PolylineOptions()

        routeResponse?.features?.first()?.geometry?.coordinates?.forEach{
            polylineOptions.add(LatLng(it[1], it[0]))
            polylineOptions.width(15f)
            polylineOptions.color(ContextCompat.getColor(requireContext(), R.color.color11))

            activity?.runOnUiThread{
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(it[1], it[0]), 17f))
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

            addPolyline(poly)
        }
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openrouteservice.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun crearRuta(){
        CoroutineScope(Dispatchers.IO).launch{
            val call = getRetrofit().create(ApiService::class.java).getRuta("5b3ce3597851110001cf6248ea69c2e44f1b4c03af75022305d4da4b", start, end)
            val time = getRetrofit().create(ApiService::class.java).getTiempo("5b3ce3597851110001cf6248ea69c2e44f1b4c03af75022305d4da4b", start, end)

            if(call.isSuccessful){
                drawRoute(call.body(), time.body())
                start = end
                end = ""
            }else MensajeAlerta("ERROR", "No se pudo dibujar la ruta").show(parentFragmentManager, "Error")
        }
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap

        map.setMinZoomPreference(10f)
        map.setMaxZoomPreference(19f)

        evento = MapaEvento(this, map)
        map.setOnMyLocationClickListener(evento)
        map.setOnMyLocationClickListener(evento)

        if(::map.isInitialized) map.setOnMapClickListener{
            if(start.isEmpty()) start = "${it.longitude},${it.latitude}"
            else if(end.isEmpty()){
                end = "${it.longitude},${it.latitude}"
                crearRuta()
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