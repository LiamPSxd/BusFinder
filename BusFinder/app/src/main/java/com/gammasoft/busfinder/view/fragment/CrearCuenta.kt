package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.controller.CrearCuentaEvento
import com.gammasoft.busfinder.databinding.FragmentCrearCuentaBinding
import com.gammasoft.busfinder.model.dbNube.CloudDataBase

class CrearCuenta: Fragment(){
    private var _binding: FragmentCrearCuentaBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: CrearCuentaEvento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentCrearCuentaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val lineas = ArrayList<String>()
        for(linea in CloudDataBase.getAdministradores()) lineas.add(linea.getLinea())

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            lineas
        ).also{ binding.txtLinea.setAdapter(it) }

        evento = CrearCuentaEvento(this, binding)

        binding.btnContinuar.setOnClickListener(evento)
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}