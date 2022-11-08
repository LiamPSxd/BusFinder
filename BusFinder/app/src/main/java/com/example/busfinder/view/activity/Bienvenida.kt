package com.example.busfinder.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.busfinder.controller.BienvenidaEvento
import com.example.busfinder.databinding.ActivityBienvenidaBinding

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