package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cuenta")
data class Cuenta(@PrimaryKey @ColumnInfo(name = "correo") private var correo: String,
                  @ColumnInfo(name = "contrasenia") private var contrasenia: String,
                  @ColumnInfo(name = "foto") private var foto: Int?,
                  @ColumnInfo(name = "tipo") private var tipo: Int,
                  @ColumnInfo(name = "estado") private var estado: Boolean){
    constructor(): this("", "", 0, 3, true)

    fun setCorreo(correo: String){
        this.correo = correo
    }

    fun getCorreo(): String{
        return correo
    }

    fun setContrasenia(contrasenia: String){
        this.contrasenia = contrasenia
    }

    fun getContrasenia(): String{
        return contrasenia
    }

    fun setFoto(foto: Int){
        this.foto = foto
    }

    fun getFoto(): Int?{
        return foto
    }

    fun setTipo(tipo: Int){
        this.tipo = tipo
    }

    fun getTipo(): Int{
        return tipo
    }

    fun mostrarTipo(): String{
        return when(tipo){
            0 -> "Administrador"
            1 -> "Chofer"
            2 -> "Publico General"
            else -> "Error"
        }
    }

    fun setEstado(estado: Boolean){
        this.estado = estado
    }

    fun getEstado(): Boolean{
        return estado
    }

    override fun toString(): String{
        return "Cuenta del correo: $correo; de Tipo: ${mostrarTipo()}"
    }
}