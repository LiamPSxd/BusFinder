package com.gammasoft.busfinder.controller

import android.app.Activity
import android.content.Context
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

class CrearCuenta2Evento(private val fragment: Fragment,
                         private val binding: FragmentCrearCuenta2Binding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()
    private val cloudDB = CloudDataBase

    private val callbackManager = CallbackManager.Factory.create()
    private var codigo = 0L

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

                        when(val tipo = fragment.arguments?.getString("tipo")){
                            "Administrador_" -> {
                                MensajeCodigo(tipo, clickListener = {
                                    codigo = it
                                    finalizar(tipo, usuario, rfc, nombre, celular, linea, correo, "GOOGLE $usuario", foto, "Google")
                                }).show(fragment.parentFragmentManager, "Codigo")
                            }

                            "Chofer_" -> {
                                MensajeCodigo(tipo, clickListener = {
                                    codigo = it
                                    finalizar(tipo, usuario, rfc, nombre, celular, linea, correo, "GOOGLE $usuario", foto, "Google")
                                }).show(fragment.parentFragmentManager, "Codigo")
                            }

                            "Publico_" ->{
                                val publico = PublicoGeneral(usuario)
                                val cu = Cuenta(correo, "GOOGLE${publico.getUsuario()}", foto, 2, "Google", true)
                                val cuPublico = CuentaPublico(cu.getCorreo(), publico.getUsuario())

                                val prefs = fragment.requireActivity().getSharedPreferences(fragment.getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                                prefs.putString("correo", cu.getCorreo())
                                prefs.putString("contrasenia", cu.getContrasenia())
                                prefs.putString("foto", cu.getFoto())
                                prefs.putString("tipo", cu.mostrarTipo())
                                prefs.putString("metodo", cu.getMetodo())
                                prefs.putString("estado", cu.getEstado().toString())
                                prefs.apply()

                                cloudDB.addPublicoGeneral(publico)
                                cloudDB.addCuenta(cu)
                                cloudDB.addCuentaPublico(cuPublico)

                                val intent = Intent(fragment.context, PrincipalPublico::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                                fragment.activity?.startActivity(intent)
                                fragment.activity?.finish()
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

                                            when(val tipo = fragment.arguments?.getString("tipo")){
                                                "Administrador_" -> {
                                                    MensajeCodigo(tipo, clickListener = {
                                                        codigo = it
                                                        finalizar(tipo, usuario, rfc, nombre, celular, linea, correo, "FACEBOOK $usuario", foto, "Facebook")
                                                    }).show(fragment.parentFragmentManager, "Codigo")
                                                }

                                                "Chofer_" -> {
                                                    MensajeCodigo(tipo, clickListener = {
                                                        codigo = it
                                                        finalizar(tipo, usuario, rfc, nombre, celular, linea, correo, "FACEBOOK $usuario", foto, "Facebook")
                                                    }).show(fragment.parentFragmentManager, "Codigo")
                                                }

                                                "Publico_" ->{
                                                    val publico = PublicoGeneral(usuario)
                                                    val cu = Cuenta(correo, "FACEBOOK${publico.getUsuario()}", foto, 2, "Facebook", true)
                                                    val cuPublico = CuentaPublico(cu.getCorreo(), publico.getUsuario())

                                                    val prefs = fragment.requireActivity().getSharedPreferences(fragment.getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                                                    prefs.putString("correo", cu.getCorreo())
                                                    prefs.putString("contrasenia", cu.getContrasenia())
                                                    prefs.putString("foto", cu.getFoto())
                                                    prefs.putString("tipo", cu.mostrarTipo())
                                                    prefs.putString("metodo", cu.getMetodo())
                                                    prefs.putString("estado", cu.getEstado().toString())
                                                    prefs.apply()

                                                    cloudDB.addPublicoGeneral(publico)
                                                    cloudDB.addCuenta(cu)
                                                    cloudDB.addCuentaPublico(cuPublico)

                                                    val intent = Intent(fragment.context, PrincipalPublico::class.java)
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                                    fragment.activity?.startActivity(intent)
                                                    fragment.activity?.finish()
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
            cloudDB.cloudDataBase.collection("Cuenta").get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(cuenta in it) if(cuenta.exists())
                        localDB.addCuentas(Cuenta(cuenta.get("correo").toString(), "", "", 3, "", false))
                }
            }

            cloudDB.cloudDataBase.collection("CuentaPublico").whereEqualTo("cuentaCorreo", usuario).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(publico in it) if(publico.exists())
                        localDB.addCuentasPublico(CuentaPublico(publico.get("cuentaCorreo").toString(), publico.get("publicoGeneralUsuario").toString()))
                }
            }

            cloudDB.cloudDataBase.collection("CuentaPublico").whereEqualTo("publicoGeneralUsuario", usuario).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(publico in it) if(publico.exists())
                        localDB.addCuentasPublico(CuentaPublico(publico.get("cuentaCorreo").toString(), publico.get("publicoGeneralUsuario").toString()))
                }
            }

            cloudDB.cloudDataBase.collection("CuentaChofer").whereEqualTo("cuentaCorreo", usuario).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(chofer in it) if(chofer.exists())
                        localDB.addCuentasChofer(CuentaChofer(chofer.get("cuentaCorreo").toString(), chofer.get("choferUsuario").toString()))
                }
            }

            cloudDB.cloudDataBase.collection("CuentaChofer").whereEqualTo("choferUsuario", usuario).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(chofer in it) if(chofer.exists())
                        localDB.addCuentasChofer(CuentaChofer(chofer.get("cuentaCorreo").toString(), chofer.get("choferUsuario").toString()))
                }
            }

            cloudDB.cloudDataBase.collection("CuentaAdministrador").whereEqualTo("cuentaCorreo", usuario).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(admin in it) if(admin.exists())
                        localDB.addCuentasAdministrador(CuentaAdministrador(admin.get("cuentaCorreo").toString(), admin.get("administradorUsuario").toString()))
                }
            }

            cloudDB.cloudDataBase.collection("CuentaAdministrador").whereEqualTo("administradorUsuario", usuario).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(admin in it) if(admin.exists())
                        localDB.addCuentasAdministrador(CuentaAdministrador(admin.get("cuentaCorreo").toString(), admin.get("administradorUsuario").toString()))
                }
            }
        }

        localDB.getCuentaByPublicoUsuarioOCuentaCorreo(usuario).observe(fragment){ publico ->
            if(publico != null) res = false
            else
                localDB.getCuentaByChoferUsuarioOCuentaCorreo(usuario).observe(fragment) { chofer ->
                    if (chofer != null) res = false
                    else
                        localDB.getCuentaByAdministradorUsuarioOCuentaCorreo(usuario).observe(fragment){ admin ->
                            if(admin != null) res = false
                        }
                }
        }

        CoroutineScope(Dispatchers.IO).launch{
            localDB.deleteCuentas()
            localDB.deleteCuentasPublico()
            localDB.deleteCuentasChofer()
            localDB.deleteCuentasAdministrador()
        }

        return res
    }

    private fun verificarCorreo(correo: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(correo).matches()

    private fun finalizar(tipo: String, usuario: String, rfc: String, nombre: String, celular: Long, linea: String,
                          correo: String, contrasenia: String, foto: String, metodo: String){
        CoroutineScope(Dispatchers.IO).launch{
            val prefs = fragment.requireActivity().getSharedPreferences(fragment.getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.putString("correo", correo)
            prefs.putString("contrasenia", contrasenia)
            prefs.putString("foto", foto)

            when(tipo){
                "Administrador_" -> {
                    if(codigo != 0L){
                        val a = Administrador(usuario, rfc, nombre, celular, linea, codigo)
                        val c = Cuenta(correo, contrasenia, foto, 0, metodo, true)
                        val cA = CuentaAdministrador(c.getCorreo(), a.getUsuario())

                        localDB.addAdministradores(a)
                        localDB.addCuentas(c)
                        localDB.addCuentasAdministrador(cA)
                        cloudDB.addAdministrador(a)
                        cloudDB.addCuenta(c)
                        cloudDB.addCuentaAdministrador(cA)

                        prefs.putString("tipo", c.mostrarTipo())

                        val intent = Intent(fragment.context, PrincipalAdministrador::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        fragment.activity?.startActivity(intent)
                    }
                }

                "Chofer_" -> {
                    if(codigo != 0L){
                        val ch = Chofer(usuario, rfc, nombre, celular, linea, codigo, 0, 0.0, "")
                        val c = Cuenta(correo, contrasenia, foto, 1, metodo, true)
                        val cCh = CuentaChofer(c.getCorreo(), ch.getUsuario())

                        localDB.addChoferes(ch)
                        localDB.addCuentas(c)
                        localDB.addCuentasChofer(cCh)
                        cloudDB.addChofer(ch)
                        cloudDB.addCuenta(c)
                        cloudDB.addCuentaChofer(cCh)

                        prefs.putString("tipo", c.mostrarTipo())

                        val intent = Intent(fragment.context, PrincipalChofer::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        fragment.activity?.startActivity(intent)
                    }
                }
            }

            fragment.activity?.finish()
            prefs.putString("metodo", metodo)
            prefs.putString("estado", "true")
            prefs.apply()
        }
    }

    private fun registrar(){
        Conexion.comprobarConexion(fragment.requireActivity())
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
                        when(val tipo = fragment.arguments?.getString("tipo")){
                            "Administrador_" -> {
                                cloudDB.getAuth().createUserWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
                                    if(it.isSuccessful){
                                        MensajeCodigo(tipo, clickListener = {
                                            codigo = it
                                            finalizar(tipo, usuario, rfc, nombre, celular, linea, correo, contrasenia, foto, "Correo")
                                        }).show(fragment.parentFragmentManager, "Codigo")
                                    }else MensajeAlerta("ERROR", "Se ha producido un error al autenticarte por Correo").show(fragment.parentFragmentManager, "Error")
                                }
                            }

                            "Chofer_" -> {
                                cloudDB.getAuth().createUserWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
                                    if(it.isSuccessful){
                                        MensajeCodigo(tipo, clickListener = {
                                            codigo = it
                                            finalizar(tipo, usuario, rfc, nombre, celular, linea, correo, contrasenia, foto, "Correo")
                                        }).show(fragment.parentFragmentManager, "Codigo")
                                    }else MensajeAlerta("ERROR", "Se ha producido un error al autenticarte por Correo").show(fragment.parentFragmentManager, "Error")
                                }
                            }

                            "Publico_" -> {
                                CoroutineScope(Dispatchers.IO).launch{
                                    val p = PublicoGeneral(usuario)
                                    val c = Cuenta(correo, contrasenia, foto, 2, "Correo", true)
                                    val cP = CuentaPublico(c.getCorreo(), p.getUsuario())

                                    cloudDB.getAuth().createUserWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
                                        if(it.isSuccessful){
                                            localDB.addPublicoGeneral(p)
                                            localDB.addCuentas(c)
                                            localDB.addCuentasPublico(cP)
                                            cloudDB.addPublicoGeneral(p)
                                            cloudDB.addCuenta(c)
                                            cloudDB.addCuentaPublico(cP)
                                        }else MensajeAlerta("ERROR", "Se ha producido un error al autenticarte por Correo").show(fragment.parentFragmentManager, "Error")
                                    }

                                    val prefs = fragment.requireActivity().getSharedPreferences(fragment.getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
                                    prefs.putString("correo", c.getCorreo())
                                    prefs.putString("contrasenia", c.getContrasenia())
                                    prefs.putString("foto", c.getFoto())
                                    prefs.putString("tipo", c.mostrarTipo())
                                    prefs.putString("metodo", c.getMetodo())
                                    prefs.putString("estado", c.getEstado().toString())
                                    prefs.apply()

                                    val intent = Intent(fragment.context, PrincipalPublico::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                    fragment.activity?.startActivity(intent)
                                    fragment.activity?.finish()
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