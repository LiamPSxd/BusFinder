package com.gammasoft.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta

@Entity(tableName = "RutaCoordenada",
        primaryKeys = ["ruta_ID", "coordenada_ID"],
        indices = [Index(value = ["ruta_ID"]), Index(value = ["coordenada_ID"])],
        foreignKeys = [
            ForeignKey(
                entity = Ruta::class,
                parentColumns = ["id"],
                childColumns = ["ruta_ID"]),
            ForeignKey(
                entity = Coordenada::class,
                parentColumns = ["id"],
                childColumns = ["coordenada_ID"])
        ])
data class RutaCoordenada(@ColumnInfo(name = "ruta_ID") private var rutaID: Int,
                     @ColumnInfo(name = "coordenada_ID") private var coordenadaID: Int){
    constructor(): this(0, 0)

    fun setRutaID(rutaID: Int){
        this.rutaID = rutaID
    }

    fun getRutaID(): Int{
        return rutaID
    }

    fun setCoordenadaID(coordenadaID: Int){
        this.coordenadaID = coordenadaID
    }

    fun getCoordenadaID(): Int{
        return coordenadaID
    }
}