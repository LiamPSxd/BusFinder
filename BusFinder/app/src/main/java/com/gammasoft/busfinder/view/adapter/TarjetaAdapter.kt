package com.gammasoft.busfinder.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.longpress.PopupHoverEvento
import com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento
import com.gammasoft.busfinder.controller.longpress.PopupStateEvento
import com.gammasoft.busfinder.databinding.TarjetaTituloBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_BOTTOM
import com.gammasoft.busfinder.view.dialog.BlurPopup
import com.gammasoft.busfinder.view.dialog.MensajeBlur
import com.gammasoft.busfinder.view.fragment.ListaTarjeta
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.DebouncingClickListener
import com.gammasoft.busfinder.view.util.checkAndUnregister
import com.gammasoft.busfinder.view.util.onDebouncingClick
import com.squareup.picasso.Picasso

class TarjetaAdapter(private val fragment: TarjetaBase,
                     private val titulos: ArrayList<String>,
                     private val fondos: ArrayList<Int>): RecyclerView.Adapter<TarjetaAdapter.ViewHolder>(){
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TarjetaTituloBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, i: Int) =
        holder.bind(titulos[i], fondos[i])

    override fun getItemCount(): Int = titulos.size

    inner class ViewHolder(private val binding: TarjetaTituloBinding): RecyclerView.ViewHolder(binding.root), DebouncingClickListener, PopupInflaterEvento , PopupStateEvento, PopupHoverEvento{
        private var longPressBlurPopup: BlurPopup? = null

        fun bind(titulo: String, fondo: Int){
            longPressBlurPopup.checkAndUnregister()

            itemView.run{
                binding.txtTitulo.text = titulo
                binding.tarjeta.onDebouncingClick(this@ViewHolder)
                Picasso.get().load(fondo).into(binding.image)

                longPressBlurPopup = BlurPopup.Builder
                    .with(fragment)
                    .targetView(binding.tarjeta)
                    .baseBlurPopup(MensajeBlur("CONSEJO", "Para ver $titulo toque la tarjeta").mostrar())
                    .animationType(ANIM_FROM_BOTTOM)
                    .popupStateListener(this@ViewHolder)
                    .hoverListener(this@ViewHolder)
                    .build()
            }

            longPressBlurPopup?.register()
        }

        override fun onDebouncingClick(view: View){
            val ides = ArrayList<String>()

            when(binding.txtTitulo.text){
                "CHOFERES" -> {
                    localDB.getChoferes().observe(fragment){
                        for(chofer in it) ides.add(chofer.getNombre())
                    }

                    fragment.pushPopup(ListaTarjeta(fragment, "Choferes", ides).mostrar(R.anim.float_up, R.anim.float_down))
                }

                "RUTAS" -> {
                    localDB.getRutas().observe(fragment){
                        for(ruta in it) ides.add(ruta.getNombre())
                    }

                    fragment.pushPopup(ListaTarjeta(fragment, "Rutas", ides).mostrar(R.anim.float_up, R.anim.float_down))
                }

                "PARADAS" -> {
                    localDB.getParadas().observe(fragment){
                        for(parada in it) ides.add(parada.getNombre())
                    }

                    fragment.pushPopup(ListaTarjeta(fragment, "Paradas", ides).mostrar(R.anim.float_up, R.anim.float_down))
                }

                "TARIFAS" -> {
                    localDB.getTarifas().observe(fragment){
                        for(tarifa in it) ides.add(tarifa.getNombre())
                    }

                    fragment.pushPopup(ListaTarjeta(fragment, "Tarifas", ides).mostrar(R.anim.float_up, R.anim.float_down))
                }
            }
        }

        override fun onViewInflated(tag: String?, rootView: View?){}

        override fun onPopupShow(popupTag: String?){}

        override fun onPopupDismiss(popupTag: String?){}

        override fun onHoverChanged(view: View, isHovered: Boolean){}
    }
}