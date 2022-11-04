package com.example.busfinder.controller

import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import android.widget.Toast
import com.example.busfinder.databinding.FragmentTipoCuentaBinding
import com.example.busfinder.view.fragment.TipoCuenta

class TipoCuentaEvento2(private var fragment: TipoCuenta,
                        private var binding: FragmentTipoCuentaBinding): OnCheckedChangeListener{
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int){
        when(checkedId){
            else -> Toast.makeText(fragment.context, "Error: Acción no encontrada", Toast.LENGTH_SHORT).show()
        }
    }
}