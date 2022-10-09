package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Chofer")
data class Chofer(@PrimaryKey @ColumnInfo(name = "usuario") private var usuario: String,
                  @ColumnInfo(name = "rfc") private var rfc: String,
                  @ColumnInfo(name = "nombre") private var nombre: String,
                  @ColumnInfo(name = "numero_Celular") private var numCelular: Long){
    constructor(): this("", "", "", 0)

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

    override fun toString(): String{
        return "Cuenta Chofer / RFC: $rfc, Nombre: $nombre, Numero de Celular: $numCelular"
    }
}