package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.controller.CrearCuenta2Evento
import com.gammasoft.busfinder.databinding.FragmentCrearCuenta2Binding

class CrearCuenta2: Fragment(){
    private var _binding: FragmentCrearCuenta2Binding? = null
    private val binding get() = _binding!!

    private lateinit var evento: CrearCuenta2Evento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentCrearCuenta2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        evento = CrearCuenta2Evento(this, binding)

        binding.btnCambiarFotoPerfil.setOnClickListener(evento)

        binding.btnGoogle.setOnClickListener(evento)

        binding.btnFacebook.setOnClickListener(evento)

        binding.btnTwitter.setOnClickListener(evento)

        binding.btnContinuar.setOnClickListener(evento)
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}