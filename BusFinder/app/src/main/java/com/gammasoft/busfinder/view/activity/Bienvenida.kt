package com.gammasoft.busfinder.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gammasoft.busfinder.databinding.ActivityBienvenidaBinding
import com.gammasoft.busfinder.controller.BienvenidaEvento

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

        if(evento.sesion()) finish()
        else setVisible(true)
    }
}