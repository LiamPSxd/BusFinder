package com.gammasoft.busfinder.controller

import android.app.Activity
import android.content.Intent
import android.util.Patterns
import android.view.View
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.fragment.app.Fragment
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentCrearCuenta2Binding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Administrador
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.activity.PrincipalAdministrador
import com.gammasoft.busfinder.view.activity.PrincipalChofer
import com.gammasoft.busfinder.view.activity.PrincipalPublico
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.gammasoft.busfinder.view.dialog.MensajeCodigo
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.GoogleAuthProvider
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CrearCuenta2Evento(private val fragment: Fragment,
                         private val binding: FragmentCrearCuenta2Binding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()
    private val cloudDB = CloudDataBase

    private val callbackManager = CallbackManager.Factory.create()
    private var codigo: Long = 0

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnCambiarFotoPerfil.id -> cambiarFotoPerfil()
            binding.btnGoogle.id -> autenticarGoogle()
            binding.btnFacebook.id -> autenticarFacebook()
            binding.btnTwitter.id -> autenticarTwitter()
            binding.btnContinuar.id -> registrar()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(fragment.parentFragmentManager, "Error")
        }
    }

    private val pickMedia = fragment.registerForActivityResult(PickVisualMedia()){ uri ->
        if(uri != null) Picasso.get().load(uri).into(binding.fotoPerfil)
    }

    private fun cambiarFotoPerfil() =
        pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))

    private val googleActivity = fragment.registerForActivityResult(StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK)
            iniciarByGoogle(GoogleSignIn.getSignedInAccountFromIntent(result.data))
    }

    private fun autenticarGoogle(){
        when(Conexion.comprobarConexion(fragment.requireActivity())){
            "WIFI", "MOBILE" -> {
                val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(fragment.getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()

                val googleCliente = GoogleSignIn.getClient(fragment.requireContext(), googleConf)
                googleCliente.signOut()

                googleActivity.launch(googleCliente.signInIntent)
            }

            "NO INTERNET" -> MensajeAlerta("ERROR", "Por favor, comprueba tu conexión a Internet").show(fragment.parentFragmentManager, "Error")
        }
    }

    private fun iniciarByGoogle(task: Task<GoogleSignInAccount>){
        try{
            val cuenta = task.getResult(ApiException::class.java)

            if(cuenta != null) CoroutineScope(Dispatchers.IO).launch{
                cloudDB.getAuth().signInWithCredential(GoogleAuthProvider.getCredential(cuenta.idToken, null)).addOnCompleteListener{
                    if(it.isSuccessful){
                        val usuario = cuenta.givenName!!
                        val correo = cuenta.email!!
                        val foto = cuenta.photoUrl.toString()

                        val rfc = fragment.arguments?.getString("rfc").orEmpty()
                        val nombre = fragment.arguments?.getString("nombre").orEmpty()
                        val celular = fragment.arguments?.getString("celular")?.toLong() ?: 0
                        val linea = fragment.arguments?.getString("linea").orEmpty()

                        when(fragment.arguments?.getString("tipo")){
                            "Administrador" -> {
                                val admin = Administrador(usuario, rfc, nombre, celular, linea, 0)
                                val cu = Cuenta(correo, "GOOGLE${admin.getUsuario()}", foto, 0, "Google", true)
                                val cuAdmin = CuentaAdministrador(cu.getCorreo(), admin.getUsuario())

                                cloudDB.addAdministrador(admin)
                                cloudDB.addCuenta(cu)
                                cloudDB.addCuentaAdministrador(cuAdmin)

                                val intent = Intent(fragment.context, PrincipalAdministrador::class.java)
                                intent.putExtra("cuenta", cu.getCorreo())
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                fragment.startActivity(intent)
                            }

                            "Chofer" -> {
                                val chofer = Chofer(usuario, rfc, nombre, celular, linea, 0, 0, 0.0)
                                val cu = Cuenta(correo, "GOOGLE${chofer.getUsuario()}", foto, 1, "Google", true)
                                val cuChofer = CuentaChofer(cu.getCorreo(), chofer.getUsuario())

                                cloudDB.addChofer(chofer)
                                cloudDB.addCuenta(cu)
                                cloudDB.addCuentaChofer(cuChofer)

                                val intent = Intent(fragment.context, PrincipalChofer::class.java)
                                intent.putExtra("cuenta", cu.getCorreo())
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                fragment.startActivity(intent)
                            }

                            "Publico" ->{
                                val publico = PublicoGeneral(usuario)
                                val cu = Cuenta(correo, "GOOGLE${publico.getUsuario()}", foto, 2, "Google", true)
                                val cuPublico = CuentaPublico(cu.getCorreo(), publico.getUsuario())

                                cloudDB.addPublicoGeneral(publico)
                                cloudDB.addCuenta(cu)
                                cloudDB.addCuentaPublico(cuPublico)

                                val intent = Intent(fragment.context, PrincipalPublico::class.java)
                                intent.putExtra("cuenta", cu.getCorreo())
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                fragment.startActivity(intent)
                            }
                        }
                    }else MensajeAlerta("ERROR", "Se ha producido un error al autenticar tu cuenta por Google").show(fragment.parentFragmentManager, "Error")
                }
            }
        }catch(e: ApiException){
            MensajeAlerta("ApiException", "${e.printStackTrace()}").show(fragment.parentFragmentManager, "Error")
        }
    }

    private fun autenticarFacebook(){
        when(Conexion.comprobarConexion(fragment.requireActivity())){
            "WIFI", "MOBILE" -> {
                LoginManager.getInstance().logInWithReadPermissions(fragment, callbackManager, listOf("email"))

                LoginManager.getInstance().registerCallback(callbackManager,
                    object: FacebookCallback<LoginResult>{
                        override fun onSuccess(result: LoginResult){
                            result.let{
                                val token = it.accessToken

                                CoroutineScope(Dispatchers.IO).launch{
                                    cloudDB.getAuth().signInWithCredential(FacebookAuthProvider.getCredential(token.token)).addOnCompleteListener{ fb ->
                                        if(fb.isSuccessful){
                                            val usuario = fb.result?.additionalUserInfo?.username!!
                                            val correo = fb.result?.user?.email!!
                                            val foto = fb.result?.user?.photoUrl.toString()

                                            val rfc = fragment.arguments?.getString("rfc").orEmpty()
                                            val nombre = fragment.arguments?.getString("nombre").orEmpty()
                                            val celular = fragment.arguments?.getString("celular")?.toLong() ?: 0
                                            val linea = fragment.arguments?.getString("linea").orEmpty()

                                            when(fragment.arguments?.getString("tipo")){
                                                "Administrador" -> {
                                                    val admin = Administrador(usuario, rfc, nombre, celular, linea, 0)
                                                    val cu = Cuenta(correo, "FACEBOOK${admin.getUsuario()}", foto, 0, "Facebook", true)
                                                    val cuAdmin = CuentaAdministrador(cu.getCorreo(), admin.getUsuario())

                                                    cloudDB.addAdministrador(admin)
                                                    cloudDB.addCuenta(cu)
                                                    cloudDB.addCuentaAdministrador(cuAdmin)

                                                    val intent = Intent(fragment.context, PrincipalAdministrador::class.java)
                                                    intent.putExtra("cuenta", cu.getCorreo())
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                                    fragment.startActivity(intent)
                                                }

                                                "Chofer" -> {
                                                    val chofer = Chofer(usuario, rfc, nombre, celular, linea, 0, 0, 0.0)
                                                    val cu = Cuenta(correo, "FACEBOOK${chofer.getUsuario()}", foto, 1, "Facebook", true)
                                                    val cuChofer = CuentaChofer(cu.getCorreo(), chofer.getUsuario())

                                                    cloudDB.addChofer(chofer)
                                                    cloudDB.addCuenta(cu)
                                                    cloudDB.addCuentaChofer(cuChofer)

                                                    val intent = Intent(fragment.context, PrincipalChofer::class.java)
                                                    intent.putExtra("cuenta", cu.getCorreo())
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                                    fragment.startActivity(intent)
                                                }

                                                "Publico" ->{
                                                    val publico = PublicoGeneral(usuario)
                                                    val cu = Cuenta(correo, "FACEBOOK${publico.getUsuario()}", foto, 2, "Facebook", true)
                                                    val cuPublico = CuentaPublico(cu.getCorreo(), publico.getUsuario())

                                                    cloudDB.addPublicoGeneral(publico)
                                                    cloudDB.addCuenta(cu)
                                                    cloudDB.addCuentaPublico(cuPublico)

                                                    val intent = Intent(fragment.context, PrincipalPublico::class.java)
                                                    intent.putExtra("cuenta", cu.getCorreo())
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                                    fragment.startActivity(intent)
                                                }
                                            }
                                        }else MensajeAlerta("ERROR", "Se ha producido un error al autenticar tu cuenta por Facebook").show(fragment.parentFragmentManager, "Error")
                                    }
                                }
                            }
                        }

                        override fun onCancel(){}

                        override fun onError(error: FacebookException){
                            MensajeAlerta("ERROR", "$error").show(fragment.parentFragmentManager, "Error")
                        }
                    })
            }

            "NO INTERNET" -> MensajeAlerta("ERROR", "Por favor, comprueba tu conexión a Internet").show(fragment.parentFragmentManager, "Error")
        }
    }

    private fun autenticarTwitter(){
        when(Conexion.comprobarConexion(fragment.requireActivity())){
            "WIFI", "MOBILE" -> {}

            "NO INTERNET" -> MensajeAlerta("ERROR", "Por favor, comprueba tu conexión a Internet").show(fragment.parentFragmentManager, "Error")
        }
    }

    private fun verificarUsuarioCorreoRegistrado(usuario: String): Boolean{
        var res = true

        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.cloudDataBase.collection("CuentaPublico").document(usuario).get().addOnSuccessListener{ cp ->
                if(cp.exists() && cp.getString("publicoGeneralUsuario").toString().isNotEmpty()) res = false
                else
                    cloudDB.cloudDataBase.collection("CuentaChofer").document(usuario).get().addOnSuccessListener{ cch ->
                        if(cch.exists() && cch.getString("choferUsuario").toString().isNotEmpty()) res = false
                        else
                            cloudDB.cloudDataBase.collection("CuentaAdministrador").document(usuario).get().addOnSuccessListener{ ca ->
                                if(ca.exists() && ca.getString("administradorUsuario").toString().isNotEmpty()) res = false
                                else
                                    localDB.getCuentaByAdministradorUsuarioOCuentaCorreo(usuario).observe(fragment){ admin ->
                                        if(admin != null) res = false
                                        else
                                            localDB.getCuentaByChoferUsuarioOCuentaCorreo(usuario).observe(fragment){ chofer ->
                                                if(chofer != null) res = false
                                                else
                                                    localDB.getCuentaByPublicoUsuarioOCuentaCorreo(usuario).observe(fragment){ publico ->
                                                        if(publico != null) res = false
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }

        return res
    }

    private fun verificarCorreo(correo: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(correo).matches()

    private suspend fun getCodigo(tipo: String) =
        withContext(Dispatchers.IO){
            MensajeCodigo(tipo, clickListener = {
                codigo = it
            }).show(fragment.parentFragmentManager, "Codigo")
        }

    private fun registrar(){
        when(Conexion.comprobarConexion(fragment.requireActivity())){
            "WIFI", "MOBILE" -> {
                val foto = binding.fotoPerfil.drawable.toString()
                val usuario = binding.txtUsuario.text.toString()
                val correo = binding.txtCorreo.text.toString()
                val contrasenia = binding.txtContrasenia.text.toString()
                val confContrasenia = binding.txtConfirmarContrasenia.text.toString()

                val rfc = fragment.arguments?.getString("rfc").orEmpty()
                val nombre = fragment.arguments?.getString("nombre").orEmpty()
                val celular = fragment.arguments?.getString("celular")?.toLong() ?: 0
                val linea = fragment.arguments?.getString("linea").orEmpty()

                if(usuario.isNotEmpty() && correo.isNotEmpty() && contrasenia.isNotEmpty() && confContrasenia.isNotEmpty()){
                    if(verificarUsuarioCorreoRegistrado(usuario) && verificarCorreo(correo) && contrasenia.length >= 6 && contrasenia == confContrasenia){
                        when(fragment.arguments?.getString("tipo")){
                            "Administrador" -> {
                                CoroutineScope(Dispatchers.IO).launch{
                                    getCodigo("Administrador")

                                    withContext(Dispatchers.IO){
                                        if(codigo != 0.toLong()){
                                            val a = Administrador(usuario, rfc, nombre, celular, linea, this@CrearCuenta2Evento.codigo)
                                            val c = Cuenta(correo, contrasenia, foto, 0, "Correo", true)
                                            val cA = CuentaAdministrador(c.getCorreo(), a.getUsuario())

                                            localDB.addAdministradores(a)
                                            localDB.addCuentas(c)
                                            localDB.addCuentasAdministrador(cA)

                                            cloudDB.getAuth().createUserWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
                                                if(it.isSuccessful){
                                                    cloudDB.addAdministrador(a)
                                                    cloudDB.addCuenta(c)
                                                    cloudDB.addCuentaAdministrador(cA)
                                                }else MensajeAlerta("ERROR", "Se ha producido un error al autenticarte por Correo").show(fragment.parentFragmentManager, "Error")
                                            }

                                            val intent = Intent(fragment.context, PrincipalAdministrador::class.java)
                                            intent.putExtra("cuenta", c.getCorreo())
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                            fragment.startActivity(intent)
                                        }
                                    }
                                }
                            }

                            "Chofer" -> {
                                CoroutineScope(Dispatchers.IO).launch{
                                    getCodigo("Chofer")

                                    withContext(Dispatchers.IO){
                                        if(codigo != 0.toLong()){
                                            val ch = Chofer(usuario, rfc, nombre, celular, linea, this@CrearCuenta2Evento.codigo, 0, 0.0)
                                            val c = Cuenta(correo, contrasenia, foto, 1, "Correo", true)
                                            val cCh = CuentaChofer(c.getCorreo(), ch.getUsuario())

                                            localDB.addChoferes(ch)
                                            localDB.addCuentas(c)
                                            localDB.addCuentasChofer(cCh)

                                            cloudDB.getAuth().createUserWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
                                                if(it.isSuccessful){
                                                    cloudDB.addChofer(ch)
                                                    cloudDB.addCuenta(c)
                                                    cloudDB.addCuentaChofer(cCh)
                                                }else MensajeAlerta("ERROR", "Se ha producido un error al autenticarte por Correo").show(fragment.parentFragmentManager, "Error")
                                            }

                                            val intent = Intent(fragment.context, PrincipalChofer::class.java)
                                            intent.putExtra("cuenta", c.getCorreo())
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                            fragment.startActivity(intent)
                                        }
                                    }
                                }
                            }

                            "Publico" -> {
                                CoroutineScope(Dispatchers.IO).launch{
                                    val p = PublicoGeneral(usuario)
                                    val c = Cuenta(correo, contrasenia, foto, 2, "Correo", true)
                                    val cP = CuentaPublico(c.getCorreo(), p.getUsuario())

                                    localDB.addPublicoGeneral(p)
                                    localDB.addCuentas(c)
                                    localDB.addCuentasPublico(cP)

                                    cloudDB.getAuth().createUserWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
                                        if(it.isSuccessful){
                                            cloudDB.addPublicoGeneral(p)
                                            cloudDB.addCuenta(c)
                                            cloudDB.addCuentaPublico(cP)
                                        }else MensajeAlerta("ERROR", "Se ha producido un error al autenticarte por Correo").show(fragment.parentFragmentManager, "Error")
                                    }

                                    val intent = Intent(fragment.context, PrincipalPublico::class.java)
                                    intent.putExtra("cuenta", c.getCorreo())
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                    fragment.startActivity(intent)
                                }
                            }
                        }
                    }else if(!verificarUsuarioCorreoRegistrado(usuario)) MensajeAlerta("ADVERTENCIA", "Usuario o Correo ya registrados").show(fragment.parentFragmentManager, "Advertencia")
                    else if(!verificarCorreo(correo)) MensajeAlerta("ADVERTENCIA", "Correo no válido").show(fragment.parentFragmentManager, "Advertencia")
                    else if(contrasenia.length < 6) MensajeAlerta("ADVERTENCIA", "La Contraseña debe tener 6 o más caracteres").show(fragment.parentFragmentManager, "Avertencia")
                    else if(contrasenia != confContrasenia) MensajeAlerta("ADVERTENCIA", "Las contraseñas no coinciden").show(fragment.parentFragmentManager, "Avertencia")
                }else if(usuario.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Usuario").show(fragment.parentFragmentManager, "Avertencia")
                else if(correo.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Correo").show(fragment.parentFragmentManager, "Avertencia")
                else if(contrasenia.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Contraseña").show(fragment.parentFragmentManager, "Avertencia")
                else if(confContrasenia.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar la confirmación de su Contraseña").show(fragment.parentFragmentManager, "Avertencia")
                else MensajeAlerta("ERROR", "¡¡Error!!").show(fragment.parentFragmentManager, "Error")
            }

            "NO INTERNET" -> MensajeAlerta("ERROR", "Por favor, comprueba tu conexión a Internet").show(fragment.parentFragmentManager, "Error")
        }
    }
}