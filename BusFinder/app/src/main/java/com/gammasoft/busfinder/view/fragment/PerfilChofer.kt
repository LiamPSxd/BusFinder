package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.controller.PerfilAdministradorChoferEvento
import com.gammasoft.busfinder.databinding.FragmentPerfilAdminChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
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

        evento = PerfilAdministradorChoferEvento(this, binding)

        var cuentas = ArrayList<Cuenta>()
        localDB.getCuentas().observe(viewLifecycleOwner){
            cuentas = it as ArrayList<Cuenta>
        }

        if(cuentas.size != 0) for(cuenta in cuentas){
            if(cuenta.getEstado() && cuenta.mostrarTipo() == "Chofer"){
                evento.cuenta = cuenta

                Picasso.get().load(cuenta.getFoto()).into(binding.fotoPerfil)
                binding.txtCorreo.text = cuenta.getCorreo()

                localDB.getCuentaChoferByCorreo(cuenta.getCorreo()).observe(viewLifecycleOwner){
                    localDB.getChoferByUsuario(it.getChoferUsuario()).observe(viewLifecycleOwner){ chofer ->
                        binding.txtUsuario.text = chofer.getUsuario()
                        binding.txtNombre.text = chofer.getNombre()
                        binding.txtRFC.text = chofer.getRfc()
                        binding.txtCelular.text = chofer.getNumCelular().toString()
                        binding.txtLinea.text = chofer.getLinea()
                    }
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