package com.example.busfinder.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.busfinder.controller.IniciarSesionEvento
import com.example.busfinder.databinding.ActivityIniciarSesionBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn

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

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == evento.GOOGLE_SIGN_IN) evento.iniciarByGoogle(GoogleSignIn.getSignedInAccountFromIntent(data))
    }
}