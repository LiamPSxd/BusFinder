package com.example.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.Coordenada
import com.example.busfinder.model.dbLocal.entidades.Unidad

@Entity(tableName = "UnidadCoordenada",
        primaryKeys = ["unidad_Placa", "coordenada_ID"],
        indices = [Index(value = ["coordenada_ID"])],
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
                            @ColumnInfo(name = "coordenada_ID") private var coorID: Int){
    fun setUnidadPlaca(unidadPlaca: String){
        this.unidadPlaca = unidadPlaca
    }

    fun getUnidadPlaca(): String{
        return unidadPlaca
    }

    fun setCoorID(coorID: Int){
        this.coorID = coorID
    }

    fun getCoorID(): Int{
        return coorID
    }
}