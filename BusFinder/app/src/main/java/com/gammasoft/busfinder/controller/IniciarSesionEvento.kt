package com.gammasoft.busfinder.controller

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.ActivityIniciarSesionBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.activity.PrincipalAdministrador
import com.gammasoft.busfinder.view.activity.PrincipalChofer
import com.gammasoft.busfinder.view.activity.PrincipalPublico
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class IniciarSesionEvento(private val activity: AppCompatActivity,
                          private val binding: ActivityIniciarSesionBinding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(activity).crud()
    private val cloudDB = CloudDataBase

    val GOOGLE_SIGN_IN = 100
    val callbackManager = CallbackManager.Factory.create()

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

            "NO INTERNET" -> MensajeAlerta("ERROR", "No tienes una conexión a Internet").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    fun iniciarByGoogle(task: Task<GoogleSignInAccount>){
        try{
            val cuenta = task.getResult(ApiException::class.java)

            if(cuenta != null){
                cloudDB.getAuth().signInWithCredential(GoogleAuthProvider.getCredential(cuenta.idToken, null)).addOnCompleteListener{
                    if(it.isSuccessful){
                        val correo = cuenta.email
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
                            else -> MensajeAlerta("ERROR", "Actividad no encontrada, cree una cuenta con Google").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                        }
                    }else MensajeAlerta("ERROR", "Se ha producido un error al autenticar tu cuenta por Google").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                }
            }
        }catch(e: ApiException){
            MensajeAlerta("ApiException", "${e.printStackTrace()}").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    private fun verificarFacebook(){
        LoginManager.getInstance().logInWithReadPermissions(activity, listOf("email"))

        LoginManager.getInstance().registerCallback(callbackManager,
        object: FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult){
                result.let{
                    val token = it.accessToken

                    cloudDB.getAuth().signInWithCredential(FacebookAuthProvider.getCredential(token.token)).addOnCompleteListener{ fb ->
                        if(fb.isSuccessful){
                            val correo = FirebaseAuth.getInstance().currentUser?.email
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
                                else -> MensajeAlerta("ERROR", "Actividad no encontrada, cree una cuenta con Facebook").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                            }
                        }else MensajeAlerta("ERROR", "Se ha producido un error al autenticar tu cuenta por Facebook").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                    }
                }
            }

            override fun onCancel(){}

            override fun onError(error: FacebookException){
                MensajeAlerta("ERROR", "$error").mostrar(R.anim.zoom_in, R.anim.zoom_out)
            }
        })
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