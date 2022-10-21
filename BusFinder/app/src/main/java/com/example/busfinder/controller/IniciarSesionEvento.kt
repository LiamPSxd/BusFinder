package com.example.busfinder.controller

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.busfinder.databinding.ActivityIniciarSesionBinding
import com.example.busfinder.model.dbLocal.LocalDataBase
import com.example.busfinder.model.dbLocal.entidades.Cuenta
import com.example.busfinder.view.activity.PrincipalAdministrador
import com.example.busfinder.view.activity.PrincipalChofer
import com.example.busfinder.view.activity.PrincipalPublico
import com.example.busfinder.view.dialog.MensajeAlertaDialog
import com.google.firebase.auth.FirebaseAuth

class IniciarSesionEvento(private var activity: AppCompatActivity,
                          private var binding: ActivityIniciarSesionBinding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(activity).crud()

    private var internet = false

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnGoogle.id -> autenticarGoogle()
            binding.btnFacebook.id -> autenticarFacebook()
            binding.btnTwitter.id -> autenticarTwitter()
            binding.btnContinuar.id -> iniciar()
            else -> Toast.makeText(activity, "Error: Acción no encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun autenticarGoogle(){
        internet = true
    }

    private fun autenticarFacebook(){
    }

    private fun autenticarTwitter(){
    }

    private fun iniciar(){
        val usuarioOCorreo = binding.txtUsuarioOCorreo.text.toString()
        val contrasenia = binding.txtContrasenia.text.toString()

        if(usuarioOCorreo.isNotEmpty() && contrasenia.isNotEmpty()){
            if(internet){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(usuarioOCorreo, contrasenia)
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                            activity.startActivity(Intent(activity, PrincipalAdministrador::class.java))
                        }else{
                            MensajeAlertaDialog(activity, "Error", "Se ha producido un error al autenticarte por Google").mostrarAlerta()
                        }
                    }
            }else{
                var cuenta = Cuenta()

                localDB.getCuentaByAdministradorUsuarioOCuentaCorreo(usuarioOCorreo).observe(activity, Observer{ admin ->
                    if(admin != null){
                        cuenta = admin
                    }else{
                        localDB.getCuentaByChoferUsuarioOCuentaCorreo(usuarioOCorreo).observe(activity, Observer{ chofer ->
                            if(chofer != null){
                                cuenta = chofer
                            }else{
                                localDB.getCuentaByPublicoUsuarioOCuentaCorreo(usuarioOCorreo).observe(activity, Observer{ publico ->
                                    if(publico != null) cuenta = publico
                                })
                            }
                        })
                    }
                })

                if(cuenta.getContrasenia() == contrasenia){
                    when(cuenta.mostrarTipo()){
                        "Administrador" -> activity.startActivity(Intent(activity, PrincipalAdministrador::class.java))
                        "Chofer" -> activity.startActivity(Intent(activity, PrincipalChofer::class.java))
                        "Publico_General" -> activity.startActivity(Intent(activity, PrincipalPublico::class.java))
                        "Error" -> Toast.makeText(activity,"Error en la Cuenta", Toast.LENGTH_SHORT).show()
                        else -> Toast.makeText(activity,"Actividdad no encontrada", Toast.LENGTH_SHORT).show()
                    }

                    Toast.makeText(activity, "¡Bienvenido! :)", Toast.LENGTH_SHORT).show()
                    activity.finish()
                }else Toast.makeText(activity, "Advertencia: Usuario no registrado", Toast.LENGTH_SHORT).show()
            }
        }else if(usuarioOCorreo.isEmpty()){
            Toast.makeText(activity, "Falta ingresar su Usuario o Correo", Toast.LENGTH_SHORT).show()
        }else if(contrasenia.isEmpty()){
            Toast.makeText(activity, "Falta ingresar su Contraseña", Toast.LENGTH_SHORT).show()
        }
    }
}