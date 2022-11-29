package com.gammasoft.busfinder.controller

import android.location.Location
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap

class MapaEvento(private val fragment: Fragment): GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener{
    override fun onMyLocationButtonClick(): Boolean{
        Toast.makeText(fragment.context, "Llevándolo a su localización", Toast.LENGTH_SHORT).show()
        return false
    }

    override fun onMyLocationClick(coordenadas: Location) =
        Toast.makeText(fragment.context, "Estás en ${coordenadas.latitude}, ${coordenadas.longitude}", Toast.LENGTH_SHORT).show()
}