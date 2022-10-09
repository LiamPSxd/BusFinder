package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Administrador")
data class Administrador(@PrimaryKey @ColumnInfo(name = "usuario") private var usuario: String,
                         @ColumnInfo(name = "rfc") private var rfc: String,
                         @ColumnInfo(name = "nombre") private var nombre: String,
                         @ColumnInfo(name = "numero_Celular") private var numCelular: Long,
                         @ColumnInfo(name = "codigo") private var codigo: String){
    constructor(): this("", "", "", 0, "")

    fun setUsuario(usuario: String){
        this.usuario = usuario
    }

    fun getUsuario(): String{
        return usuario
    }

    fun setRfc(rfc: String){
        this.rfc = rfc
    }

    fun getRfc(): String{
        return rfc
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun getNombre(): String{
        return nombre
    }

    fun setNumCelular(numCelular: Long){
        this.numCelular = numCelular
    }

    fun getNumCelular(): Long{
        return numCelular
    }

    fun setCodigo(codigo: String){
        this.codigo = codigo
    }

    fun getCodigo(): String{
        return codigo
    }

    override fun toString(): String{
        return "Cuenta Administrador / RFC: $rfc, Nombre: $nombre, Numero de Celular: $numCelular"
    }
}