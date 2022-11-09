package com.gammasoft.busfinder.view.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaAgregarBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*

class MapaFragment(private var binding: TarjetaAgregarBinding): Fragment(), OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener{
    private lateinit var map: GoogleMap

    companion object{
        const val REQUEST_CODE_LOCATION = 0
    }

    override fun onMapReady(googleMap: GoogleMap){
        map = googleMap

        crearParadas(LatLng(19.5526134, -96.8890588), "Aquí estoy yo")

        crearRutas(PolylineOptions()
            .add(
                LatLng(19.53991574288343, -96.92276466462953),
                LatLng(19.540233813705463, -96.92241405506256),
                LatLng(19.54044740693508, -96.92247038143638),
                LatLng(19.54049543377456, -96.9226943458784),
                LatLng(19.54078233065668, -96.92314227478974),
                LatLng(19.541019936498692, -96.92349900859429),
                LatLng(19.54143069045066, -96.92422856943733),
                LatLng(19.541811110871418, -96.92517807142134),
                LatLng(19.541787097649618, -96.92530145306846),
                LatLng(19.541641754386117, -96.92558576721044),
                LatLng(19.5412992493038, -96.92622010963619),
                LatLng(19.541897052903984, -96.9265728201177),
                LatLng(19.541861665016516, -96.92668144958483),
                LatLng(19.541957717839203, -96.92674716371836),
                LatLng(19.5417769868219, -96.92693223613153),
                LatLng(19.541660712214288, -96.92693491834041),
                LatLng(19.541655656794678, -96.9272044803335)
            )
            .width(15f)
            .color(ContextCompat.getColor(requireActivity(), R.color.black))
        )

        map.setOnMyLocationButtonClickListener(this)
        map.setOnMyLocationClickListener(this)
        activarLocalizacion()
    }

    private fun crearParadas(coordenadas: LatLng, text: String){
        map.addMarker(MarkerOptions().position(coordenadas).title(text))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas, 18f))
        //map.moveCamera(CameraUpdateFactory.newLatLng(coordenadas))
    }

    private fun crearRutas(polyLineOptions: PolylineOptions){
        val polyline: Polyline = map.addPolyline(polyLineOptions)
        polyline.startCap = RoundCap()
        //polyline.endCap = CustomCap(BitmapDescriptorFactory.fromResource(R.drawable.img_agregar))

        /*polyline.pattern = listOf(
            Dot(), Gap(10f), Dash(50f), Gap(10f)
        )*/

        polyline.isClickable = true
        map.setOnPolylineClickListener{
            polyline.color = ContextCompat.getColor(requireActivity(), R.color.black)
        }
    }

    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        requireActivity(),
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun requestLocationPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(
                requireActivity(),
                "Ve a ajustes y acepta los permisos",
                Toast.LENGTH_SHORT
            ).show()
        }else{
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }

    //@SuppressLint("MissingPermission")
    private fun activarLocalizacion(){
        if(!::map.isInitialized) return

        if(isLocationPermissionGranted()){
            map.isMyLocationEnabled = true
        }else{
            requestLocationPermission()
        }
    }

    //@SuppressLint("MissingPermission")
    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                map.isMyLocationEnabled = true
            }else{
                Toast.makeText(
                    requireActivity(),
                    "Para activar la Localización ver a ajustes y acepta los permisos",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {}
        }
    }

    //@SuppressLint("MissingPermission")
    override fun onResume(){
        super.onResume()
        if(!::map.isInitialized) return

        if(!isLocationPermissionGranted()){
            map.isMyLocationEnabled = false
            Toast.makeText(
                requireActivity(),
                "Para activar la Localización ver a ajustes y acepta los permisos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onMyLocationButtonClick(): Boolean{
        Toast.makeText(
            requireActivity(),
            "Llevándolo a su localización",
            Toast.LENGTH_SHORT
        ).show()
        return false
    }

    override fun onMyLocationClick(coordenadas: Location){
        Toast.makeText(
            requireActivity(),
            "Estás en ${coordenadas.latitude}, ${coordenadas.longitude}",
            Toast.LENGTH_SHORT
        ).show()
    }

    private val callback = OnMapReadyCallback{ map ->
        onMapReady(map)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        /*val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)*/

        binding.frameAgregarParada.mapa.getMapAsync(callback)
    }
}