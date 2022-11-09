package com.gammasoft.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.gammasoft.busfinder.model.dbLocal.entidades.Calle
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta

@Entity(tableName = "RutaCalle",
        primaryKeys = ["ruta_ID", "calle_ID"],
        indices = [Index(value = ["ruta_ID"]), Index(value = ["calle_ID"])],
        foreignKeys = [
            ForeignKey(
                entity = Ruta::class,
                parentColumns = ["id"],
                childColumns = ["ruta_ID"]),
            ForeignKey(
                entity = Calle::class,
                parentColumns = ["id"],
                childColumns = ["calle_ID"])
        ])
data class RutaCalle(@ColumnInfo(name = "ruta_ID") private var rutaID: Int,
                     @ColumnInfo(name = "calle_ID") private var calleID: Int){
    constructor(): this(0, 0)

    fun setRutaID(rutaID: Int){
        this.rutaID = rutaID
    }

    fun getRutaID(): Int{
        return rutaID
    }

    fun setCalleID(calleID: Int){
        this.calleID = calleID
    }

    fun getCalleID(): Int{
        return calleID
    }
}