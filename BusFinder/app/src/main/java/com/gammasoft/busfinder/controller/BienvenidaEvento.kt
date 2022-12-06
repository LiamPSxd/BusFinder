package com.gammasoft.busfinder.controller

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gammasoft.busfinder.databinding.ActivityBienvenidaBinding
import com.gammasoft.busfinder.view.activity.CrearCuenta
import com.gammasoft.busfinder.view.activity.IniciarSesion
import com.gammasoft.busfinder.view.dialog.MensajeAlerta

class BienvenidaEvento(private var activity: AppCompatActivity,
                       private var binding: ActivityBienvenidaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnIniciarSesion.id -> iniciarSesion()
            binding.btnCrearCuenta.id -> crearCuenta()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(activity.supportFragmentManager, "Error")
        }
    }

    private fun iniciarSesion(){
        activity.startActivity(Intent(activity, IniciarSesion::class.java))
    }

    private fun crearCuenta(){
        activity.startActivity(Intent(activity, CrearCuenta::class.java))
    }
}