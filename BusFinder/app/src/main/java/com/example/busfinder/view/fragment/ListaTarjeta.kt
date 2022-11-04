package com.example.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.busfinder.databinding.FragmentListaTarjetaBinding
import com.example.busfinder.view.adapter.TarjetaLista

class ListaTarjeta(private var titulo: String,
                   private var color: Int): BaseTarjeta(){
    constructor(): this("", 0)

    private var _binding: FragmentListaTarjetaBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val IS_BLUR_ENABLED = "isBlurEnabled"
    }

    fun newInstance(isBlurEnabled: Boolean) = ListaTarjeta().apply{
        arguments = Bundle().apply{ putBoolean(IS_BLUR_ENABLED, isBlurEnabled) }
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.run{ isBlurEnabled = getBoolean(IS_BLUR_ENABLED, true) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentListaTarjetaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.cabecera.text = titulo
        binding.cabecera.setBackgroundColor(color)

        binding.recyclerView.adapter = TarjetaLista(titulo, this)
    }

    override fun getBackgroundBlurLayout(): ViewGroup = binding.blurLayout

    override fun getDragView(): View = binding.dragArea

    override fun getRootView(): ViewGroup = binding.lista

    override fun dragHandleId(): Int = binding.dragHandleImage.id

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}