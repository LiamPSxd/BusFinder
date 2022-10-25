package com.example.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.busfinder.R
import com.example.busfinder.databinding.FragmentVisualizarAdministradorBinding
import com.example.busfinder.view.adapter.GeneralCardAdapter

class VisualizarAdministrador: Fragment(){
    private var _binding: FragmentVisualizarAdministradorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentVisualizarAdministradorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = GeneralCardAdapter(intArrayOf(R.drawable.bus, R.drawable.bus, R.drawable.bus, R.drawable.bus))
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}