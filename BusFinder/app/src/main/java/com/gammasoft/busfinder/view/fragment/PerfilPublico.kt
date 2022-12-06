package com.gammasoft.busfinder.view.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.controller.PerfilPublicoEvento
import com.gammasoft.busfinder.databinding.FragmentPerfilPublicoBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PerfilPublico: Fragment(){
    private var _binding: FragmentPerfilPublicoBinding? = null
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences
    private lateinit var localDB: Crud
    private lateinit var evento: PerfilPublicoEvento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentPerfilPublicoBinding.inflate(inflater, container, false)
        return binding.root
    }

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri ->
        if(uri != null){
            localDB = LocalDataBase.getDB(requireContext()).crud()

            prefs = requireActivity().getSharedPreferences(activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
            localDB.getCuentaAdministradorByCorreo(prefs.getString("correo", null)!!).observe(viewLifecycleOwner){
                localDB.getCuentaByCorreo(it.getCuentaCorreo()).observe(viewLifecycleOwner){ cuenta ->
                    CoroutineScope(Dispatchers.IO).launch{
                        cuenta.setFoto(uri.toString())
                        localDB.updateCuenta(cuenta)
                    }

                    Picasso.get().load(uri).into(binding.fotoPerfil)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        localDB = LocalDataBase.getDB(this.requireContext()).crud()

        prefs = requireActivity().getSharedPreferences(activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
        localDB.getCuentaPublicoByCorreo(prefs.getString("correo", null)!!).observe(viewLifecycleOwner){
            localDB.getPublicoGeneralByUsuario(it.getPublicoUsuario()).observe(viewLifecycleOwner){ publico ->
                var tipo = 3
                when(prefs.getString("tipo", null)!!){
                    "Administrador" -> tipo = 0
                    "Chofer" -> tipo = 1
                    "Publico General" -> tipo = 2
                }

                val cuenta = Cuenta(
                    prefs.getString("correo", null)!!,
                    prefs.getString("contrasenia", null)!!,
                    prefs.getString("foto", null)!!,
                    tipo,
                    prefs.getString("metodo", null)!!,
                    prefs.getString("estado", null)!!.toBoolean()
                )

                if(cuenta.getEstado() && cuenta.mostrarTipo() == "Publico General"){
                    if(cuenta.getFoto() == "android.graphics.drawable.VectorDrawable@b6d1651")
                        Picasso.get().load("android.resource://com.gammasoft.busfinder/drawable/user").into(binding.fotoPerfil)
                    else Picasso.get().load(cuenta.getFoto()).into(binding.fotoPerfil)

                    binding.txtCorreo.text = cuenta.getCorreo()
                    binding.txtUsuario.text = publico.getUsuario()
                }

                evento = PerfilPublicoEvento(this, binding, cuenta)

                binding.btnCambiarFotoPerfil.setOnClickListener(evento)

                binding.btnCerrarSesion.setOnClickListener(evento)
            }
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        _binding = null
    }
}