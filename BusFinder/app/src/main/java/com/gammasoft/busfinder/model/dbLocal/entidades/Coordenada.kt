package com.gammasoft.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Coordenada")
data class Coordenada(@PrimaryKey(autoGenerate = true)
                      @ColumnInfo(name = "id")  private var id: Int,
                      @ColumnInfo(name = "latitud") private var latitud: Double,
                      @ColumnInfo(name = "longitud") private var longitud: Double){
    constructor(): this(0, 0.0, 0.0)

    fun setId(id: Int){
        this.id = id
    }

    fun getId(): Int{
        return id
    }

    fun setLatitud(latitud: Double){
        this.latitud = latitud
    }

    fun getLatitud(): Double{
        return latitud
    }

    fun setLongitud(longitud: Double){
        this.longitud = longitud
    }

    fun getLongitud(): Double{
        return longitud
    }

    override fun toString(): String{
        return "Coordenada: Latitud: $latitud, Longitud: $longitud"
    }
}