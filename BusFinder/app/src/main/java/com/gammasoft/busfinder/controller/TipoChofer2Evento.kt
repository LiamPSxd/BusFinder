package com.gammasoft.busfinder.controller

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.FragmentTipoChofer2Binding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.activity.PrincipalChofer
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TipoChofer2Evento(private var fragment: Fragment,
                        private var binding: FragmentTipoChofer2Binding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()
    private val cloudDB = CloudDataBase

    val GOOGLE_SIGN_IN = 100

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnCambiarFotoPerfil.id -> cambiarFotoPerfil()
            binding.btnGoogle.id -> autenticarGoogle()
            binding.btnFacebook.id -> autenticarFacebook()
            binding.btnTwitter.id -> autenticarTwitter()
            binding.btnContinuarTipoChofer2.id -> registrar()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    private fun cambiarFotoPerfil(){
        Toast.makeText(fragment.context, "Cambiando foto de perfil...", Toast.LENGTH_SHORT).show()
    }

    private fun autenticarGoogle(){
        when(Conexion.comprobarConexion(fragment.requireContext())){
            "WIFI", "MOBILE" -> {
                val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(fragment.getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()

                val googleCliente = GoogleSignIn.getClient(fragment.requireContext(), googleConf)
                googleCliente.signOut()

                fragment.startActivityForResult(googleCliente.signInIntent, GOOGLE_SIGN_IN)
            }

            "NO INTERNET" -> MensajeAlerta("ERROR", "No tienes un conexión a Internet").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    fun iniciarByGoogle(task: Task<GoogleSignInAccount>){
        try{
            val cuenta = task.getResult(ApiException::class.java)

            if(cuenta != null){
                val ch = cloudDB.getChofer("choferPendiente")
                ch.setUsuario(cuenta.givenName.toString())
                val c = Cuenta(cuenta.email.toString(), "GOOGLE${ch.getUsuario()}", cuenta.photoUrl.toString().toInt(), 1, true)
                val cCh = CuentaChofer(c.getCorreo(), ch.getUsuario())

                cloudDB.addChofer(ch)
                cloudDB.addCuenta(c)
                cloudDB.addCuentaChofer(cCh.getCuentaCorreo(), cCh)
                cloudDB.addCuentaChofer(cCh.getChoferUsuario(), cCh)

                cloudDB.getAuth().signInWithCredential(GoogleAuthProvider.getCredential(cuenta.idToken, null)).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(fragment.context, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                        fragment.startActivity(Intent(fragment.context, PrincipalChofer::class.java))
                    }else MensajeAlerta("ERROR", "Se ha producido un error al autenticar tu cuenta por Google").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                }
            }
        }catch(e: ApiException){
            MensajeAlerta("ApiException", "${e.printStackTrace()}")
        }
    }

    private fun autenticarFacebook(){
    }

    private fun autenticarTwitter(){
    }

    private fun autenticarCorreo(correo: String, contrasenia: String, chofer: Chofer, cuenta: Cuenta, cuentaChofer: CuentaChofer){
        cloudDB.getAuth().createUserWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
            if(it.isSuccessful){
                cloudDB.addChofer(chofer)
                cloudDB.addCuenta(cuenta)
                cloudDB.addCuentaChofer(cuentaChofer.getCuentaCorreo(), cuentaChofer)
                cloudDB.addCuentaChofer(cuentaChofer.getChoferUsuario(), cuentaChofer)
            }else MensajeAlerta("ERROR", "Se ha producido un error al autenticarte por Correo").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    private fun registrar(){
        val foto = 0
        val usuario = binding.txtUsuario.text.toString()
        val correo = binding.txtCorreo.text.toString()
        val contrasenia = binding.txtContrasenia.text.toString()
        val confContrasenia = binding.txtConfirmarContrasenia.text.toString()
        val codigo = null

        if(usuario.isNotEmpty() && correo.isNotEmpty() && contrasenia.isNotEmpty() && confContrasenia.isNotEmpty()){
            if(!verificarUsuarioCorreoRegistrado(usuario) && contrasenia.length >= 6 && contrasenia == confContrasenia){
                localDB.getChoferByUsuario("choferPendiente").observe(fragment){ chofer ->
                    CoroutineScope(Dispatchers.IO).launch{
                        val ch = Chofer(usuario, chofer.getRfc(), chofer.getNombre(), chofer.getNumCelular(), chofer.getLinea(), chofer.getCodigo(), chofer.getNoUsuarios(), chofer.getCalificacion())
                        val c = Cuenta(correo, contrasenia, foto, 1, true)
                        val cCh = CuentaChofer(c.getCorreo(), ch.getUsuario())

                        localDB.updateChofer(ch)
                        localDB.addCuentas(c)
                        localDB.addCuentasChofer(cCh)

                        autenticarCorreo(c.getCorreo(), c.getContrasenia(), ch, c, cCh)
                    }
                }

                localDB.getCuentaChoferByUsuario(usuario).observe(fragment){ chofer ->
                    if(chofer != null){
                        Toast.makeText(fragment.context, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                        fragment.startActivity(Intent(fragment.context, PrincipalChofer::class.java))
                    }else MensajeAlerta("ERROR",  "¡Hubo un error al crear su cuenta!").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                }
            }else if(verificarUsuarioCorreoRegistrado(usuario)) MensajeAlerta("ADVERTENCIA", "Usuario o Correo ya registrados").mostrar(R.anim.zoom_in, R.anim.zoom_out)
            else if(contrasenia.length < 6) MensajeAlerta("ADVERTENCIA", "La Contraseña debe tener 6 o más caracteres").mostrar(R.anim.zoom_in, R.anim.zoom_out)
            else if(contrasenia != confContrasenia) MensajeAlerta("ADVERTENCIA", "Las contraseñas no coinciden").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }else if(usuario.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Usuario").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else if(correo.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Correo").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else if(contrasenia.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar su Contraseña").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else if(confContrasenia.isEmpty()) MensajeAlerta("ADVERTENCIA", "Falta ingresar la confirmación de su Contraseña").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        else MensajeAlerta("ERROR", "¡¡Error!!").mostrar(R.anim.zoom_in, R.anim.zoom_out)
    }

    private fun verificarUsuarioCorreoRegistrado(usuario: String): Boolean{
        var res = false

        if(cloudDB.getCuentaAdministrador(usuario).getAdminUsuario().isNotEmpty()) res = true

        if(cloudDB.getCuentaChofer(usuario).getChoferUsuario().isNotEmpty()) res = true

        if(cloudDB.getCuentaPublico(usuario).getPublicoUsuario().isNotEmpty()) res = true

        localDB.getCuentaAdministradorByUsuario(usuario).observe(fragment){ admin ->
            if(admin != null) res = true
        }

        localDB.getCuentaChoferByUsuario(usuario).observe(fragment){ chofer ->
            if(chofer != null) res = true
        }

        localDB.getCuentaPublicoByUsuario(usuario).observe(fragment){ publico ->
            if(publico != null) res = true
        }

        return res
    }
}