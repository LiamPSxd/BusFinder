package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gammasoft.busfinder.controller.QuejaSugerenciaEvento
import com.gammasoft.busfinder.databinding.FragmentQuejaSugerenciaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.view.adapter.QuejaSugerenciaAdapter

class QuejaSugerencia: TarjetaBase(){
    private var _binding: FragmentQuejaSugerenciaBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: QuejaSugerenciaEvento
    private lateinit var localDB: Crud

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentQuejaSugerenciaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        evento = QuejaSugerenciaEvento(this, binding)
        localDB = LocalDataBase.getDB(requireContext()).crud()

        binding.btnEnviar.setOnClickListener(evento)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        localDB.getSugerenciasQuejas().observe(viewLifecycleOwner){
            binding.recyclerView.adapter = QuejaSugerenciaAdapter(this, it)
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }

    override fun getFragmentContainer(): Int = binding.contenedor.id
}