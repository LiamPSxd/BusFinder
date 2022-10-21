package com.example.busfinder.controller

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.busfinder.R
import com.example.busfinder.databinding.FragmentTipoAdministradorBinding
import com.example.busfinder.model.dbLocal.LocalDataBase
import com.example.busfinder.model.dbLocal.entidades.Administrador
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TipoAdministradorEvento(private var fragment: Fragment,
                              private var binding: FragmentTipoAdministradorBinding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnContinuarTipoAdmin.id -> verificar()
            else -> Toast.makeText(fragment.context, "Error: Acción no encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verificar(){
        val rfc = binding.txtRFC.text.toString()
        val nombre = binding.txtNombre.text.toString()
        val celular = binding.txtCelular.text.toString()
        val linea = binding.txtLinea.text.toString()

        if(rfc.isNotEmpty() && nombre.isNotEmpty() && celular.isNotEmpty() && linea.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch{
                localDB.addAdministradores(Administrador("adminPendiente", rfc, nombre, celular.toLong(), linea, 0))
            }

            localDB.getAdministradorByRFC(rfc).observe(fragment, Observer{ admin ->
                if(admin.getNumCelular() == celular.toLong() && admin.getNombre() == nombre){
                    binding.btnContinuarTipoAdmin.findNavController().navigate(R.id.action_fragment_tipo_administrador_TO_fragment_tipo_administrador_2)
                }else Toast.makeText(fragment.context, "¡Hubo un error al continuar con su registro!", Toast.LENGTH_SHORT).show()
            })
        }else if(rfc.isEmpty()){
            Toast.makeText(fragment.context, "Falta ingresar su RFC", Toast.LENGTH_SHORT).show()
        }else if(nombre.isEmpty()){
            Toast.makeText(fragment.context, "Falta ingresar su Nombre", Toast.LENGTH_SHORT).show()
        }else if(celular.isEmpty()){
            Toast.makeText(fragment.context, "Falta ingresar su Celular", Toast.LENGTH_SHORT).show()
        }else if(linea.isEmpty()){
            Toast.makeText(fragment.context, "Falta ingresar la Línea", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(fragment.context, "¡¡ERROR!!", Toast.LENGTH_SHORT).show()
        }
    }
}