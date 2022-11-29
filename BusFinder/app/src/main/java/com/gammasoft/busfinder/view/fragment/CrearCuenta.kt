package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.controller.CrearCuentaEvento
import com.gammasoft.busfinder.databinding.FragmentCrearCuentaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Administrador
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrearCuenta: Fragment(){
    private var _binding: FragmentCrearCuentaBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: CrearCuentaEvento
    private val localDB = LocalDataBase.getDB(requireContext()).crud()

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

        CoroutineScope(Dispatchers.IO).launch{
            CloudDataBase.cloudDataBase.collection("Administrador").get().addOnSuccessListener{
                for(admin in it) if(admin.exists()) localDB.addAdministradores(Administrador(
                    "", "", "", 0,
                    admin.getString("lineaTransporte").toString(), 0
                ))
            }
        }

        val lineas = ArrayList<String>()
        localDB.getAdministradores().observe(viewLifecycleOwner){
            for(linea in it) lineas.add(linea.getLinea())
        }

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