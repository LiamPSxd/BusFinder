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
            val ides = ArrayList<List<String>>()

            fragment.parentFragmentManager.setFragmentResultListener("Administrador", fragment){ _, bundle ->
                val rfc = bundle.getString("administrador").toString()

                when(val titulo = binding.txtTitulo.text.toString()){
                    "CHOFERES" -> {
                        localDB.getChoferesByAdministrador(rfc).observe(fragment){
                            for(chofer in it) ides.add(listOf(chofer.getRfc(), chofer.getNombre()))
                        }

                        fragment.pushPopup(ListaTarjeta(fragment, bin, titulo, ides).mostrar(R.anim.float_up, R.anim.float_down))
                    }

                    "RUTAS" -> {
                        localDB.getRutasByAdministrador(rfc).observe(fragment){
                            for(ruta in it) ides.add(listOf(ruta.getId().toString(), ruta.getNombre()))
                        }

                        fragment.pushPopup(ListaTarjeta(fragment, bin, titulo, ides).mostrar(R.anim.float_up, R.anim.float_down))
                    }

                    "PARADAS" -> {
                        localDB.getParadasByAdministrador(rfc).observe(fragment){
                            for(parada in it) ides.add(listOf(parada.getId().toString(), parada.getNombre()))
                        }

                        fragment.pushPopup(ListaTarjeta(fragment, bin, titulo, ides).mostrar(R.anim.float_up, R.anim.float_down))
                    }

                    "TARIFAS" -> {
                        localDB.getTarifasByAdministrador(rfc).observe(fragment){
                            for(tarifa in it) ides.add(listOf(tarifa.getNombre(), tarifa.getNombre()))
                        }

                        fragment.pushPopup(ListaTarjeta(fragment, bin, titulo, ides).mostrar(R.anim.float_up, R.anim.float_down))
                    }
                }
            }
        }

        override fun onViewInflated(tag: String?, rootView: View?){}

        override fun onPopupShow(popupTag: String?){}

        override fun onPopupDismiss(popupTag: String?){}

        override fun onHoverChanged(view: View, isHovered: Boolean){}
    }
}