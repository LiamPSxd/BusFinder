package com.gammasoft.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada
import com.gammasoft.busfinder.model.dbLocal.entidades.Unidad

@Entity(tableName = "UnidadCoordenada",
        primaryKeys = ["unidad_Placa", "coordenada_ID"],
        indices = [Index(value = ["unidad_Placa"]), Index(value = ["coordenada_ID"])],
        foreignKeys = [
            ForeignKey(
                entity = Unidad::class,
                parentColumns = ["placa"],
                childColumns = ["unidad_Placa"]),
            ForeignKey(
                entity = Coordenada::class,
                parentColumns = ["id"],
                childColumns = ["coordenada_ID"])
        ])
data class UnidadCoordenada(@ColumnInfo(name = "unidad_Placa") private var unidadPlaca: String,
                            @ColumnInfo(name = "coordenada_ID") private var coordenadaID: Int){
    constructor(): this("", 0)

    fun setUnidadPlaca(unidadPlaca: String){
        this.unidadPlaca = unidadPlaca
    }

    fun getUnidadPlaca(): String{
        return unidadPlaca
    }

    fun setCoordenadaID(coordenadaID: Int){
        this.coordenadaID = coordenadaID
    }

    fun getCoordenadaID(): Int{
        return coordenadaID
    }
}