package com.example.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.Chofer
import com.example.busfinder.model.dbLocal.entidades.Cuenta

@Entity(tableName = "CuentaChofer",
        primaryKeys = ["cuenta_Correo", "chofer_Usuario"],
        indices = [Index(value = ["chofer_Usuario"])],
        foreignKeys = [
            ForeignKey(
                entity = Cuenta::class,
                parentColumns = ["correo"],
                childColumns = ["cuenta_Correo"]),
            ForeignKey(
                entity = Chofer::class,
                parentColumns = ["usuario"],
                childColumns = ["chofer_Usuario"])
        ])
data class CuentaChofer(@ColumnInfo(name = "cuenta_Correo") private var cuentaCorreo: String,
                        @ColumnInfo(name = "chofer_Usuario") private var choferUsuario: String){
    fun setCuentaCorreo(cuentaCorreo: String){
        this.cuentaCorreo = cuentaCorreo
    }

    fun getCuentaCorreo(): String{
        return cuentaCorreo
    }

    fun setChoferUsuario(choferUsuario: String){
        this.choferUsuario = choferUsuario
    }

    fun getChoferUsuario(): String{
        return choferUsuario
    }
}