package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Calle")
data class Calle(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name = "id") private var id: Int,
                 @ColumnInfo(name = "nombre") private var nombre: String){
    constructor(): this(0, "")

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

    override fun toString(): String{
        return "Calle $nombre"
    }
}