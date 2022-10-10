package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Chofer")
data class Chofer(@PrimaryKey @ColumnInfo(name = "usuario") private var usuario: String,
                  @ColumnInfo(name = "rfc") private var rfc: String,
                  @ColumnInfo(name = "nombre") private var nombre: String,
                  @ColumnInfo(name = "numero_Celular") private var numCelular: Long,
                  @ColumnInfo(name = "noUsuarios") private var noUsuarios: Int,
                  @ColumnInfo(name = "calificacion") private var calificacion: Double){
    constructor(): this("", "", "", 0, 0, 0.0)

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

    fun setNoUsuarios(noUsuarios: Int){
        this.noUsuarios = noUsuarios
    }

    fun getNoUsuarios(): Int{
        return noUsuarios
    }

    fun setCalificacion(valor: Double){
        calificacion = ((calificacion*getNoUsuarios()) + valor)
        setNoUsuarios(getNoUsuarios() + 1)
        calificacion /= noUsuarios
    }

    fun getCalificacion(): Double{
        return calificacion
    }

    override fun toString(): String{
        return "Cuenta Chofer / RFC: $rfc, Nombre: $nombre, Numero de Celular: $numCelular"
    }
}