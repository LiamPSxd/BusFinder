package com.gammasoft.busfinder.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gammasoft.busfinder.controller.longpress.PopupHoverEvento
import com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento
import com.gammasoft.busfinder.controller.longpress.PopupStateEvento
import com.gammasoft.busfinder.databinding.TarjetaQuejaSugerenciaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.DebouncingClickListener

class QuejaSugerenciaAdapter(private val fragment: TarjetaBase,
                             private val quSu: List<QuejaSugerencia>): RecyclerView.Adapter<QuejaSugerenciaAdapter.ViewHolder>(){
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(TarjetaQuejaSugerenciaBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, i: Int){
        holder.bind(quSu[i].getUsuario(), quSu[i].getDescripcion())
    }

    override fun getItemCount(): Int = quSu.size

    inner class ViewHolder(private val binding: TarjetaQuejaSugerenciaBinding): RecyclerView.ViewHolder(binding.root), DebouncingClickListener, PopupInflaterEvento , PopupStateEvento, PopupHoverEvento{
        fun bind(usuario: String, descripcion: String){
            itemView.run{
                binding.etqUsuario.text = usuario
                binding.eqtMensaje.text = descripcion
            }
        }

        override fun onDebouncingClick(view: View){}

        override fun onViewInflated(tag: String?, rootView: View?){}

        override fun onPopupShow(popupTag: String?){}

        override fun onPopupDismiss(popupTag: String?){}

        override fun onHoverChanged(view: View, isHovered: Boolean){}
    }
}