package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.view.activity.TarjetaBase
import com.gammasoft.busfinder.view.adapter.TarjetaAdapter

class AgregarAdministrador: TarjetaBase(){
    private var _binding: FragmentAdministradorBinding? = null
    private val binding get() = _binding!!

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

        val titulos = arrayListOf("Chofer", "Ruta", "Parada", "Tarifa")
        val colores = arrayListOf(R.color.color11, R.color.color12, R.color.color13, R.color.color14)
        val fondos = arrayListOf(R.drawable.bus, R.drawable.bus, R.drawable.bus, R.drawable.bus)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = TarjetaAdapter(this, titulos, colores, fondos)
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun getFragmentContainer(): Int = binding.contenedor.id
}