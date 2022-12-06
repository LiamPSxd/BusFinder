package com.gammasoft.busfinder.controller

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentCrearCuentaBinding
import com.gammasoft.busfinder.view.dialog.MensajeAlerta

class CrearCuentaEvento(private val fragment: Fragment,
                        private val binding: FragmentCrearCuentaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnContinuar.id -> verificar()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(fragment.parentFragmentManager, "Error")
        }
    }

    private fun verificar(){
        val rfc = binding.txtRFC.text.toString()
        val nombre = binding.txtNombre.text.toString()
        val celular = binding.txtCelular.text.toString()
        val linea = binding.txtLinea.text.toString()

        if(rfc.isNotEmpty() && nombre.isNotEmpty() && celular.isNotEmpty() && linea.isNotEmpty()){
            if(rfc.length == 13 && celular.length == 10){
                val bundle = bundleOf(
                    "tipo" to fragment.arguments?.getString("tipo"),
                    "rfc" to rfc,
                    "nombre" to nombre,
                    "celular" to celular,
                    "linea" to linea
                )

                binding.btnContinuar.findNavController().navigate(R.id.fragmentCrearCuentaInicial_TO_fragmentCrearCuentaFinal, bundle)
            }else if(rfc.length != 13) MensajeAlerta("ADVERTENCIA", "RFC inclompleto").show(fragment.parentFragmentManager, "Avertencia")
            else if(celular.length != 10) MensajeAlerta("ADVERTENCIA", "Número de celular inclompleto").show(fragment.parentFragmentManager, "Avertencia")
        }else if(rfc.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su RFC").show(fragment.parentFragmentManager, "Avertencia")
        else if(nombre.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Nombre").show(fragment.parentFragmentManager, "Avertencia")
        else if(celular.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Número de Celular").show(fragment.parentFragmentManager, "Avertencia")
        else if(linea.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar la Línea de Transporte").show(fragment.parentFragmentManager, "Avertencia")
        else MensajeAlerta("ERROR", "¡¡Error!!").show(fragment.parentFragmentManager, "Error")
    }
}