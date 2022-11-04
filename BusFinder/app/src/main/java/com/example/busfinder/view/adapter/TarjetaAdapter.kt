package com.example.busfinder.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busfinder.controller.longpress.PopupHoverEvento
import com.example.busfinder.controller.longpress.PopupInflaterEvento
import com.example.busfinder.controller.longpress.PopupStateEvento
import com.example.busfinder.databinding.TarjetaTituloBinding
import com.example.busfinder.view.activity.TarjetaBase
import com.example.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_BOTTOM
import com.example.busfinder.view.dialog.BlurPopup
import com.example.busfinder.view.dialog.MensajeAlerta
import com.example.busfinder.view.fragment.*
import com.example.busfinder.view.util.DebouncingClickListener
import com.example.busfinder.view.util.checkAndUnregister
import com.example.busfinder.view.util.onDebouncingClick

class TarjetaAdapter(private val fragment: TarjetaBase,
                     private val titulos: ArrayList<String>,
                     private val colores: ArrayList<Int>,
                     private val fondos: ArrayList<Int>): RecyclerView.Adapter<TarjetaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TarjetaTituloBinding.inflate(LayoutInflater.from(parent.context), parent, false), fragment)

    override fun onBindViewHolder(holder: ViewHolder, i: Int) =
        holder.bind(titulos[i], colores[i], fondos[i])

    override fun getItemCount(): Int = titulos.size

    inner class ViewHolder(var binding: TarjetaTituloBinding, private val fragment: TarjetaBase): RecyclerView.ViewHolder(binding.root), DebouncingClickListener, PopupInflaterEvento , PopupStateEvento, PopupHoverEvento{
        private var longPressBlurPopup: BlurPopup? = null

        fun bind(titulo: String, color: Int, fondo: Int){
            longPressBlurPopup.checkAndUnregister()

            binding.txtTitulo.text = titulo
            binding.tarjeta.setBackgroundColor(color)
            binding.image.setImageResource(fondo)
            //Picasso.get().load(tile.imageUrl).into(cardThumb)
            binding.tarjeta.onDebouncingClick(this@ViewHolder)

            longPressBlurPopup = BlurPopup.Builder
                .with(fragment)
                .targetView(binding.tarjeta)
                .baseBlurPopup(MensajeAlerta().mostrar())
                .animationType(ANIM_FROM_BOTTOM)
                .popupStateListener(this@ViewHolder)
                .hoverListener(this@ViewHolder)
                .build()

            longPressBlurPopup?.register()
        }

        override fun onDebouncingClick(view: View){
            when(fragment){
                VisualizarAdministrador() -> fragment.pushFragment(ListaTarjeta(binding.txtTitulo.text.toString(), binding.tarjeta.background.toString().toInt()).newInstance(true))

                AgregarAdministrador() -> fragment.pushFragment(TarjetaAgregar(AgregarAdministrador(), binding.txtTitulo.text.toString()))

                BorrarAdministrador() -> fragment.pushFragment(TarjetaBorrar(BorrarAdministrador(), binding.txtTitulo.text.toString()))

                    /*"Ruta" -> activity.pushFragment(ListOfCardsContainerFragment())
                    view.context.getString(R.string.plain_card) -> activity.pushFragment(PlainCardFragment())
                    view.context.getString(R.string.blur_popup_zoom) -> activity.pushPopup(SampleBlurPopup.newInstance(R.anim.zoom_in, R.anim.zoom_out))
                    view.context.getString(R.string.blur_popup_float_up) -> activity.pushPopup(SampleBlurPopup.newInstance(R.anim.float_up, R.anim.sink_down))*/
            }
        }

        override fun onViewInflated(tag: String?, rootView: View?){}

        override fun onPopupShow(popupTag: String?){}

        override fun onPopupDismiss(popupTag: String?){}

        override fun onHoverChanged(view: View, isHovered: Boolean){}
    }
}