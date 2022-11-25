package com.gammasoft.busfinder.view.fragment.visualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.TarjetaVisualizarChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class TarjetaChofer(private val fragment: TarjetaBase,
                    private val id: String): BaseBlurPopup(){
    private var _binding: TarjetaVisualizarChoferBinding? = null
    private val binding get() = _binding!!

    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = TarjetaChofer(fragment, id).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaVisualizarChoferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        var chofer = Chofer()

        localDB.getChoferByNombre(id).observe(viewLifecycleOwner){ ch ->
            binding.txtRFC.text = ch.getRfc()
            binding.txtNombre.text = ch.getNombre()
            binding.txtCelular.text = ch.getNumCelular().toString()
            binding.txtCalificacion.progress = ch.getCalificacion().toInt()
            chofer = ch
        }

        binding.btnBorrar.setOnClickListener{
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.borrar.TarjetaChofer(localDB, chofer).mostrar())
        }

        binding.btnModificar.setOnClickListener{
            fragment.pushPopup(com.gammasoft.busfinder.view.fragment.modificar.TarjetaChofer(localDB, chofer).mostrar())
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