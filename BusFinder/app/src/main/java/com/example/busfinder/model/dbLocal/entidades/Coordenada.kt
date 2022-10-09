package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Coordenada")
data class Coordenada(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")  private var id: Int,
                      @ColumnInfo(name = "latitud") private var latitud: String,
                      @ColumnInfo(name = "longitud") private var longitud: String){
    constructor(): this(0, "", "")

    fun setId(id: Int){
        this.id = id
    }

    fun getId(): Int{
        return id
    }

    fun setLatitud(latitud: String){
        this.latitud = latitud
    }

    fun getLatitud(): String{
        return latitud
    }

    fun setLongitud(longitud: String){
        this.longitud = longitud
    }

    fun getLongitud(): String{
        return longitud
    }

    override fun toString(): String{
        return "Coordenada: Latitud: $latitud, Longitud: $longitud"
    }
}