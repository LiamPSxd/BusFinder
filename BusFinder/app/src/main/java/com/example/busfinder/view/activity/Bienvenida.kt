package com.example.busfinder.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.busfinder.controller.BienvenidaEvento
import com.example.busfinder.databinding.ActivityBienvenidaBinding

class Bienvenida: AppCompatActivity(){
    private lateinit var binding: ActivityBienvenidaBinding

    private lateinit var evento: BienvenidaEvento

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?){
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        evento = BienvenidaEvento(this, binding)

        binding.btnCrearCuenta.setOnClickListener(evento)

        binding.btnIniciarSesion.setOnClickListener(evento)
    }
}