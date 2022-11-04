package com.example.busfinder.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.example.busfinder.R
import com.example.busfinder.databinding.TarjetaAlertaBinding
import com.example.busfinder.view.util.withEnterAnim
import com.example.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class MensajeAlerta(private var titulo: String?,
                    private var mensaje: String?): BaseBlurPopup(){
    constructor(): this("", "")

    private var _binding: TarjetaAlertaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = MensajeAlerta().withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = TarjetaAlertaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.etqTitulo.text = titulo!!
        binding.txtMensaje.text = mensaje!!
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): View = binding.tarjeta

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}