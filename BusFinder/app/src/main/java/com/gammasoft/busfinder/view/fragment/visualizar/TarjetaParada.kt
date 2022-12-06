package com.gammasoft.busfinder.view.fragment.visualizar

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.MapaEvento
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaVisualizarParadaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
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
import com.google.android.gms.maps.model.MarkerOptions
import io.alterac.blurkit.BlurLayout
import java.util.*

class TarjetaParada(private val fragment: TarjetaBase,
                    private val bin: FragmentAdministradorBinding,
                    private val titulo: String,
                    private val id: String): BaseBlurPopup(), OnMapReadyCallback{
    private var _binding: TarjetaVisualizarParadaBinding? = null
    private val binding get() = _binding!!

    private lateinit var localDB: Crud

    private lateinit var evento: MapaEvento
    private lateinit var map: GoogleMap

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaParada(fragment, bin, titulo, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaVisualizarParadaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

        val mapa = childFragmentManager.findFragmentById(R.id.mapaParada) as SupportMapFragment
        mapa.getMapAsync(this)

        bin.btnAgregar.visibility = View.GONE

        if(id != "Nada que mostrar") localDB.getParadaById(id.toInt()).observe(viewLifecycleOwner){ p ->
            if(p != null) if(p.getNombre() == titulo){
                binding.btnBorrar.setOnClickListener{
                    fragment.context?.vibrate(80L)
                    fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaParada(localDB, bin, p).mostrar())
                    dismiss()
                }

                binding.btnModificar.setOnClickListener{
                    fragment.context?.vibrate(50L)
                    fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaParada(localDB, bin, p).mostrar())
                    dismiss()
                }
            }
        }
    }

    private fun crearParada(coordenadas: LatLng){
        val titulo = Geocoder(requireContext(), Locale("spanish", "mexico")).getFromLocation(coordenadas.latitude, coordenadas.longitude, 1)

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas, 19f))
        map.addMarker(MarkerOptions().position(coordenadas).title(titulo?.get(0)?.getAddressLine(0) ?: ""))!!
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap

        map.setMinZoomPreference(10f)
        map.setMaxZoomPreference(19f)

        evento = MapaEvento(this, map)
        map.setOnMyLocationButtonClickListener(evento)
        map.setOnMyLocationClickListener(evento)

        if(id != "Nada que mostrar") localDB.getParadaById(id.toInt()).observe(viewLifecycleOwner){ p ->
            if(p != null) if(p.getNombre() == titulo){
                binding.txtParada.text = p.getNombre()

                localDB.getRutaIDByParadaID(p.getId()).observe(viewLifecycleOwner){ r ->
                    if(r != null) localDB.getRutaById(r.getRutaID()).observe(viewLifecycleOwner){ ruta ->
                        binding.txtRuta.text = ruta.getNombre()
                    }
                }

                crearParada(LatLng(p.getLatitud(), p.getLongitud()))
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