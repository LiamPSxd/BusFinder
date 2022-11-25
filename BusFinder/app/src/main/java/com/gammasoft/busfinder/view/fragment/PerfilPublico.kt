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
import com.squareup.picasso.Picasso

class PerfilPublico: Fragment(){
    private var _binding: FragmentPerfilPublicoBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: PerfilPublicoEvento
    private val localDB = LocalDataBase.getDB(this.requireContext()).crud()

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

        evento = PerfilPublicoEvento(this, binding)

        var cuentas = ArrayList<Cuenta>()
        localDB.getCuentas().observe(viewLifecycleOwner){
            cuentas = it as ArrayList<Cuenta>
        }

        if(cuentas.size != 0) for(cuenta in cuentas){
            if(cuenta.getEstado() && cuenta.mostrarTipo() == "Publico General"){
                evento.cuenta = cuenta

                Picasso.get().load(cuenta.getFoto()).into(binding.fotoPerfil)
                binding.txtCorreo.text = cuenta.getCorreo()

                localDB.getCuentaPublicoByCorreo(cuenta.getCorreo()).observe(viewLifecycleOwner){
                    binding.txtUsuario.text = it.getPublicoUsuario()
                }

                break
            }
        }

        binding.btnCambiarFotoPerfil.setOnClickListener(evento)

        binding.btnCerrarSesion.setOnClickListener(evento)
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}