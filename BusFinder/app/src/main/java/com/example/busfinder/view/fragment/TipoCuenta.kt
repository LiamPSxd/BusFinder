package com.example.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.busfinder.controller.TipoCuentaEvento
import com.example.busfinder.controller.TipoCuentaEvento2
import com.example.busfinder.databinding.FragmentTipoCuentaBinding

class TipoCuenta: Fragment(){
    private var _binding: FragmentTipoCuentaBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: TipoCuentaEvento
    private lateinit var evento2: TipoCuentaEvento2
    var tipo = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentTipoCuentaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        evento = TipoCuentaEvento(this, binding)

        evento2 = TipoCuentaEvento2(this, binding)

        binding.radioGroup.setOnCheckedChangeListener(evento2)

        binding.btnContinuarTipoCuenta.setOnClickListener(evento)
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}