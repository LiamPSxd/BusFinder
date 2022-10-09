package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cuenta")
data class Cuenta(@PrimaryKey @ColumnInfo(name = "correo") private var correo: String,
                  @ColumnInfo(name = "contrasenia") private var contrasenia: String,
                  @ColumnInfo(name = "tipo") private var tipo: Int){
    constructor(): this("", "", 3)

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

    override fun toString(): String{
        return "Cuenta del correo: $correo; de Tipo: ${mostrarTipo()}"
    }
}