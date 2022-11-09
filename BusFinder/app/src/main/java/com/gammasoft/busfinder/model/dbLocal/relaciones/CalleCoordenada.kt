package com.gammasoft.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.Calle
import com.example.busfinder.model.dbLocal.entidades.Coordenada

@Entity(tableName = "CalleCoordenada",
        primaryKeys = ["calle_ID", "coordenada_ID"],
        indices = [Index(value = ["calle_ID"]), Index(value = ["coordenada_ID"])],
        foreignKeys = [
            ForeignKey(
                entity = Calle::class,
                parentColumns = ["id"],
                childColumns = ["calle_ID"]),
            ForeignKey(
                entity = Coordenada::class,
                parentColumns = ["id"],
                childColumns = ["coordenada_ID"])
        ])
data class CalleCoordenada(@ColumnInfo(name = "calle_ID") private var calleID: Int,
                           @ColumnInfo(name = "coordenada_ID") private var coordenadaID: Int){
    constructor(): this(0, 0)

    fun setCalleID(calleID: Int){
        this.calleID = calleID
    }

    fun getCalleID(): Int{
        return calleID
    }

    fun setCoordenadaID(coordenadaID: Int){
        this.coordenadaID = coordenadaID
    }

    fun getCoordenadaID(): Int{
        return coordenadaID
    }
}