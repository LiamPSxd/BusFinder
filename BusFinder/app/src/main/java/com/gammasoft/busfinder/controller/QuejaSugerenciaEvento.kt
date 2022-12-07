package com.gammasoft.busfinder.controller

import android.content.Context
import android.view.View
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentQuejaSugerenciaBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.util.vibrate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuejaSugerenciaEvento(private val fragment: TarjetaBase,
                            private val binding: FragmentQuejaSugerenciaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnEnviar.id -> enviar()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(fragment.parentFragmentManager, "Error")
        }
    }

    private fun enviar(){
        fragment.context?.vibrate(60L)
        val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()
        val descripcion = binding.txtQuejaOSugerencia.text.toString()

        if(descripcion.isNotEmpty()){
            val prefs = fragment.requireActivity().getSharedPreferences(fragment.activity?.getString(R.string.prefs_file), Context.MODE_PRIVATE)
            localDB.getCuentaAdministradorByCorreo(prefs.getString("correo", null)!!).observe(fragment){ cA ->
                localDB.getAdministradorByUsuario(cA.getAdminUsuario()).observe(fragment){ admin ->
                    if(admin != null) agregarQuejaLocal(QuejaSugerencia(descripcion, admin.getUsuario()), localDB)
                    else localDB.getCuentaChoferByCorreo(prefs.getString("correo", null)!!).observe(fragment){ cC ->
                        localDB.getChoferByUsuario(cC.getChoferUsuario()).observe(fragment){ chofer ->
                            if(chofer != null) agregarQuejaLocal(QuejaSugerencia(descripcion, chofer.getUsuario()), localDB)
                            else localDB.getCuentaPublicoByCorreo(prefs.getString("correo", null)!!).observe(fragment){ cP ->
                                localDB.getPublicoGeneralByUsuario(cP.getPublicoUsuario()).observe(fragment){ publico ->
                                    if(publico != null) agregarQuejaLocal(QuejaSugerencia(descripcion, publico.getUsuario()), localDB)
                                    else MensajeAlerta("ERROR", "Usuario no encontrado").show(fragment.parentFragmentManager, "Error")
                                }
                            }
                        }
                    }
                }
            }
        }else if(descripcion.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar una descripción").show(fragment.parentFragmentManager, "Advertencia")
    }

    private fun agregarQuejaLocal(quejaSugerencia: QuejaSugerencia, localDB: Crud){
        CoroutineScope(Dispatchers.IO).launch{
            localDB.addSugerenciaQueja(quejaSugerencia)
        }

        localDB.getSugerenciasQuejas().observe(fragment){
            for(i in it.indices) if(i == it.indices.last) CoroutineScope(Dispatchers.IO).launch{
                CloudDataBase.addQuejaSugerencia(it.last())
            }
        }

        binding.txtQuejaOSugerencia.text?.clear()
    }
}