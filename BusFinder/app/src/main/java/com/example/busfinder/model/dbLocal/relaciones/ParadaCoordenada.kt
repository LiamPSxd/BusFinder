package com.example.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.Coordenada
import com.example.busfinder.model.dbLocal.entidades.Parada

@Entity(tableName = "ParadaCoordenada",
        primaryKeys = ["parada_ID", "coordenada_ID"],
        indices = [Index(value = ["coordenada_ID"])],
        foreignKeys = [
            ForeignKey(
                entity = Parada::class,
                parentColumns = ["id"],
                childColumns = ["parada_ID"]),
            ForeignKey(
                entity = Coordenada::class,
                parentColumns = ["id"],
                childColumns = ["coordenada_ID"])
        ])
data class ParadaCoordenada(@ColumnInfo(name = "parada_ID") private var paradaID: Int,
                            @ColumnInfo(name = "coordenada_ID") private var coordenadaID: Int){
    fun setParadaID(paradaID: Int){
        this.paradaID = paradaID
    }

    fun getParadaID(): Int{
        return paradaID
    }

    fun setCoordenadaID(coordenadaID: Int){
        this.coordenadaID = coordenadaID
    }

    fun getCoordenadaID(): Int{
        return coordenadaID
    }
}