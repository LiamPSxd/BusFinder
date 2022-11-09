package com.gammasoft.busfinder.model.dbLocal.relaciones

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.busfinder.model.dbLocal.entidades.Chofer
import com.example.busfinder.model.dbLocal.entidades.Horario
import com.example.busfinder.model.dbLocal.entidades.Ruta
import com.example.busfinder.model.dbLocal.entidades.Unidad

@Entity(tableName = "HorarioChoferUnidadRuta",
    primaryKeys = ["horario_ID", "chofer_Usuario", "unidad_Placa", "ruta_Ida_ID", "ruta_Venida_ID"],
    indices = [Index(value = ["horario_ID"]),
               Index(value = ["chofer_Usuario"]),
               Index(value = ["unidad_Placa"]),
               Index(value = ["ruta_Ida_ID"]),
               Index(value = ["ruta_Venida_ID"])],
    foreignKeys = [
        ForeignKey(
            entity = Horario::class,
            parentColumns = ["id"],
            childColumns = ["horario_ID"]),
        ForeignKey(
            entity = Chofer::class,
            parentColumns = ["usuario"],
            childColumns = ["chofer_Usuario"]),
        ForeignKey(
            entity = Unidad::class,
            parentColumns = ["placa"],
            childColumns = ["unidad_Placa"]),
        ForeignKey(
            entity = Ruta::class,
            parentColumns = ["id"],
            childColumns = ["ruta_Ida_ID"]),
        ForeignKey(
            entity = Ruta::class,
            parentColumns = ["id"],
            childColumns = ["ruta_Venida_ID"])
    ])
data class HorarioCUR(@ColumnInfo(name = "horario_ID") private var horarioId: Int,
                      @ColumnInfo(name = "chofer_Usuario") private var choferUsuario: String,
                      @ColumnInfo(name = "unidad_Placa") private var unidadPlaca: String,
                      @ColumnInfo(name = "ruta_Ida_ID") private var rutaIdaId: Int,
                      @ColumnInfo(name = "ruta_Venida_ID") private var rutaVenidaId: Int){
    constructor(): this(0, "", "", 0, 0)

    fun setHorarioId(horarioId: Int){
        this.horarioId = horarioId
    }

    fun getHorarioId(): Int{
        return horarioId
    }

    fun setChoferUsuario(choferUsuario: String){
        this.choferUsuario = choferUsuario
    }

    fun getChoferUsuario(): String{
        return choferUsuario
    }

    fun setUnidadPlaca(unidadPlaca: String){
        this.unidadPlaca = unidadPlaca
    }

    fun getUnidadPlaca(): String{
        return unidadPlaca
    }

    fun setRutaIdaId(rutaIdaId: Int){
        this.rutaIdaId = rutaIdaId
    }

    fun getRutaIdaId(): Int{
        return rutaIdaId
    }

    fun setRutaVenidaId(rutaVenidaId: Int){
        this.rutaVenidaId = rutaVenidaId
    }

    fun getRutaVenidaId(): Int{
        return rutaVenidaId
    }
}