package com.example.busfinder.controller

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.busfinder.databinding.ActivityBienvenidaBinding
import com.example.busfinder.model.dbLocal.LocalDataBase

class BienvenidaEvento(private var activity: AppCompatActivity,
                       private var binding: ActivityBienvenidaBinding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(activity).crud()

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnCrearCuenta.id -> crearCuenta()
            binding.btnIniciarSesion.id -> iniciarSesion()
            else -> Toast.makeText(activity, "Error: Acción no encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun crearCuenta(){}

    private fun iniciarSesion(){}
}