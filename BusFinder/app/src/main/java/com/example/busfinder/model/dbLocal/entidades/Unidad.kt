package com.example.busfinder.model.dbLocal.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Unidad")
data class Unidad(@PrimaryKey @ColumnInfo(name = "placa")private var placa: String,
                  @ColumnInfo(name = "marca") private var marca: String,
                  @ColumnInfo(name = "com/example/mybus/model") private var modelo: String,
                  @ColumnInfo(name = "numero") private var numero: Int,
                  @ColumnInfo(name = "hora") private var hora: String,
                  @ColumnInfo(name = "fecha") private var fecha: String){
    constructor(): this("", "", "", 0, "", "")

    fun setPlaca(placa: String){
        this.placa = placa
    }

    fun getPlaca(): String{
        return placa
    }

    fun setMarca(marca: String){
        this.marca = marca
    }

    fun getMarca(): String{
        return marca
    }

    fun setModelo(modelo: String){
        this.modelo = modelo
    }

    fun getModelo(): String{
        return modelo
    }

    fun setNumero(numero: Int){
        this.numero = numero
    }

    fun getNumero(): Int{
        return numero
    }

    fun setHora(hora: String){
        this.hora = hora
    }

    fun getHora(): String{
        return hora
    }
    
    fun setFecha(fecha: String){
        this.fecha = fecha
    }

    fun getFecha(): String{
        return fecha
    }

    override fun toString(): String{
        return "Unidad con el Numero: $numero, Placa: $placa, Marca: $marca y Modelo: $modelo"
    }
}