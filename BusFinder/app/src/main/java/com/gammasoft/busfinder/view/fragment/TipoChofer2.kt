package com.gammasoft.busfinder.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.controller.TipoChofer2Evento
import com.gammasoft.busfinder.databinding.FragmentTipoChofer2Binding
import com.google.android.gms.auth.api.signin.GoogleSignIn

class TipoChofer2: Fragment(){
    private var _binding: FragmentTipoChofer2Binding? = null
    private val binding get() = _binding!!

    private lateinit var evento: TipoChofer2Evento

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentTipoChofer2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        evento = TipoChofer2Evento(this, binding)

        binding.btnCambiarFotoPerfil.setOnClickListener(evento)

        binding.btnGoogle.setOnClickListener(evento)

        binding.btnFacebook.setOnClickListener(evento)

        binding.btnTwitter.setOnClickListener(evento)

        binding.btnContinuarTipoChofer2.setOnClickListener(evento)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == evento.GOOGLE_SIGN_IN) evento.iniciarByGoogle(GoogleSignIn.getSignedInAccountFromIntent(data))
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }
}