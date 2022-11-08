package com.example.busfinder.controller

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.busfinder.R
import com.example.busfinder.databinding.FragmentTipoAdministradorBinding
import com.example.busfinder.model.dbLocal.LocalDataBase
import com.example.busfinder.model.dbLocal.entidades.Administrador
import com.example.busfinder.model.dbNube.CloudDataBase
import com.example.busfinder.view.dialog.MensajeAlerta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TipoAdministradorEvento(private var fragment: Fragment,
                              private var binding: FragmentTipoAdministradorBinding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()
    private val cloudDB = CloudDataBase

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnContinuarTipoAdmin.id -> verificar()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    private fun verificar(){
        val rfc = binding.txtRFC.text.toString()
        val nombre = binding.txtNombre.text.toString()
        val celular = binding.txtCelular.text.toString()
        val linea = binding.txtLinea.text.toString()

        if(rfc.isNotEmpty() && nombre.isNotEmpty() && celular.isNotEmpty() && linea.isNotEmpty()){
            if(rfc.length == 13){
                CoroutineScope(Dispatchers.IO).launch{
                    val admin = Administrador("adminPendiente", rfc, nombre, celular.toLong(), linea, 0)
                    localDB.addAdministradores(admin)
                    cloudDB.addAdministrador(admin)
                }

                localDB.getAdministradorByRFC(rfc).observe(fragment){ admin ->
                    if(admin.getNumCelular() == celular.toLong() && admin.getNombre() == nombre){
                        binding.btnContinuarTipoAdmin.findNavController().navigate(R.id.action_fragment_tipo_administrador_TO_fragment_tipo_administrador_2)
                    }else MensajeAlerta("ERROR", "¡Hubo un error al continuar con su registro!").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                }
            }else MensajeAlerta("ADVERTENCIA", "RFC inclompleto").mostrar(R.anim.zoom_in, R.anim.zoom_out)
    }else if(rfc.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su RFC").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else if(nombre.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Nombre").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else if(celular.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Número de Celular").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else if(linea.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar la Línea de Transporte").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else MensajeAlerta("ERROR", "¡¡Error!!").mostrar(R.anim.zoom_in, R.anim.zoom_out)
    }
}