package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.controller.PerfilPublicoEvento
import com.gammasoft.busfinder.databinding.FragmentPerfilPublicoBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral
import com.squareup.picasso.Picasso

class PerfilPublico: Fragment(){
    private var _binding: FragmentPerfilPublicoBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: PerfilPublicoEvento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentPerfilPublicoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val localDB = LocalDataBase.getDB(this.requireContext()).crud()

        var publico = PublicoGeneral()
        parentFragmentManager.setFragmentResultListener("Publico", this){ _, bundle ->
            localDB.getPublicoGeneralByUsuario(bundle.getString("publico").toString()).observe(viewLifecycleOwner){
                publico = it
            }
        }

        var cuenta = Cuenta()
        localDB.getCuentaPublicoByUsuario(publico.getUsuario()).observe(viewLifecycleOwner){
            localDB.getCuentaByCorreo(it.getCuentaCorreo()).observe(viewLifecycleOwner){ c ->
                cuenta = c
            }
        }

        if(cuenta.getEstado() && cuenta.mostrarTipo() == "Publico General"){
            Picasso.get().load(cuenta.getFoto()).into(binding.fotoPerfil)
            binding.txtCorreo.text = cuenta.getCorreo()

            binding.txtUsuario.text = publico.getUsuario()
        }

        evento = PerfilPublicoEvento(this, binding, cuenta)

        binding.btnCambiarFotoPerfil.setOnClickListener(evento)

        binding.btnCerrarSesion.setOnClickListener(evento)
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}