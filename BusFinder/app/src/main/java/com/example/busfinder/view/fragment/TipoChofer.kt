package com.example.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.busfinder.controller.TipoChoferEvento
import com.example.busfinder.databinding.FragmentTipoChoferBinding

class TipoChofer: Fragment(){
    private var _binding: FragmentTipoChoferBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: TipoChoferEvento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentTipoChoferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        evento = TipoChoferEvento(this, binding)

        binding.btnContinuarTipoChofer.setOnClickListener(evento)
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}