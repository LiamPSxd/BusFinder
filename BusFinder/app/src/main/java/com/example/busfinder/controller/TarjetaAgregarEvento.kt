package com.example.busfinder.controller

import android.view.View
import android.widget.AdapterView
import android.widget.SeekBar
import com.example.busfinder.databinding.TarjetaAgregarBinding
import com.example.busfinder.model.dbLocal.Crud
import com.example.busfinder.view.fragment.BaseTarjeta

class TarjetaAgregarEvento(private val fragment: BaseTarjeta,
                           private val titulo: String,
                           private val binding: TarjetaAgregarBinding,
                           private val localDB: Crud): View.OnClickListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener{
    private lateinit var chofer: String
    private lateinit var parada: String
    private lateinit var tarifa: String

    override fun onClick(v: View?){
        when(v?.id){
            binding.frameAgregarChofer.btnAceptar.id, binding.frameAgregarRuta.btnAceptar.id,
                binding.frameAgregarParada.btnAceptar.id, binding.frameAgregarTarifa.btnAceptar.id -> agregar()

            binding.frameAgregarChofer.btnCancelar.id, binding.frameAgregarRuta.btnCancelar.id,
                binding.frameAgregarParada.btnCancelar.id, binding.frameAgregarTarifa.btnCancelar.id -> cancelar()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){
        val item = parent?.getItemAtPosition(position).toString()

        when(titulo){
            "Chofer" -> chofer = item
            "Parada" -> parada = item
            "Tarifa" -> tarifa = item
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?){}

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean){
        binding.frameAgregarTarifa.txtPrecio.text = progress.toString()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?){}

    override fun onStopTrackingTouch(seekBar: SeekBar?){}

    private fun agregar(){
        when(titulo){
            "Chofer" -> {
                chofer.ifEmpty{
                    localDB.getChoferByRFC(binding.frameAgregarChofer.txtRFC.text.toString()).observe(fragment){
                    }
                }
            }
        }
    }

    private fun cancelar(){
        fragment.onDestroyView()
    }
}