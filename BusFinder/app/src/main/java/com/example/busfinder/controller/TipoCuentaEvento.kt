package com.example.busfinder.controller

import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.busfinder.R
import com.example.busfinder.databinding.FragmentTipoCuentaBinding
import com.example.busfinder.view.fragment.TipoCuenta
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TipoCuentaEvento(private var fragment: TipoCuenta,
                       private var binding: FragmentTipoCuentaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnContinuarTipoCuenta.id -> pasarCuenta(binding.btnContinuarTipoCuenta)
            else -> Toast.makeText(fragment.context, "Error: Acción no encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pasarCuenta(btn: FloatingActionButton){
        if(fragment.tipo == "Admin"){
            btn.findNavController().navigate(R.id.action_fragment_tipo_cuenta_TO_fragment_tipo_administrador)
        }else if(fragment.tipo == "Chofer"){
            btn.findNavController().navigate(R.id.action_fragment_tipo_cuenta_TO_fragment_tipo_chofer)
        }else if(fragment.tipo == "Publico"){
            btn.findNavController().navigate(R.id.action_fragment_tipo_cuenta_TO_fragment_tipo_publico)
        }
    }
}