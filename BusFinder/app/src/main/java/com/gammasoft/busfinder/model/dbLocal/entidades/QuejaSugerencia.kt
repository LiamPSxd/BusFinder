package com.gammasoft.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SugerenciaQueja")
data class QuejaSugerencia(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") private var id: Int,
                           @ColumnInfo(name = "descripcion") private var descripcion: String,
                           @ColumnInfo(name = "usuario") private var usuario: String){
    constructor(descripcion: String, usuario: String): this(0, descripcion, usuario)

    fun setId(id: Int){
        this.id = id
    }

    fun getId(): Int{
        return id
    }

    fun setDescripcion(descripcion: String){
        this.descripcion = descripcion
    }

    fun getDescripcion(): String{
        return descripcion
    }

    fun setUsuario(usuario: String){
        this.usuario = usuario
    }

    fun getUsuario(): String{
        return usuario
    }

    override fun toString(): String{
        return "Sugerencia - Descripción: $descripcion - hecha por $usuario"
    }
}