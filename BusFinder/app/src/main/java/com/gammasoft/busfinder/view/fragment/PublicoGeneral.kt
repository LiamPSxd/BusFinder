package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.databinding.FragmentPublicoBinding

class PublicoGeneral: Fragment(){
    private var _binding: FragmentPublicoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentPublicoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}