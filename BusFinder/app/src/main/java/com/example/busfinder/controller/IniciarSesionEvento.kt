package com.example.busfinder.controller

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.busfinder.R
import com.example.busfinder.databinding.ActivityIniciarSesionBinding
import com.example.busfinder.model.dbLocal.LocalDataBase
import com.example.busfinder.model.dbLocal.entidades.Cuenta
import com.example.busfinder.model.dbNube.CloudDataBase
import com.example.busfinder.view.activity.PrincipalAdministrador
import com.example.busfinder.view.activity.PrincipalChofer
import com.example.busfinder.view.activity.PrincipalPublico
import com.example.busfinder.view.dialog.MensajeAlerta
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.GoogleAuthProvider

class IniciarSesionEvento(private val activity: AppCompatActivity,
                          private val binding: ActivityIniciarSesionBinding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(activity).crud()
    private val cloudDB = CloudDataBase

    val GOOGLE_SIGN_IN = 100

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnGoogle.id -> verificarGoogle()
            binding.btnFacebook.id -> verificarFacebook()
            binding.btnTwitter.id -> verificarTwitter()
            binding.btnContinuar.id -> iniciar()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    private fun verificarGoogle(){
        when(Conexion.comprobarConexion(activity)){
            "WIFI", "MOBILE" -> {
                val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(activity.getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()

                val googleCliente = GoogleSignIn.getClient(activity, googleConf)
                googleCliente.signOut()

                activity.startActivityForResult(googleCliente.signInIntent, GOOGLE_SIGN_IN)
            }

            "NO INTERNET" -> MensajeAlerta("ERROR", "No tienes una conexión a Internet")
        }
    }

    fun iniciarByGoogle(task: Task<GoogleSignInAccount>){
        try{
            val cuenta = task.getResult(ApiException::class.java)

            if(cuenta != null){
                val correo = cuenta.email

                cloudDB.getAuth().signInWithCredential(GoogleAuthProvider.getCredential(cuenta.idToken, null)).addOnCompleteListener{
                    if(it.isSuccessful){
                        var x = ""

                        val publico = cloudDB.getCuentaPublico(correo!!)

                        if(publico.getCuentaCorreo().isNotEmpty()) x = publico.getCuentaCorreo()
                        else{
                            val chofer = cloudDB.getCuentaChofer(correo)

                            if(chofer.getCuentaCorreo().isNotEmpty()) x = chofer.getCuentaCorreo()
                            else{
                                val admin = cloudDB.getCuentaAdministrador(correo)

                                if(admin.getCuentaCorreo().isNotEmpty()) x = admin.getCuentaCorreo()
                            }
                        }

                        when(cloudDB.getCuenta(x).mostrarTipo()){
                            "Administrador" -> activity.startActivity(Intent(activity, PrincipalAdministrador::class.java))
                            "Chofer" -> activity.startActivity(Intent(activity, PrincipalChofer::class.java))
                            "Publico General" -> activity.startActivity(Intent(activity, PrincipalPublico::class.java))
                            "Error" -> MensajeAlerta("ADVERTENCIA", "No se ha encontrado la cuenta").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                            else -> MensajeAlerta("ERROR", "Actividad no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                        }
                    }else MensajeAlerta("ERROR", "Se ha producido un error al autenticar tu cuenta por Google").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                }
            }
        }catch(e: ApiException){
            MensajeAlerta("ApiException", "${e.printStackTrace()}")
        }
    }

    private fun verificarFacebook(){
    }

    private fun verificarTwitter(){
    }

    private fun verificarCorreoCloud(correo: String, contrasenia: String): Cuenta{
        var cuenta = ""

        val publico = cloudDB.getCuentaPublico(correo)

        if(publico.getCuentaCorreo().isNotEmpty()){
            cloudDB.getAuth().signInWithEmailAndPassword(publico.getCuentaCorreo(), contrasenia).addOnCompleteListener{
                if(it.isSuccessful) cuenta = publico.getCuentaCorreo()
            }
        }else{
            val chofer = cloudDB.getCuentaChofer(correo)

            if(chofer.getCuentaCorreo().isNotEmpty()){
                cloudDB.getAuth().signInWithEmailAndPassword(chofer.getCuentaCorreo(), contrasenia).addOnCompleteListener{
                    if(it.isSuccessful) cuenta = chofer.getCuentaCorreo()
                }
            }else{
                val admin = cloudDB.getCuentaAdministrador(correo)

                if(admin.getCuentaCorreo().isNotEmpty()){
                    cloudDB.getAuth().signInWithEmailAndPassword(admin.getCuentaCorreo(), contrasenia).addOnCompleteListener{
                        if(it.isSuccessful) cuenta = admin.getCuentaCorreo()
                    }
                }
            }
        }

        return cloudDB.getCuenta(cuenta)
    }

    private fun iniciar(){
        val usuarioOCorreo = binding.txtUsuarioOCorreo.text.toString()
        val contrasenia = binding.txtContrasenia.text.toString()

        if(usuarioOCorreo.isNotEmpty() && contrasenia.isNotEmpty()){
            var cuenta = Cuenta()

            when(Conexion.comprobarConexion(activity)){
                "WIFI" -> cuenta = verificarCorreoCloud(usuarioOCorreo, contrasenia)

                "MOBILE", "NO INTERNET" -> {
                    localDB.getCuentaByAdministradorUsuarioOCuentaCorreo(usuarioOCorreo).observe(activity){ admin ->
                        if(admin != null) cuenta = admin
                        else{
                            localDB.getCuentaByChoferUsuarioOCuentaCorreo(usuarioOCorreo).observe(activity){ chofer ->
                                if(chofer != null) cuenta = chofer
                                else{
                                    localDB.getCuentaByPublicoUsuarioOCuentaCorreo(usuarioOCorreo).observe(activity){ publico ->
                                        if(publico != null) cuenta = publico
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if(cuenta.getContrasenia() == contrasenia){
                when(cuenta.mostrarTipo()){
                    "Administrador" -> activity.startActivity(Intent(activity, PrincipalAdministrador::class.java))
                    "Chofer" -> activity.startActivity(Intent(activity, PrincipalChofer::class.java))
                    "Publico General" -> activity.startActivity(Intent(activity, PrincipalPublico::class.java))
                    "Error" -> MensajeAlerta("ADVERTENCIA", "No se ha encontrado la cuenta").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                    else -> MensajeAlerta("ERROR", "Actividad no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                }

                Toast.makeText(activity, "¡Bienvenido!", Toast.LENGTH_SHORT).show()

                activity.parent.finish()
                activity.finish()
            }else MensajeAlerta("ADVERTENCIA", "Usuario no registrado").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }else if(usuarioOCorreo.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Usuario o Correo").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else if(contrasenia.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Contraseña").mostrar(R.anim.zoom_in, R.anim.zoom_out)
    }
}