package com.gammasoft.busfinder.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.longpress.PopupHoverEvento
import com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento
import com.gammasoft.busfinder.controller.longpress.PopupStateEvento
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaListaBinding
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.fragment.visualizar.TarjetaChofer
import com.gammasoft.busfinder.view.fragment.visualizar.TarjetaParada
import com.gammasoft.busfinder.view.fragment.visualizar.TarjetaRuta
import com.gammasoft.busfinder.view.fragment.visualizar.TarjetaTarifa
import com.gammasoft.busfinder.view.util.DebouncingClickListener
import com.gammasoft.busfinder.view.util.onDebouncingClick

class TarjetaLista(private val fragment: TarjetaBase,
                   private val bin: FragmentAdministradorBinding,
                   private val tipo: String,
                   private val ides: ArrayList<List<String>>): RecyclerView.Adapter<TarjetaLista.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TarjetaListaBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, i: Int){
        holder.bind(ides[i][0], ides[i][1], (i+1).toString())
    }

    override fun getItemCount(): Int = ides.size

    inner class ViewHolder(private val binding: TarjetaListaBinding): RecyclerView.ViewHolder(binding.root), DebouncingClickListener, PopupInflaterEvento, PopupStateEvento, PopupHoverEvento{
        private var id = ""

        fun bind(id: String, titulo: String, contador: String){
            this.id = id

            itemView.run{
                binding.pin.text = if(id == "Nada que mostrar") id else contador
                binding.etqNombre.text = titulo
                binding.tarjeta.onDebouncingClick(this@ViewHolder)
            }
        }

        override fun onDebouncingClick(view: View){
            val titulo = binding.etqNombre.text.toString()

            when(tipo){
                "CHOFERES" -> fragment.pushPopup(TarjetaChofer(fragment, bin, titulo, id).mostrar(R.anim.zoom_in, R.anim.zoom_out))

                "RUTAS" -> fragment.pushPopup(TarjetaRuta(fragment, bin, titulo, id).mostrar(R.anim.zoom_in, R.anim.zoom_out))

                "PARADAS" -> fragment.pushPopup(TarjetaParada(fragment, bin, titulo, id).mostrar(R.anim.zoom_in, R.anim.zoom_out))

                "TARIFAS" -> fragment.pushPopup(TarjetaTarifa(fragment, bin, id).mostrar(R.anim.zoom_in, R.anim.zoom_out))
            }
        }

        override fun onViewInflated(tag: String?, rootView: View?){}

        override fun onPopupShow(popupTag: String?){}

        override fun onPopupDismiss(popupTag: String?){}

        override fun onHoverChanged(view: View, isHovered: Boolean){}
    }
}