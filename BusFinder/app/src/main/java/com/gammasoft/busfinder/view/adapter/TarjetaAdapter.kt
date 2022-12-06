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
import com.gammasoft.busfinder.databinding.TarjetaTituloBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.view.fragment.ListaTarjeta
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.DebouncingClickListener
import com.gammasoft.busfinder.view.util.onDebouncingClick
import com.squareup.picasso.Picasso

class TarjetaAdapter(private val fragment: TarjetaBase,
                     private val bin: FragmentAdministradorBinding,
                     private val titulos: ArrayList<String>,
                     private val fondos: ArrayList<Int>): RecyclerView.Adapter<TarjetaAdapter.ViewHolder>(){
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TarjetaTituloBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, i: Int) =
        holder.bind(titulos[i], fondos[i])

    override fun getItemCount(): Int = titulos.size

    inner class ViewHolder(private val binding: TarjetaTituloBinding): RecyclerView.ViewHolder(binding.root), DebouncingClickListener, PopupInflaterEvento , PopupStateEvento, PopupHoverEvento{
        //private var longPressBlurPopup: BlurPopup? = null

        fun bind(titulo: String, fondo: Int){
            //longPressBlurPopup.checkAndUnregister()

            itemView.run{
                binding.txtTitulo.text = titulo
                binding.tarjeta.onDebouncingClick(this@ViewHolder)
                Picasso.get().load(fondo).into(binding.image)

                /*longPressBlurPopup = BlurPopup.Builder
                    .with(fragment)
                    .targetView(binding.tarjeta)
                    .baseBlurPopup(MensajeBlur("CONSEJO", "Para ver $titulo toque la tarjeta").mostrar())
                    .animationType(ANIM_FROM_BOTTOM)
                    .popupStateListener(this@ViewHolder)
                    .hoverListener(this@ViewHolder)
                    .build()*/
            }

            //longPressBlurPopup?.register()
        }

        override fun onDebouncingClick(view: View){
            when(val titulo = binding.txtTitulo.text.toString()){
                "CHOFERES" -> fragment.pushPopup(ListaTarjeta(fragment, bin, titulo, localDB).mostrar(R.anim.float_up, R.anim.float_down))

                "RUTAS" -> fragment.pushPopup(ListaTarjeta(fragment, bin, titulo, localDB).mostrar(R.anim.float_up, R.anim.float_down))

                "PARADAS" -> fragment.pushPopup(ListaTarjeta(fragment, bin, titulo, localDB).mostrar(R.anim.float_up, R.anim.float_down))

                "TARIFAS" -> fragment.pushPopup(ListaTarjeta(fragment, bin, titulo, localDB).mostrar(R.anim.float_up, R.anim.float_down))
            }
        }

        override fun onViewInflated(tag: String?, rootView: View?){}

        override fun onPopupShow(popupTag: String?){}

        override fun onPopupDismiss(popupTag: String?){}

        override fun onHoverChanged(view: View, isHovered: Boolean){}
    }
}