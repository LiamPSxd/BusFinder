package com.gammasoft.busfinder.model.mapa

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("/v2/directions/driving-car")
    suspend fun getRuta(@Query("api_key") key: String,
                        @Query("start", encoded = true) start: String,
                        @Query("end", encoded = true) end: String): retrofit2.Response<RutaResponse>
}