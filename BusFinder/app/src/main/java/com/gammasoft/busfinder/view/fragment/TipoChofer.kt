package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.busfinder.controller.TipoChoferEvento
import com.example.busfinder.databinding.FragmentTipoChoferBinding
import com.example.busfinder.model.dbNube.CloudDataBase

class TipoChofer: Fragment(){
    private var _binding: FragmentTipoChoferBinding? = null
    private val binding get() = _binding!!

    private val cloudDB = CloudDataBase
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

        val lineas = ArrayList<String>()
        for(linea in cloudDB.getAdministradores()) lineas.add(linea.getLinea())

        ArrayAdapter.createFromResource(
            this.requireContext(),
            lineas.toString().toInt(),
            android.R.layout.simple_list_item_1
        ).also{ binding.txtLinea.setAdapter(it) }

        evento = TipoChoferEvento(this, binding)

        binding.btnContinuarTipoChofer.setOnClickListener(evento)
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}