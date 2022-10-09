package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Horario")
data class Horario(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") private var id: Int,
                   @ColumnInfo(name = "hora_Entrada") private var horaEntrada: String,
                   @ColumnInfo(name = "hora_Salida") private var horaSalida: String,
                   @ColumnInfo(name = "fecha") private var fecha: String){
    constructor(): this(0, "", "", "")

    fun setId(id: Int){
        this.id = id
    }

    fun getId(): Int{
        return id
    }

    fun setHoraEntrada(horaEntrada: String){
        this.horaEntrada = horaEntrada
    }

    fun getHoraEntrada(): String{
        return horaEntrada
    }

    fun setHoraSalida(horaSalida: String){
        this.horaSalida = horaSalida
    }

    fun getHoraSalida(): String{
        return horaSalida
    }

    fun setFecha(fecha: String){
        this.fecha = fecha
    }

    fun getFecha(): String{
        return fecha
    }

    override fun toString(): String{
        return "Horario $id -> Hora de Entrada: $horaEntrada, Hora de Salida: $horaSalida, para la Fecha: $fecha"
    }
}