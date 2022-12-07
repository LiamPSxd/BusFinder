package com.gammasoft.busfinder.controller

import android.view.View
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentAdministradorBinding
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.fragment.TarjetaBase
import com.gammasoft.busfinder.view.fragment.agregar.*
import com.gammasoft.busfinder.view.util.vibrate

class AdministradorEvento(private val fragment: TarjetaBase,
                          private val binding: FragmentAdministradorBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnAgregarChofer.id -> agregarChofer()
            binding.btnAgregarRuta.id -> agregarRuta()
            binding.btnAgregarParada.id -> agregarParada()
            binding.btnAgregarTarifa.id -> agregarTarifa()
            binding.btnAgregarUnidad.id -> agregarUnidad()
            //binding.btnAgregarReporte.id -> agregarReporte()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(fragment.parentFragmentManager, "Error")
        }
    }

    private fun agregarChofer(){
        fragment.context?.vibrate(60L)
        binding.btnAgregar.collapse()
        binding.btnAgregar.visibility = View.GONE
        fragment.pushPopup(TarjetaChofer(binding).mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }

    private fun agregarRuta(){
        fragment.context?.vibrate(60L)
        binding.btnAgregar.collapse()
        binding.btnAgregar.visibility = View.GONE
        fragment.pushPopup(TarjetaRuta(binding).mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }

    private fun agregarParada(){
        fragment.context?.vibrate(60L)
        binding.btnAgregar.collapse()
        binding.btnAgregar.visibility = View.GONE
        fragment.pushPopup(TarjetaParada(binding).mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }

    private fun agregarTarifa(){
        fragment.context?.vibrate(60L)
        binding.btnAgregar.collapse()
        binding.btnAgregar.visibility = View.GONE
        fragment.pushPopup(TarjetaTarifa(binding).mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }

    private fun agregarUnidad(){
        fragment.context?.vibrate(60L)
        binding.btnAgregar.collapse()
        binding.btnAgregar.visibility = View.GONE
        fragment.pushPopup(TarjetaUnidad(binding).mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }

    /*private fun agregarReporte(){
        fragment.context?.vibrate(60L)
        binding.btnAgregar.collapse()
        binding.btnAgregar.visibility = View.GONE
        fragment.pushPopup(TarjetaReporte(binding).mostrar(R.anim.zoom_in, R.anim.zoom_out))
    }*/
}