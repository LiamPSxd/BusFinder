package com.gammasoft.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Coordenada")
data class Coordenada(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") private var id: Int,
                      @ColumnInfo(name = "longitud") private var longitud: Double,
                      @ColumnInfo(name = "latitud") private var latitud: Double,
                      @ColumnInfo(name = "administrador") private var administrador: String){
    constructor(): this(0, 0.0, 0.0, "")
    constructor(longitud: Double, latitud: Double, administrador: String): this(0, longitud, latitud, administrador)

    fun setId(id: Int){
        this.id = id
    }

    fun getId(): Int{
        return id
    }

    fun setLongitud(longitud: Double){
        this.longitud = longitud
    }

    fun getLongitud(): Double{
        return longitud
    }

    fun setLatitud(latitud: Double){
        this.latitud = latitud
    }

    fun getLatitud(): Double{
        return latitud
    }

    fun setAdministrador(administrador: String){
        this.administrador = administrador
    }

    fun getAdministrador(): String{
        return administrador
    }

    override fun toString(): String{
        return "Coordenada: Longitud: $longitud, Latitud: $latitud"
    }
}