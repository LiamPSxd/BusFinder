package com.gammasoft.busfinder.controller

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
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
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IniciarSesionEvento(private val activity: AppCompatActivity,
                          private val binding: ActivityIniciarSesionBinding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(activity).crud()
    private val cloudDB = CloudDataBase

    private val callbackManager = CallbackManager.Factory.create()

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnGoogle.id -> verificarGoogle()
            binding.btnFacebook.id -> verificarFacebook()
            binding.btnTwitter.id -> verificarTwitter()
            binding.btnContinuar.id -> iniciar()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(activity.supportFragmentManager, "Error")
        }
    }

    private val googleActivity = activity.registerForActivityResult(StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK)
            iniciarByGoogle(GoogleSignIn.getSignedInAccountFromIntent(result.data))
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

                googleActivity.launch(googleCliente.signInIntent)
            }

            "NO INTERNET" -> MensajeAlerta("ERROR", "Por favor, comprueba tu conexión a Internet").show(activity.supportFragmentManager, "Error")
        }
    }

    private fun iniciarPantallaPrincipalByRS(correo: String){
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.cloudDataBase.collection("Cuenta").document(correo).get().addOnSuccessListener{ cuenta ->
                if(cuenta.exists()){
                    lateinit var intent: Intent

                    when(cuenta.getString("tipo").toString()){
                        "Administrador" -> {
                            intent = Intent(activity, PrincipalAdministrador::class.java)
                            intent.putExtra("cuenta", cuenta.getString("correo").toString())
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            activity.startActivity(intent)
                        }

                        "Chofer" -> {
                            intent = Intent(activity, PrincipalChofer::class.java)
                            intent.putExtra("cuenta", cuenta.getString("correo").toString())
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            activity.startActivity(intent)
                        }

                        "Publico General" -> {
                            intent = Intent(activity, PrincipalPublico::class.java)
                            intent.putExtra("cuenta", cuenta.getString("correo").toString())
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            activity.startActivity(intent)
                        }

                        "Error" -> MensajeAlerta("ADVERTENCIA", "No se ha encontrado la cuenta").show(activity.supportFragmentManager, "Avertencia")
                        else -> MensajeAlerta("ERROR", "Actividad no encontrada, cree una cuenta con alguna red social").show(activity.supportFragmentManager, "Error")
                    }
                }
            }
        }
    }

    private fun obtenerCuentaCorreo(correo: String){
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.cloudDataBase.collection("CuentaPublico").document(correo).get().addOnSuccessListener{ cp ->
                if(cp.exists())
                    iniciarPantallaPrincipalByRS(cp.getString("cuentaCorreo").toString())
                else{
                    cloudDB.cloudDataBase.collection("CuentaChofer").document(correo).get().addOnSuccessListener{ cch ->
                        if(cch.exists())
                            iniciarPantallaPrincipalByRS(cch.getString("cuentaCorreo").toString())
                        else{
                            cloudDB.cloudDataBase.collection("CuentaAdministrador").document(correo).get().addOnSuccessListener{ ca ->
                                if(ca.exists())
                                    iniciarPantallaPrincipalByRS(ca.getString("cuentaCorreo").toString())
                                else MensajeAlerta("ERROR", "Actividad Principal no encontrada").show(activity.supportFragmentManager, "Error")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun iniciarByGoogle(task: Task<GoogleSignInAccount>){
        try{
            val cuenta = task.getResult(ApiException::class.java)

            if(cuenta != null) CoroutineScope(Dispatchers.IO).launch{
                cloudDB.getAuth().signInWithCredential(GoogleAuthProvider.getCredential(cuenta.idToken, null)).addOnCompleteListener{
                    if(it.isSuccessful){
                        obtenerCuentaCorreo(cuenta.email!!)
                    }else MensajeAlerta("ERROR", "Se ha producido un error al autenticar tu cuenta por Google").show(activity.supportFragmentManager, "Error")
                }
            }
        }catch(e: ApiException){
            MensajeAlerta("ApiException", "${e.printStackTrace()}").show(activity.supportFragmentManager, "Error")
        }
    }

    private fun verificarFacebook(){
        when(Conexion.comprobarConexion(activity)){
            "WIFI", "MOBILE" -> {
                LoginManager.getInstance().logInWithReadPermissions(activity, callbackManager, listOf("email"))

                LoginManager.getInstance().registerCallback(callbackManager,
                    object: FacebookCallback<LoginResult>{
                        override fun onSuccess(result: LoginResult){
                            result.let{
                                val token = it.accessToken

                                CoroutineScope(Dispatchers.IO).launch{
                                    cloudDB.getAuth().signInWithCredential(FacebookAuthProvider.getCredential(token.token)).addOnCompleteListener{ fb ->
                                        if(fb.isSuccessful){
                                            obtenerCuentaCorreo(fb.result?.user?.email!!)
                                        }else MensajeAlerta("ERROR", "Se ha producido un error al autenticar tu cuenta por Facebook").show(activity.supportFragmentManager, "Error")
                                    }
                                }
                            }
                        }

                        override fun onCancel(){}

                        override fun onError(error: FacebookException) =
                            MensajeAlerta("ERROR", "$error").show(activity.supportFragmentManager, "Error")
                    })
            }

            "NO INTERNET" -> MensajeAlerta("ERROR", "Por favor, comprueba tu conexión a Internet").show(activity.supportFragmentManager, "Error")
        }
    }

    private fun verificarTwitter(){
        when(Conexion.comprobarConexion(activity)){
            "WIFI", "MOBILE" -> {}

            "NO INTERNET" -> MensajeAlerta("ERROR", "Por favor, comprueba tu conexión a Internet").show(activity.supportFragmentManager, "Error")
        }
    }

    private fun obtenerCuentaCorreo2(correo: String, contrasenia: String){
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.cloudDataBase.collection("Cuenta").document(correo).get().addOnSuccessListener{ cuenta ->
                if(cuenta.exists()){
                    var tipo = 3
                    when(cuenta.getString("tipo").toString()){
                        "Administrador" -> tipo = 0
                        "Chofer" -> tipo = 1
                        "Publico General" -> tipo = 2
                    }

                    iniciarPantallaPrincipalByCorreo(Cuenta(
                        cuenta.getString("correo").toString(),
                        cuenta.getString("contrasenia").toString(),
                        cuenta.getString("foto").toString(),
                        tipo,
                        cuenta.getString("metodo").toString(),
                        cuenta.getBoolean("estado").toString().toBoolean()
                    ), contrasenia)
                }
            }
        }
    }

    private fun iniciarSesionCorreoFirebase(correo: String, contrasenia: String){
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.getAuth().signInWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
                if(it.isSuccessful) obtenerCuentaCorreo2(correo, contrasenia)
                else MensajeAlerta("ERROR", "No se pudo  iniciar sesión con Firebase").show(activity.supportFragmentManager, "Error")
            }
        }
    }

    private fun verificarCorreoCloud(correo: String, contrasenia: String){
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.cloudDataBase.collection("CuentaPublico").document(correo).get().addOnSuccessListener{ cp ->
                if(cp.exists())
                    iniciarSesionCorreoFirebase(cp.getString("cuentaCorreo").toString(), contrasenia)
                else{
                    cloudDB.cloudDataBase.collection("CuentaChofer").document(correo).get().addOnSuccessListener{ cch ->
                        if(cch.exists())
                            iniciarSesionCorreoFirebase(cch.getString("cuentaCorreo").toString(), contrasenia)
                        else{
                            cloudDB.cloudDataBase.collection("CuentaAdministrador").document(correo).get().addOnSuccessListener{ ca ->
                                if(ca.exists())
                                    iniciarSesionCorreoFirebase(ca.getString("cuentaCorreo").toString(), contrasenia)
                                else MensajeAlerta("ERROR", "Cuenta no encontrada en la Nube").show(activity.supportFragmentManager, "Error")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun iniciarPantallaPrincipalByCorreo(cuenta: Cuenta, contrasenia: String){
        if(cuenta.getContrasenia() == contrasenia){
            lateinit var intent: Intent

            when(cuenta.mostrarTipo()){
                "Administrador" -> {
                    intent = Intent(activity, PrincipalAdministrador::class.java)
                    intent.putExtra("cuenta", cuenta.getCorreo())
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    activity.startActivity(intent)
                }

                "Chofer" -> {
                    intent = Intent(activity, PrincipalChofer::class.java)
                    intent.putExtra("cuenta", cuenta.getCorreo())
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    activity.startActivity(intent)
                }

                "Publico General" -> {
                    intent = Intent(activity, PrincipalPublico::class.java)
                    intent.putExtra("cuenta", cuenta.getCorreo())
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    activity.startActivity(intent)
                }

                "Error" -> MensajeAlerta("ADVERTENCIA", "No se ha encontrado la Actividad Principal").show(activity.supportFragmentManager, "Avertencia")
                else -> MensajeAlerta("ERROR", "Actividad no encontrada").show(activity.supportFragmentManager, "Error")
            }
        }else MensajeAlerta("ADVERTENCIA", "No existe una cuenta con esos datos").show(activity.supportFragmentManager, "Avertencia")
    }

    private fun iniciar(){
        val usuarioOCorreo = binding.txtUsuarioOCorreo.text.toString()
        val contrasenia = binding.txtContrasenia.text.toString()

        if(usuarioOCorreo.isNotEmpty() && contrasenia.isNotEmpty() && contrasenia.length >= 6){
            when(Conexion.comprobarConexion(activity)){
                "WIFI", "MOBILE" -> verificarCorreoCloud(usuarioOCorreo, contrasenia)

                "NO INTERNET" -> {
                    var cuenta = Cuenta()

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

                    iniciarPantallaPrincipalByCorreo(cuenta, contrasenia)
                }
            }
        }else if(usuarioOCorreo.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Usuario o Correo").show(activity.supportFragmentManager, "Avertencia")
        else if(contrasenia.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Contraseña").show(activity.supportFragmentManager, "Avertencia")
        else if(contrasenia.length < 6) MensajeAlerta("ADVERTENCIA", "La Contraseña debe tener 6 o más caracteres").show(activity.supportFragmentManager, "Avertencia")
    }
}