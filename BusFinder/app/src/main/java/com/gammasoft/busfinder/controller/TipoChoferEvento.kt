package com.gammasoft.busfinder.controller

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentTipoChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TipoChoferEvento(private var fragment: Fragment,
                       private var binding: FragmentTipoChoferBinding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()
    private val cloudDB = CloudDataBase

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnContinuarTipoChofer.id -> verificar()
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
                    val chofer = Chofer("choferPendiente", rfc, nombre, celular.toLong(), linea, 0, 0, 0.0)
                    localDB.addChoferes(chofer)
                    cloudDB.addChofer(chofer)
                }

                localDB.getChoferByRFC(rfc).observe(fragment){ chofer ->
                    if(chofer.getNumCelular() == celular.toLong() && chofer.getNombre() == nombre){
                        binding.btnContinuarTipoChofer.findNavController().navigate(R.id.action_fragment_tipo_chofer_TO_fragment_tipo_chofer_2)
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