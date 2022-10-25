package com.example.busfinder.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busfinder.databinding.TarjetaGeneralBinding

class GeneralCardAdapter(private var fondos: IntArray): RecyclerView.Adapter<GeneralCardAdapter.ViewHolder>(){
    private var titulos = arrayOf("Chofer", "Ruta", "Parada", "Tarifa")

    override fun onCreateViewHolder(vg: ViewGroup, i: Int): ViewHolder{
        return ViewHolder(TarjetaGeneralBinding.inflate(LayoutInflater.from(vg.context), vg, false))
    }

    override fun onBindViewHolder(vh: ViewHolder, i: Int){
        vh.binding.fondo.setImageResource(fondos[i])
        vh.binding.titulo.text = titulos[i]
    }

    override fun getItemCount(): Int{
        return fondos.size
    }

    inner class ViewHolder(var binding: TarjetaGeneralBinding): RecyclerView.ViewHolder(binding.root)
}