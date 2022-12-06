package com.gammasoft.busfinder.view.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.MapaEvento
import com.gammasoft.busfinder.databinding.FragmentMapaBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class Mapa: Fragment(), OnMapReadyCallback{
    private var _binding: FragmentMapaBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: MapaEvento
    private lateinit var map: GoogleMap

    /*private var ruta = false
    private var parada = false

    private var start = ""
    private var end = ""

    private val polylines = ArrayList<Polyline>()
    private val oldStarts = ArrayList<String>()
    private val markers = ArrayList<Marker>()
    private val coordenadas = ArrayList<Coordenada>()
    private val paradas = ArrayList<Parada>()*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentMapaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val mapa = childFragmentManager.findFragmentById(R.id.mapa) as SupportMapFragment
        mapa.getMapAsync(this)

        /*if(::map.isInitialized) map.setOnMapClickListener{
            if(ruta && !parada){
                if(start.isEmpty()) start = "${it.longitude},${it.latitude}"
                else if(end.isEmpty()){
                    end = "${it.longitude},${it.latitude}"
                    crearRuta()
                }
            }

            if(parada && !ruta) crearParada(LatLng(it.latitude, it.longitude))

            if(!parada && !ruta) cambiarParada(LatLng(it.latitude, it.longitude))
        }*/
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap

        map.setMinZoomPreference(10f)
        map.setMaxZoomPreference(21f)

        evento = MapaEvento(this, map)
        map.setOnMyLocationButtonClickListener(evento)
        map.setOnMyLocationClickListener(evento)
        activarLocalizacion()
    }

    /*fun deshacer(){
        if(ruta){
            if(polylines.isEmpty() && oldStarts.isEmpty()){
                start = ""
                end = ""
                Toast.makeText(requireContext(), "No hay nada que deshacer", Toast.LENGTH_SHORT).show()
            }else{
                polylines[polylines.size-1].remove()
                polylines.removeAt(polylines.size-1)

                val menos = if(oldStarts.size == 1) 1
                else 2

                start = oldStarts[oldStarts.size-menos]
                oldStarts.removeAt(oldStarts.size-1)
            }
        }else if(parada){
            if(markers.isEmpty()) Toast.makeText(requireContext(), "No hay nada que deshacer", Toast.LENGTH_SHORT).show()
            else{
                markers[markers.size-1].remove()
                markers.removeAt(markers.size-1)
            }
        }
    }

    fun limpiarMapa(){
        map.clear()

        if(ruta){
            polylines.clear()
            oldStarts.clear()
            coordenadas.clear()
            start = ""
            end = ""
        }else if(parada){
            markers.clear()
            paradas.clear()
        }

        Toast.makeText(requireContext(), "¡Mapa liampiado!", Toast.LENGTH_SHORT).show()
    }

    fun crearParada(coordenadas: LatLng){
        val titulo = Geocoder(requireContext(), Locale("spanish", "mexico")).getFromLocation(coordenadas.latitude, coordenadas.longitude, 1)

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas, 10f))
        //map.moveCamera(CameraUpdateFactory.newLatLng(coordenadas))
        markers.add(map.addMarker(MarkerOptions().position(coordenadas).title(titulo?.get(0)?.getAddressLine(0) ?: ""))!!)
    }

    private fun cambiarParada(coordenadas: LatLng){
        val titulo = Geocoder(requireContext(), Locale("spanish", "mexico")).getFromLocation(coordenadas.latitude, coordenadas.longitude, 1)
        val i = markers.size-1
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(markers[i].position.latitude, markers[i].position.longitude), 10f))

        Thread.sleep(500)
        markers[i].remove()
        markers.removeAt(i)

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas, 10f))
        markers.add(map.addMarker(MarkerOptions().position(coordenadas).title(titulo?.get(0)?.getAddressLine(0) ?: ""))!!)
    }

    private fun crearRuta(){
        CoroutineScope(Dispatchers.IO).launch{
            val call = getRetrofit().create(ApiService::class.java).getRuta("5b3ce3597851110001cf6248ea69c2e44f1b4c03af75022305d4da4b", start, end)
            val time = getRetrofit().create(ApiService::class.java).getTiempo("5b3ce3597851110001cf6248ea69c2e44f1b4c03af75022305d4da4b", start, end)

            if(call.isSuccessful){
                drawRoute(call.body(), time.body())
                start = end
                end = ""
            }
        }
    }

    fun crearRutas(inicio: String, fin: String){
        CoroutineScope(Dispatchers.IO).launch{
            val call = getRetrofit().create(ApiService::class.java).getRuta("5b3ce3597851110001cf6248ea69c2e44f1b4c03af75022305d4da4b", inicio, fin)
            val time = getRetrofit().create(ApiService::class.java).getTiempo("5b3ce3597851110001cf6248ea69c2e44f1b4c03af75022305d4da4b", inicio, fin)

            if(call.isSuccessful){
                drawRoute(call.body(), time.body())
                start = fin
                end = ""

                withContext(Dispatchers.IO){ Thread.sleep(500) }
            }
        }
    }

    fun agregar(){
        if(ruta && polylines.isNotEmpty()){
            coordenadas.add(Coordenada(polylines[0].points.first().longitude, polylines[0].points.first().latitude, ""))
            coordenadas.add(Coordenada(polylines[0].points.last().longitude, polylines[0].points.last().latitude, ""))

            for(i in 1 until polylines.size){
                polylines[i].points.last{
                    coordenadas.add(Coordenada(it.longitude, it.latitude, ""))
                }
            }
        }else if(parada && markers.isNotEmpty())
            for(marker in markers) paradas.add(Parada(marker.title.toString(), marker.position.longitude, marker.position.latitude, ""))
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openrouteservice.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
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

            map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(it[1], it[0]), 10f))
        }

        activity?.runOnUiThread{
            val poly = map.addPolyline(polylineOptions)
            poly.startCap = RoundCap()
            poly.endCap = RoundCap()
            poly.isClickable = true
            map.setOnPolylineClickListener{
                timeResponse?.features?.first()?.properties?.summary?.forEach{
                    poly.tag = "Distancia: ${it.value.distance}, Duración: ${it.key.duration}"
                }
            }
            /*poly.endCap = CustomCap(BitmapDescriptorFactory.fromResource(R.drawable.img_agregar))
            poly.pattern = listOf(
                Dot(), Gap(10f), Dash(50f), Gap(10f)
            )*/

            addPolyline(poly)
        }
    }*/

    private fun isLocationPermissionGranted() =
        ContextCompat.checkSelfPermission(
        requireContext(),
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private val requestPermission = registerForActivityResult(RequestPermission()){ isGaranted ->
        if(isGaranted) map.isMyLocationEnabled = true
        else Toast.makeText(requireActivity(), "Para activar la Localización ver a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
    }

    private fun requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
        ) Toast.makeText(requireActivity(), "Ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        else requestPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    private fun activarLocalizacion(){
        if(!::map.isInitialized) return

        if(isLocationPermissionGranted()) map.isMyLocationEnabled = true
        else requestLocationPermission()
    }

    override fun onResume(){
        super.onResume()
        if(!::map.isInitialized) return

        if(!isLocationPermissionGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(requireActivity(), "Para activar la Localización ve a ajustes y acepta los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}