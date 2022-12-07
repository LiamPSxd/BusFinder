package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.AdministradorEvento
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.view.adapter.TarjetaAdapter

class Administrador: TarjetaBase(){
    private var _binding: FragmentAdministradorBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: AdministradorEvento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentAdministradorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        evento = AdministradorEvento(this, binding)

        binding.btnAgregarChofer.setOnClickListener(evento)
        binding.btnAgregarRuta.setOnClickListener(evento)
        binding.btnAgregarParada.setOnClickListener(evento)
        binding.btnAgregarTarifa.setOnClickListener(evento)
        binding.btnAgregarReporte.setOnClickListener(evento)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        binding.recyclerView.adapter = TarjetaAdapter(
            this,
            binding,
            arrayListOf("CHOFERES", "RUTAS", "PARADAS", "TARIFAS"),
            arrayListOf(R.drawable.bus, R.drawable.bus, R.drawable.bus, R.drawable.bus)
        )
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun getFragmentContainer(): Int = binding.contenedor.id
}