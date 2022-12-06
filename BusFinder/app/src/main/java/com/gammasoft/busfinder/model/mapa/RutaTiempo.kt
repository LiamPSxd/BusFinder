package com.gammasoft.busfinder.model.mapa

import com.google.gson.annotations.SerializedName

data class RutaTiempo(@SerializedName("features") val features: List<Property>)
data class Property(@SerializedName("properties") val properties: Summary)
data class Summary(@SerializedName("summary") val summary: Duration)
data class Duration(@SerializedName("duration") val duration: Double)
data class Distance(@SerializedName("distance") val distance: Double)