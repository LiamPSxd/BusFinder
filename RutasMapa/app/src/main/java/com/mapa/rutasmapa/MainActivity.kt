package com.mapa.rutasmapa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.mapa.rutasmapa.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var mapAux: GoogleMap
    private lateinit var binding: ActivityMainBinding

    private var start:String = ""
    private var end:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculateRoute.setOnClickListener {
            binding.btnMapClear.isEnabled = false
            binding.btnCalculateRoute.isEnabled = false
            start = ""
            end = ""
            if(::map.isInitialized){
                map.setOnMapClickListener {
                    if(start.isEmpty()){
                        //Se necesitan ambas coordenadas juntas ejemplo (255515,51541)
                        start = "${it.longitude},${it.latitude}"
                    }else if(end.isEmpty()){
                        end = "${it.longitude},${it.latitude}"
                        createRoute()
                    }
                }
            }
        }
        binding.btnMapClear.setOnClickListener {
            Toast.makeText(this, "Mapa Actualizado", Toast.LENGTH_SHORT).show()
        }
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map

    }

    //Método que devuelve un objeto Retrofit
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openrouteservice.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Método que llama a la interfaz ApiService
    private fun createRoute(){
        //Hilo independiente del principal
        CoroutineScope(Dispatchers.IO).launch{
            val call = getRetrofit().create(ApiService::class.java).getRoute("5b3ce3597851110001cf6248f62a7458dd98445899871a22a91b71ce",start,end)
            if(call.isSuccessful){
                drawRoute(call.body())
            }else{
                Log.i("aris","KO")
            }
        }
        binding.btnMapClear.isEnabled = true
        binding.btnCalculateRoute.isEnabled = true
    }

    private fun drawRoute(routeResponse: RouteResponse?) {
        val polylineOptions = PolylineOptions()
        routeResponse?.features?.first()?.geometry?.coordinates?.forEach{
            polylineOptions.add(LatLng(it[1], it[0]))
        }
        runOnUiThread{
            val poly = map.addPolyline(polylineOptions)
        }
    }
}