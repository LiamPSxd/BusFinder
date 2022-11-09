package com.gammasoft.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.Cuenta
import com.example.busfinder.model.dbLocal.entidades.PublicoGeneral

@Entity(tableName = "CuentaPublico",
        primaryKeys = ["cuenta_Correo", "publico_General_Usuario"],
        indices = [Index(value = ["cuenta_Correo"]), Index(value = ["publico_General_Usuario"])],
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
    constructor(): this("", "")

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