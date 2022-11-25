package com.gammasoft.busfinder.model.dbNube

class Codigo(private var id: String,
             private var valor: Long,
             private var estado: Boolean){
    fun setId(id: String){
        this.id = id
    }

    fun getId(): String{
        return id
    }

    fun setValor(valor: Long){
        this.valor = valor
    }

    fun getValor(): Long{
        return valor
    }

    fun setEstado(estado: Boolean){
        this.estado = estado
    }

    fun getEstado(): Boolean{
        return estado
    }
}