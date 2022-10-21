package com.example.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.busfinder.controller.TipoChofer2Evento
import com.example.busfinder.databinding.FragmentTipoChofer2Binding

class TipoChofer2: Fragment(){
    private var _binding: FragmentTipoChofer2Binding? = null
    private val binding get() = _binding!!

    private lateinit var evento: TipoChofer2Evento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentTipoChofer2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        evento = TipoChofer2Evento(this, binding)

        binding.btnCambiarFotoPerfil.setOnClickListener(evento)

        binding.btnGoogle.setOnClickListener(evento)

        binding.btnFacebook.setOnClickListener(evento)

        binding.btnTwitter.setOnClickListener(evento)

        binding.btnContinuarTipoChofer2.setOnClickListener(evento)
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}