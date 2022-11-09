package com.gammasoft.busfinder.controller

import android.view.View
import androidx.navigation.findNavController
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentTipoCuentaBinding
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.fragment.TipoCuenta

class TipoCuentaEvento(private var fragment: TipoCuenta,
                       private var binding: FragmentTipoCuentaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.trjAdmin.id -> binding.trjAdmin.findNavController().navigate(R.id.action_fragment_tipo_cuenta_TO_fragment_tipo_administrador)
            binding.trjChofer.id -> binding.trjChofer.findNavController().navigate(R.id.action_fragment_tipo_cuenta_TO_fragment_tipo_chofer)
            binding.trjPublico.id -> binding.trjPublico.findNavController().navigate(R.id.action_fragment_tipo_cuenta_TO_fragment_tipo_publico)
            else -> MensajeAlerta("ERROR", "Acción no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }
}