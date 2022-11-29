package com.gammasoft.busfinder.view.fragment.visualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaVisualizarTarifaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.vibrate
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class TarjetaTarifa(private val fragment: TarjetaBase,
                    private val titulo: String,
                    private val id: String): BaseBlurPopup(){
    private var _binding: TarjetaVisualizarTarifaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaTarifa(fragment, titulo, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaVisualizarTarifaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

        var tarifa = Tarifa()
        localDB.getTarifas().observe(viewLifecycleOwner){
            for(ta in it) if(ta.getNombre() == titulo && ta.getNombre() == id){
                binding.txtPublico.text = ta.getNombre()
                val precio = "${ta.getPrecio()} MXN"
                binding.txtPrecio.text = precio
                tarifa = ta
                break
            }
        }

        binding.btnBorrar.setOnClickListener{
            fragment.context?.vibrate(70L)
            dismiss()
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaTarifa(localDB, tarifa).mostrar())
        }

        binding.btnModificar.setOnClickListener{
            fragment.context?.vibrate(60L)
            dismiss()
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaTarifa(localDB, tarifa).mostrar())
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): View = binding.tarjeta

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout
}