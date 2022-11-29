package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.controller.PerfilAdministradorChoferEvento
import com.gammasoft.busfinder.databinding.FragmentPerfilAdminChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Administrador
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.squareup.picasso.Picasso

class PerfilAdministrador: Fragment(){
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

        var admin = Administrador()
        parentFragmentManager.setFragmentResultListener("Administrador", this){ _, bundle ->
            localDB.getAdministradorByRFC(bundle.getString("administrador").toString()).observe(viewLifecycleOwner){
                admin = it
            }
        }

        var cuenta = Cuenta()
        localDB.getCuentaAdministradorByUsuario(admin.getUsuario()).observe(viewLifecycleOwner){
            localDB.getCuentaByCorreo(it.getCuentaCorreo()).observe(viewLifecycleOwner){ c ->
                cuenta = c
            }
        }

        if(cuenta.getEstado() && cuenta.mostrarTipo() == "Administrador"){
            Picasso.get().load(cuenta.getFoto()).into(binding.fotoPerfil)
            binding.txtCorreo.text = cuenta.getCorreo()

            binding.txtUsuario.text = admin.getUsuario()
            binding.txtNombre.text = admin.getNombre()
            binding.txtRFC.text = admin.getRfc()
            binding.txtCelular.text = admin.getNumCelular().toString()
            binding.txtLinea.text = admin.getLinea()
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