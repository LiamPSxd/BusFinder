package com.gammasoft.busfinder.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.longpress.PopupHoverEvento
import com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento
import com.gammasoft.busfinder.controller.longpress.PopupStateEvento
import com.gammasoft.busfinder.databinding.TarjetaListaBinding
import com.gammasoft.busfinder.view.dialog.AnimType
import com.gammasoft.busfinder.view.dialog.BlurPopup
import com.gammasoft.busfinder.view.dialog.MensajeBlur
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.fragment.visualizar.TarjetaChofer
import com.gammasoft.busfinder.view.fragment.visualizar.TarjetaParada
import com.gammasoft.busfinder.view.fragment.visualizar.TarjetaRuta
import com.gammasoft.busfinder.view.fragment.visualizar.TarjetaTarifa
import com.gammasoft.busfinder.view.util.DebouncingClickListener
import com.gammasoft.busfinder.view.util.checkAndUnregister
import com.gammasoft.busfinder.view.util.onDebouncingClick

class TarjetaLista(private val fragment: TarjetaBase,
                   private val tipo: String,
                   private val ides: ArrayList<String>): RecyclerView.Adapter<TarjetaLista.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TarjetaListaBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, i: Int){
        if(i >= 0) holder.bind(ides[i], (i+1).toString())
        else holder.bind("Agregue un dato para mostrarlo", "Nada que mostrar")
    }

    override fun getItemCount(): Int = ides.size

    inner class ViewHolder(private val binding: TarjetaListaBinding): RecyclerView.ViewHolder(binding.root), DebouncingClickListener, PopupInflaterEvento, PopupStateEvento, PopupHoverEvento{
        private var longPressBlurPopup: BlurPopup? = null

        fun bind(titulo: String, contador: String){
            longPressBlurPopup.checkAndUnregister()

            itemView.run{
                binding.pin.text = contador
                binding.etqNombre.text = titulo
                binding.tarjeta.onDebouncingClick(this@ViewHolder)

                longPressBlurPopup = BlurPopup.Builder
                    .with(fragment)
                    .targetView(binding.tarjeta)
                    .baseBlurPopup(MensajeBlur(contador, titulo).mostrar())
                    .animationType(AnimType.ANIM_FROM_BOTTOM)
                    .popupStateListener(this@ViewHolder)
                    .hoverListener(this@ViewHolder)
                    .build()
            }

            longPressBlurPopup?.register()
        }

        override fun onDebouncingClick(view: View){
            val id = binding.etqNombre.text.toString()

            when(tipo){
                "CHOFERES" -> fragment.pushPopup(TarjetaChofer(fragment, id).mostrar(R.anim.zoom_in, R.anim.zoom_out))

                "RUTAS" -> fragment.pushPopup(TarjetaRuta(fragment, id).mostrar(R.anim.zoom_in, R.anim.zoom_out))

                "PARADAS" -> fragment.pushPopup(TarjetaParada(fragment, id).mostrar(R.anim.zoom_in, R.anim.zoom_out))

                "TARIFAS" -> fragment.pushPopup(TarjetaTarifa(fragment, id).mostrar(R.anim.zoom_in, R.anim.zoom_out))
            }
        }

        override fun onViewInflated(tag: String?, rootView: View?){}

        override fun onPopupShow(popupTag: String?){}

        override fun onPopupDismiss(popupTag: String?){}

        override fun onHoverChanged(view: View, isHovered: Boolean){}
    }
}