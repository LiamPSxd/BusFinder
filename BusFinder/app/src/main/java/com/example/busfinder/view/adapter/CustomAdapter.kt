package com.example.busfinder.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busfinder.R
import com.example.busfinder.databinding.TarjetaVisualizarChoferBinding

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    private var images = intArrayOf(R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground)
    private var names = arrayOf("Jorge A. Fuentes de Jesús", "Ameyalli Huerta Mendoza", "Breayan Méndez Trujillo", "Denilson Pérez Cortina", "Liam I. Pérez Sulvarán")
    private var ratings = arrayOf("4.8/5", "5/5", "4.9/5", "4.9/5", "5/5")

    override fun onCreateViewHolder(vg: ViewGroup, i: Int): ViewHolder{
        return ViewHolder(TarjetaVisualizarChoferBinding.inflate(LayoutInflater.from(vg.context), vg, false))
    }

    override fun onBindViewHolder(vh: ViewHolder, i: Int){
        vh.binding.itemImage.setImageResource(images[i])
        vh.binding.nombreChofer.text = names[i]
        vh.binding.calificacion.text = ratings[i]
    }

    override fun getItemCount(): Int{
        return images.size
    }

    inner class ViewHolder(var binding: TarjetaVisualizarChoferBinding): RecyclerView.ViewHolder(binding.root)
}