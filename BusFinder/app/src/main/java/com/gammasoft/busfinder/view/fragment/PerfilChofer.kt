package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.controller.PerfilAdministradorChoferEvento
import com.gammasoft.busfinder.databinding.FragmentPerfilAdminChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.squareup.picasso.Picasso

class PerfilChofer: Fragment(){
    private var _binding: FragmentPerfilAdminChoferBinding? = null
    private val binding get() = _binding!!

    private lateinit var evento: PerfilAdministradorChoferEvento
    private val localDB = LocalDataBase.getDB(this.requireContext()).crud()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentPerfilAdminChoferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        var chofer = Chofer()
        parentFragmentManager.setFragmentResultListener("Chofer", this){ _, bundle ->
            localDB.getChoferByRFC(bundle.getString("chofer").toString()).observe(viewLifecycleOwner){
                chofer = it
            }
        }

        var cuenta = Cuenta()
        localDB.getCuentaChoferByUsuario(chofer.getUsuario()).observe(viewLifecycleOwner){
            localDB.getCuentaByCorreo(it.getCuentaCorreo()).observe(viewLifecycleOwner){ c ->
                cuenta = c
            }
        }

        if(cuenta.getEstado() && cuenta.mostrarTipo() == "Chofer"){
            Picasso.get().load(cuenta.getFoto()).into(binding.fotoPerfil)
            binding.txtCorreo.text = cuenta.getCorreo()

            binding.txtUsuario.text = chofer.getUsuario()
            binding.txtNombre.text = chofer.getNombre()
            binding.txtRFC.text = chofer.getRfc()
            binding.txtCelular.text = chofer.getNumCelular().toString()
            binding.txtLinea.text = chofer.getLinea()
        }

        evento = PerfilAdministradorChoferEvento(this, binding, cuenta)

        binding.btnCambiarFotoPerfil.setOnClickListener(evento)

        binding.btnCerrarSesion.setOnClickListener(evento)
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}