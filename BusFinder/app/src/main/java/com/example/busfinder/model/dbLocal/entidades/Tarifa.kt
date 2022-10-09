package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tarifa")
data class Tarifa(@PrimaryKey @ColumnInfo(name = "nombre") private var nombre: String,
                  @ColumnInfo(name = "precio") private var precio: Double){
    constructor(): this("", 0.0)

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun getNombre(): String{
        return nombre
    }

    fun setPrecio(precio: Double){
        this.precio = precio
    }

    fun getPrecio(): Double{
        return precio
    }

    override fun toString(): String{
        return "Tarifa de $nombre con un Coste de $precio"
    }
}