package com.example.busfinder.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.busfinder.controller.BienvenidaEvento
import com.example.busfinder.databinding.ActivityBienvenidaBinding
import com.example.busfinder.model.dbLocal.LocalDataBase

class Bienvenida: AppCompatActivity(){
    private lateinit var binding: ActivityBienvenidaBinding

    private lateinit var evento: BienvenidaEvento

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.sesion()

        evento = BienvenidaEvento(this, binding)

        binding.btnCrearCuenta.setOnClickListener(evento)

        binding.btnIniciarSesion.setOnClickListener(evento)
    }

    private fun sesion(){
        val localDB = LocalDataBase.getDB(this).crud()

        localDB.getCuentas().observe(this, Observer{ cuentas ->
            for(cuenta in cuentas){
                if(cuenta.getEstado()){
                    when(cuenta.mostrarTipo()){
                        "Administrador" -> startActivity(Intent(this, PrincipalAdministrador::class.java))
                        "Chofer" -> startActivity(Intent(this, PrincipalChofer::class.java))
                        "Publico_General" -> startActivity(Intent(this, PrincipalPublico::class.java))
                        "Error" -> Toast.makeText(this,"Error en la Cuenta", Toast.LENGTH_SHORT).show()
                        else -> Toast.makeText(this,"Actividdad no encontrada", Toast.LENGTH_SHORT).show()
                    }

                    this.finish()
                }
            }
        })
    }
}