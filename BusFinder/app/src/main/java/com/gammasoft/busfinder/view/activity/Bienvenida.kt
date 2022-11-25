package com.gammasoft.busfinder.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gammasoft.busfinder.controller.BienvenidaEvento
import com.gammasoft.busfinder.databinding.ActivityBienvenidaBinding

class Bienvenida: AppCompatActivity(){
    private lateinit var binding: ActivityBienvenidaBinding

    private lateinit var evento: BienvenidaEvento

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        evento = BienvenidaEvento(this, binding)

        binding.btnIniciarSesion.setOnClickListener(evento)

        binding.btnCrearCuenta.setOnClickListener(evento)

        binding.bienvenida.visibility = View.INVISIBLE
        if(evento.sesion()) finish()
        else binding.bienvenida.visibility = View.VISIBLE
    }
}