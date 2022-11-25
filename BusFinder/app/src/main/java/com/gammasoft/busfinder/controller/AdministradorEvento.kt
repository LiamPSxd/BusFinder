package com.gammasoft.busfinder.controller

import android.view.View
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.fragment.agregar.TarjetaChofer
import com.gammasoft.busfinder.view.fragment.agregar.TarjetaParada
import com.gammasoft.busfinder.view.fragment.agregar.TarjetaRuta
import com.gammasoft.busfinder.view.fragment.agregar.TarjetaTarifa

class AdministradorEvento(private val fragment: TarjetaBase,
                          private val binding: FragmentAdministradorBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnAgregarChofer.id -> agregarChofer()
            binding.btnAgregarRuta.id -> agregarRuta()
            binding.btnAgregarParada.id -> agregarParada()
            binding.btnAgregarTarifa.id -> agregarTarifa()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(fragment.parentFragmentManager, "Error")
        }
    }

    private fun agregarChofer(){
        binding.btnAgregar.collapse()
        fragment.pushPopup(TarjetaChofer().mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }

    private fun agregarRuta(){
        binding.btnAgregar.collapse()
        fragment.pushPopup(TarjetaRuta().mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }

    private fun agregarParada(){
        binding.btnAgregar.collapse()
        fragment.pushPopup(TarjetaParada().mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }

    private fun agregarTarifa(){
        binding.btnAgregar.collapse()
        fragment.pushPopup(TarjetaTarifa().mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }
}