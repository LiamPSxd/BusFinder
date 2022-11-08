package com.example.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.Parada
import com.example.busfinder.model.dbLocal.entidades.Ruta

@Entity(tableName = "RutaParada",
        primaryKeys = ["ruta_ID", "parada_ID"],
        indices = [Index(value = ["parada_ID"])],
        foreignKeys = [
            ForeignKey(
                entity = Ruta::class,
                parentColumns = ["id"],
                childColumns = ["ruta_ID"]),
            ForeignKey(
                entity = Parada::class,
                parentColumns = ["id"],
                childColumns = ["parada_ID"])
        ])
data class RutaParada(@ColumnInfo(name = "ruta_ID") private var rutaID: Int,
                      @ColumnInfo(name = "parada_ID") private var paradaID: Int){
    constructor(): this(0, 0)

    fun setRutaID(rutaID: Int){
        this.rutaID = rutaID
    }

    fun getRutaID(): Int{
        return rutaID
    }

    fun setParadaID(paradaID: Int){
        this.paradaID = paradaID
    }

    fun getParadaID(): Int{
        return paradaID
    }
}