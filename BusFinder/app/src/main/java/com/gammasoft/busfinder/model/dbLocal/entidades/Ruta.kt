package com.gammasoft.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ruta")
data class Ruta(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") private var id: Int,
                @ColumnInfo(name = "nombre") private var nombre: String,
                @ColumnInfo(name = "administrador") private var administrador: String){
    constructor(): this(0, "", "")
    constructor(nombre: String, administrador: String): this(0, nombre, administrador)

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

    fun setAdministrador(administrador: String){
        this.administrador = administrador
    }

    fun getAdministrador(): String{
        return administrador
    }

    override fun toString(): String{
        return "Ruta $nombre"
    }
}