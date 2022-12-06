package com.gammasoft.busfinder.view.fragment.visualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.databinding.TarjetaVisualizarTarifaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.vibrate
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class TarjetaTarifa(private val fragment: TarjetaBase,
                    private val bin: FragmentAdministradorBinding,
                    private val id: String): BaseBlurPopup(){
    private var _binding: TarjetaVisualizarTarifaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaTarifa(fragment, bin, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

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

        bin.btnAgregar.visibility = View.GONE

        localDB.getTarifaByNombre(id).observe(viewLifecycleOwner){ ta ->
            if(ta != null){
                binding.txtPublico.text = ta.getNombre()
                val precio = "${ta.getPrecio()} MXN"
                binding.txtPrecio.text = precio

                binding.btnBorrar.setOnClickListener{
                    fragment.context?.vibrate(80L)
                    fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaTarifa(localDB, bin, ta).mostrar())
                    dismiss()
                }

                binding.btnModificar.setOnClickListener{
                    fragment.context?.vibrate(50L)
                    fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaTarifa(localDB, bin, ta).mostrar())
                    dismiss()
                }
            }
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        bin.btnAgregar.visibility = View.VISIBLE
        _binding = null
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): View = binding.tarjeta

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout
}