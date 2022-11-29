package com.gammasoft.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Parada")
data class Parada(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") private var id: Int,
                  @ColumnInfo(name = "nombre") private var nombre: String,
                  @ColumnInfo(name = "longitud") private var longitud: Double,
                  @ColumnInfo(name = "latitud") private var latitud: Double,
                  @ColumnInfo(name = "administrador") private var administrador: String){
    constructor(): this(0, "", 0.0, 0.0, "")
    constructor(nombre: String, longitud: Double, latitud: Double, administrador: String): this(0, nombre, longitud, latitud, administrador)

    fun setId(id: Int){
        this.id = id
    }

    fun getId(): Int{
        return id
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun getNombre(): String{
        return nombre
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
        return "Parada $nombre: Coordenadas: Longitud: $longitud, Latitud: $latitud"
    }
}