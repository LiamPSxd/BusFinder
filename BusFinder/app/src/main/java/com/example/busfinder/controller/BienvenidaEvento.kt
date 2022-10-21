package com.example.busfinder.controller

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.busfinder.databinding.ActivityBienvenidaBinding
import com.example.busfinder.view.activity.CrearCuenta
import com.example.busfinder.view.activity.IniciarSesion

class BienvenidaEvento(private var activity: AppCompatActivity,
                       private var binding: ActivityBienvenidaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnCrearCuenta.id -> crearCuenta()
            binding.btnIniciarSesion.id -> iniciarSesion()
            else -> Toast.makeText(activity, "Error: Acción no encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun crearCuenta(){
        activity.startActivity(Intent(activity, CrearCuenta::class.java))
    }

    private fun iniciarSesion(){
        activity.startActivity(Intent(activity, IniciarSesion::class.java))
    }
}