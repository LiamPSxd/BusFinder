package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentListaTarjetaBinding
import com.gammasoft.busfinder.view.adapter.TarjetaLista
import com.gammasoft.busfinder.view.dialog.BaseBlurPopup
import com.gammasoft.busfinder.view.util.withEnterAnim
import com.gammasoft.busfinder.view.util.withExitAnim
import io.alterac.blurkit.BlurLayout

class ListaTarjeta(private val fragment: TarjetaBase,
                   private val titulo: String,
                   private val ides: ArrayList<String>): BaseBlurPopup(){
    private var _binding: FragmentListaTarjetaBinding? = null
    private val binding get() = _binding!!

    fun mostrar(@AnimRes enterAnim: Int = R.anim.zoom_in,
                @AnimRes exitAnim: Int = R.anim.zoom_out) = ListaTarjeta(fragment, titulo, ides).withEnterAnim(enterAnim).withExitAnim(exitAnim)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentListaTarjetaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.cabecera.text = titulo
        binding.recyclerView.adapter = TarjetaLista(fragment, titulo, ides)
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    override fun getBlurLayout(): BlurLayout = binding.blurLayout

    override fun getDragHandle(): View = binding.dragArea

    override fun getRootView(): ViewGroup = binding.lista

    override fun getBackgroundLayout(): ViewGroup = binding.blurLayout
}