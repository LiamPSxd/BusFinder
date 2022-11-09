package com.gammasoft.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PublicoGeneral")
data class PublicoGeneral(@PrimaryKey @ColumnInfo(name = "usuario") private var usuario: String){
    constructor(): this("")

    fun setUsuario(usuario: String){
        this.usuario = usuario
    }

    fun getUsuario(): String{
        return usuario
    }

    override fun toString(): String{
        return "Cuenta Publico General / Usuario: $usuario"
    }
}