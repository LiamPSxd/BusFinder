package com.example.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.Administrador
import com.example.busfinder.model.dbLocal.entidades.Cuenta

@Entity(tableName = "CuentaAdministrador",
        primaryKeys = ["cuenta_Correo", "administrador_Usuario"],
        indices = [Index(value = ["cuenta_Correo"]), Index(value = ["administrador_Usuario"])],
        foreignKeys = [
            ForeignKey(
                entity = Cuenta::class,
                parentColumns = ["correo"],
                childColumns = ["cuenta_Correo"]),
            ForeignKey(
                entity = Administrador::class,
                parentColumns = ["usuario"],
                childColumns = ["administrador_Usuario"])
        ])
data class CuentaAdministrador(@ColumnInfo(name = "cuenta_Correo") private var cuentaCorreo: String,
                               @ColumnInfo(name = "administrador_Usuario") private var adminUsuario: String){
    constructor(): this("", "")

    fun setCuentaCorreo(cuentaCorreo: String){
        this.cuentaCorreo = cuentaCorreo
    }

    fun getCuentaCorreo(): String{
        return cuentaCorreo
    }

    fun setAdminUsuario(adminUsuario: String){
        this.adminUsuario = adminUsuario
    }

    fun getAdminUsuario(): String{
        return adminUsuario
    }
}