package com.gammasoft.busfinder.controller

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentTipoCuentaBinding
import com.gammasoft.busfinder.view.dialog.MensajeAlerta

class TipoCuentaEvento(private val fragment: Fragment,
                       private val binding: FragmentTipoCuentaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.trjAdmin.id -> binding.trjAdmin.findNavController().navigate(R.id.fragmentTipoCuenta_TO_fragmentCrearCuentaInicial, bundleOf("tipo" to "Administrador"))

            binding.trjChofer.id -> binding.trjChofer.findNavController().navigate(R.id.fragmentTipoCuenta_TO_fragmentCrearCuentaInicial, bundleOf("tipo" to "Chofer"))

            binding.trjPublico.id -> binding.trjPublico.findNavController().navigate(R.id.fragmentTipoCuenta_TO_fragmentCrearCuentaFinal, bundleOf("tipo" to "Publico"))

            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(fragment.parentFragmentManager, "Error")
        }
    }
}