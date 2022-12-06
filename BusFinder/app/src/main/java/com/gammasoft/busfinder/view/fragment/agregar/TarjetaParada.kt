package com.gammasoft.busfinder.view.fragment.agregar

import android.content.Context
import android.content.SharedPreferences
import android.location.Geocoder
import android.os.Bundle
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
import com.gammasoft.busfinder.databinding.TarjetaAgregarParadaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
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

class TarjetaParada(private val bin: FragmentAdministradorBinding): BaseBlurPopup(), AdapterView.OnItemSelectedListener, OnMapReadyCallback{
    private var _binding: TarjetaAgregarParadaBinding? = null
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences
    private lateinit var localDB: Crud

    private var ruta = ""

    private lateinit var evento: MapaEvento
    private lateinit var map: GoogleMap

    private val markers = ArrayList<Marker>()
    private val paradas = ArrayList<Parada>()

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaParada(bin).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaAgregarParadaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        localDB = LocalDataBase.getDB(requireContext()).crud()

        val mapa = childFragmentManager.findFragmentById(R.id.mapaAgregarParada) as SupportMapFragment
        mapa.getMapAsync(this)

        val rutas = ArrayList<String>()
        localDB.getRutas().observe(this){
            for(ruta in it) if(ruta.getNombre() != "") rutas.add(ruta.getNombre())
        }
        rutas.add("Seleccione una Ruta")

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            rutas
        ).also{
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            with(binding.spSeleccion){
                setSelection(0, false)
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

            Toast.makeText(requireContext(), "¡Mapa liampiado!", Toast.LENGTH_SHORT).show()
        }

        binding.btnCancelar.setOnClickListener{
            bin.btnAgregar.visibility = View.VISIBLE
            dismiss()
        }

        binding.btnAgregar.setOnClickListener{
            finalizar()

            if((ruta.isNotEmpty() && ruta != "Seleccione una Ruta") && paradas.isNotEmpty()){
                localDB.getRutaByNombre(ruta).observe(viewLifecycleOwner){ r ->
                    if(r != null){
                        prefs = requireActivity().getSharedPreferences(activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
                        localDB.getCuentaAdministradorByCorreo(prefs.getString("correo", null)!!).observe(viewLifecycleOwner){
                            localDB.getAdministradorByUsuario(it.getAdminUsuario()).observe(viewLifecycleOwner){ a ->
                                for(parada in paradas){
                                    CoroutineScope(Dispatchers.IO).launch{
                                        parada.setAdministrador(a.getRfc())
                                        localDB.addParadas(parada)
                                    }
                                }

                                localDB.getParadas().observe(viewLifecycleOwner){ prs ->
                                    val inicio = prs.size - paradas.size
                                    for(i in inicio until prs.size){
                                        CoroutineScope(Dispatchers.IO).launch{
                                            val rutaParada = RutaParada(r.getId(), prs[i].getId())
                                            localDB.addRutaParadas(rutaParada)
                                            CloudDataBase.addRutaParada(rutaParada)
                                            CloudDataBase.addParada(prs[i])
                                        }
                                    }
                                }

                                Toast.makeText(requireContext(), "¡Parada(s) agregada(s) con éxito!", Toast.LENGTH_LONG).show()
                                bin.btnAgregar.visibility = View.VISIBLE
                                dismiss()
                            }
                        }
                    }else MensajeAlerta("ERROR", "No se encontró ninguna ruta con ese dato").show(parentFragmentManager, "Error")
                }
            }else if(ruta.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe seleccionar una Ruta").show(parentFragmentManager, "Advertencia")
            else if(ruta == "Seleccione una Ruta") MensajeAlerta("ADVERTENCIA", "Seleccione otra Ruta").show(parentFragmentManager, "Advertencia")
            else if(paradas.isEmpty()) MensajeAlerta("ADVERTENCIA", "Debe seleccionar una o más Paradas").show(parentFragmentManager, "Advertencia")
        }
    }

    private fun crearParada(coordenadas: LatLng){
        try{
            val titulo = Geocoder(requireContext(), Locale("spanish", "mexico")).getFromLocation(coordenadas.latitude, coordenadas.longitude, 1)
            markers.add(map.addMarker(MarkerOptions().position(coordenadas).title(titulo?.get(0)?.getAddressLine(0) ?: ""))!!)
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas, 19f))
        }catch(_: InvocationTargetException){}
        catch(_: IOException){}
    }

    private fun finalizar(){
        paradas.clear()
        if(markers.isNotEmpty())
            for(marker in markers)
                paradas.add(Parada(marker.title.toString(), marker.position.longitude, marker.position.latitude, ""))
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap

        map.setMinZoomPreference(10f)
        map.setMaxZoomPreference(21f)

        evento = MapaEvento(this, map)
        map.setOnMyLocationButtonClickListener(evento)
        map.setOnMyLocationClickListener(evento)

        if(::map.isInitialized) map.setOnMapClickListener{
            crearParada(LatLng(it.latitude, it.longitude))
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