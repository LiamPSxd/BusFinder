package com.gammasoft.busfinder.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gammasoft.busfinder.controller.IniciarSesionEvento
import com.gammasoft.busfinder.databinding.ActivityIniciarSesionBinding

class IniciarSesion: AppCompatActivity(){
    private lateinit var binding: ActivityIniciarSesionBinding

    private lateinit var evento: IniciarSesionEvento

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityIniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        evento = IniciarSesionEvento(this, binding)

        binding.btnGoogle.setOnClickListener(evento)

        binding.btnFacebook.setOnClickListener(evento)

        binding.btnTwitter.setOnClickListener(evento)

        binding.btnContinuar.setOnClickListener(evento)
    }
}