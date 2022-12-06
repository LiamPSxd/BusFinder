package com.gammasoft.busfinder.view.fragment.modificar

import android.location.Geocoder
import android.os.Bundle
import android.text.Editable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.MapaEvento
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaModificarParadaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.entidades.Parada
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import io.alterac.blurkit.BlurLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.reflect.InvocationTargetException
import java.util.*

class TarjetaParada(private val localDB: Crud,
                    private val bin: FragmentAdministradorBinding,
                    private val parada: Parada): BaseBlurPopup(), OnMapReadyCallback, AdapterView.OnItemSelectedListener{
    private var _binding: TarjetaModificarParadaBinding? = null
    private val binding get() = _binding!!

    private var ruta = ""

    private lateinit var evento: MapaEvento
    private lateinit var map: GoogleMap

    private val markers = ArrayList<Marker>()
    private val paradas = ArrayList<Parada>()

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaParada(localDB, bin, parada).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaModificarParadaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val mapa = childFragmentManager.findFragmentById(R.id.mapaModificarParada) as SupportMapFragment
        mapa.getMapAsync(this)

        binding.txtParada.text = Editable.Factory().newEditable(parada.getNombre())

        val rutas = ArrayList<String>()
        var contador = 0
        localDB.getRutas().observe(viewLifecycleOwner){
            for(ruta in it){
                if(ruta.getNombre() != "") rutas.add(ruta.getNombre())

                localDB.getRutaParadas().observe(viewLifecycleOwner){ rPs ->
                    for(rt in rPs) if(rt.getRutaID() == ruta.getId() && rt.getParadaID() == parada.getId())
                        contador = rPs.indexOf(rt)
                }
            }
        }
        rutas.add("Seleccione una Ruta")

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            rutas
        ).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            with(binding.spSeleccion){
                setSelection(contador, false)
                onItemSelectedListener = this@TarjetaParada
                gravity = Gravity.START
                adapter = it
            }
        }

        binding.btnAtras.setOnClickListener{
            if(markers.isEmpty()) Toast.makeText(requireContext(), "No hay paradas que deshacer", Toast.LENGTH_SHORT).show()
            else{
                markers[markers.size-1].remove()
                markers.removeAt(markers.size-1)
            }
        }

        binding.btnLimpiar.setOnClickListener{
            map.clear()

            markers.clear()
            paradas.clear()

            cambiarParada(LatLng(parada.getLatitud(), parada.getLongitud()))
            Toast.makeText(requireContext(), "¡Mapa reiniciado!", Toast.LENGTH_SHORT).show()
        }

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnModificar.setOnClickListener{
            val p = binding.txtParada.text.toString()
            finalizar()

            if(p.isNotEmpty() && ruta.isNotEmpty() && ruta != "Seleccione una Ruta" && paradas.isNotEmpty()){
                if(paradas.size == 1){
                    localDB.getRutas().observe(viewLifecycleOwner){
                        for(ruta in it) localDB.getRutaParadas().observe(viewLifecycleOwner){ rPs ->
                            for(rt in rPs) if(rt.getRutaID() == ruta.getId() && rt.getParadaID() == parada.getId()){
                                CoroutineScope(Dispatchers.IO).launch{
                                    localDB.deleteRutaParada(rt)
                                }
                            }
                        }
                    }

                    parada.setNombre(p)
                    parada.setLatitud(paradas[0].getLatitud())
                    parada.setLongitud(paradas[0].getLongitud())

                    localDB.getRutaByNombre(ruta).observe(viewLifecycleOwner){
                        CoroutineScope(Dispatchers.IO).launch{
                            localDB.updateParada(parada)
                            CloudDataBase.addParada(parada)

                            val rP = RutaParada(it.getId(), parada.getId())
                            localDB.addRutaParadas(rP)
                            CloudDataBase.addRutaParada(rP)
                        }
                    }

                    Toast.makeText(requireContext(), "¡Parada modificada con éxito!", Toast.LENGTH_SHORT).show()
                    bin.btnAgregar.visibility = View.VISIBLE
                    dismiss()
                }else MensajeAlerta("ERROR", "Hay más de una Parada").show(parentFragmentManager, "Error")
            }else if(p.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar el nombre de la Parada").show(parentFragmentManager, "Advertencia")
            else if(ruta.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe seleccionar una Ruta").show(parentFragmentManager, "Advertencia")
            else if(ruta == "Seleccione una Ruta") MensajeAlerta("ADVERTENCIA", "Seleccione otra Ruta").show(parentFragmentManager, "Advertencia")
            else if(paradas.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe seleccionar una Parada").show(parentFragmentManager, "Advertencia")
        }
    }

    private fun finalizar(){
        paradas.clear()
        if(markers.isNotEmpty())
            for(marker in markers)
                paradas.add(Parada(marker.title.toString(), marker.position.longitude, marker.position.latitude, ""))
    }

    private fun cambiarParada(coordenadas: LatLng){
        try{
            val titulo = Geocoder(requireContext(), Locale("spanish", "mexico")).getFromLocation(coordenadas.latitude, coordenadas.longitude, 1)

            if(markers.size >= 1){
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(markers[0].position, 19f))
                markers[0].remove()
                markers.removeAt(0)
            }

            map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas, 19f))
            markers.add(map.addMarker(MarkerOptions().position(coordenadas).title(titulo?.get(0)?.getAddressLine(0) ?: ""))!!)
        }catch(_: InvocationTargetException){}
        catch(_: IOException){}
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap

        map.setMinZoomPreference(10f)
        map.setMaxZoomPreference(21f)

        evento = MapaEvento(this, map)
        map.setOnMyLocationClickListener(evento)
        map.setOnMyLocationButtonClickListener(evento)

        if(::map.isInitialized){
            if(markers.isEmpty()) cambiarParada(LatLng(parada.getLatitud(), parada.getLongitud()))

            map.setOnMapClickListener{
                cambiarParada(LatLng(it.latitude, it.longitude))
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){
        ruta = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?){}

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