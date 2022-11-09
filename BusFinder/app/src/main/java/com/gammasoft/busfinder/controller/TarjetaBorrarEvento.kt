package com.gammasoft.busfinder.controller

import android.view.View
import android.widget.AdapterView
import com.gammasoft.busfinder.databinding.TarjetaBorrarBinding
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.view.fragment.BaseTarjeta

class TarjetaBorrarEvento(private val fragment: BaseTarjeta,
                          private val titulo: String,
                          private val binding: TarjetaBorrarBinding,
                          private val localDB: Crud): View.OnClickListener, AdapterView.OnItemSelectedListener{
    private lateinit var chofer: String
    private lateinit var ruta: String
    private lateinit var parada: String
    private lateinit var tarifa: String

    override fun onClick(v: View?){
        when(v?.id){
            binding.frameBorrarChofer.btnBorrar.id, binding.frameBorrarRuta.btnBorrar.id,
                binding.frameBorrarParada.btnBorrar.id, binding.frameBorrarTarifa.btnBorrar.id -> borrar()

            binding.frameBorrarChofer.btnCancelar.id, binding.frameBorrarRuta.btnCancelar.id,
                binding.frameBorrarParada.btnCancelar.id, binding.frameBorrarTarifa.btnCancelar.id -> cancelar()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){
        val item = parent?.getItemAtPosition(position).toString()

        when(titulo){
            "Chofer" -> chofer = item
            "Ruta" -> ruta = item
            "Parada" -> parada = item
            "Tarifa" -> tarifa = item
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?){}

    private fun borrar(){
        when(titulo){
            "Chofer" -> {
                chofer.ifEmpty{
                    localDB.getChoferByRFC(binding.frameBorrarChofer.txtRFC.text.toString()).observe(fragment){
                    }
                }
            }
        }
    }

    private fun cancelar(){
        fragment.onDestroyView()
    }
}