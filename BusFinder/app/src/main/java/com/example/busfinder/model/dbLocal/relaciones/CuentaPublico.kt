package com.example.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.PublicoGeneral
import com.example.busfinder.model.dbLocal.entidades.Cuenta

@Entity(tableName = "CuentaPublico",
        primaryKeys = ["cuenta_Correo", "publico_General_Usuario"],
        indices = [Index(value = ["publico_General_Usuario"])],
        foreignKeys = [
            ForeignKey(
                entity = Cuenta::class,
                parentColumns = ["correo"],
                childColumns = ["cuenta_Correo"]),
            ForeignKey(
                entity = PublicoGeneral::class,
                parentColumns = ["usuario"],
                childColumns = ["publico_General_Usuario"])
        ])
data class CuentaPublico(@ColumnInfo(name = "cuenta_Correo") private var cuentaCorreo: String,
                         @ColumnInfo(name = "publico_General_Usuario") private var publicoUsuario: String){
    fun setCuentaCorreo(cuentaCorreo: String){
        this.cuentaCorreo = cuentaCorreo
    }

    fun getCuentaCorreo(): String{
        return cuentaCorreo
    }

    fun setPublicoUsuario(publicoUsuario: String){
        this.publicoUsuario = publicoUsuario
    }

    fun getPublicoUsuario(): String{
        return publicoUsuario
    }
}