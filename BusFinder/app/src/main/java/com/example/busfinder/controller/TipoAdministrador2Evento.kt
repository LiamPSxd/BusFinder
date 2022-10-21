package com.example.busfinder.controller

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.busfinder.R
import com.example.busfinder.databinding.FragmentTipoAdministrador2Binding
import com.example.busfinder.model.dbLocal.LocalDataBase
import com.example.busfinder.model.dbLocal.entidades.Administrador
import com.example.busfinder.model.dbLocal.entidades.Cuenta
import com.example.busfinder.model.dbLocal.relaciones.CuentaAdministrador
import com.example.busfinder.view.dialog.MensajeAlertaDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TipoAdministrador2Evento(private var fragment: Fragment,
                               private var binding: FragmentTipoAdministrador2Binding): View.OnClickListener{
    private val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

    private var internet = false

    override fun onClick(v: View?){
        when(v?.id){
            binding.btnCambiarFotoPerfil.id -> cambiarFotoPerfil()
            binding.btnGoogle.id -> autenticarGoogle()
            binding.btnFacebook.id -> autenticarFacebook()
            binding.btnTwitter.id -> autenticarTwitter()
            binding.btnContinuarTipoAdmin2.id -> registrar()
            else -> Toast.makeText(fragment.context, "Error: Acción no encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cambiarFotoPerfil(){
        Toast.makeText(fragment.context, "Cambiando foto de perfil...", Toast.LENGTH_SHORT).show()
    }

    private fun autenticarGoogle(){
        internet = true
    }

    private fun autenticarFacebook(){
    }

    private fun autenticarTwitter(){
    }

    private fun registrar(){
        val foto = 0
        val usuario = binding.txtUsuario.text.toString()
        val correo = binding.txtCorreo.text.toString()
        val contrasenia = binding.txtContrasenia.text.toString()
        val codigo = null

        if(usuario.isNotEmpty() && correo.isNotEmpty() && contrasenia.isNotEmpty()){
            if(!verificarUsuarioCorreo(usuario)){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo, contrasenia).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(fragment.context, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                    }else{
                        MensajeAlertaDialog(fragment.requireContext(), "Error", "Se ha producido un error al autenticarte").mostrarAlerta()
                    }
                }

                localDB.getAdministradorByUsuario("adminPendiente").observe(fragment, Observer{ admin ->
                    CoroutineScope(Dispatchers.IO).launch{
                        localDB.updateAdministrador(Administrador(usuario, admin.getRfc(), admin.getNombre(), admin.getNumCelular(), admin.getLinea(), admin.getCodigo()))
                        localDB.addCuentas(Cuenta(correo, contrasenia, foto, 0, true))
                        localDB.addCuentasAdministrador(CuentaAdministrador(correo, usuario))
                    }
                })

                localDB.getCuentaAdministradorByUsuario(usuario).observe(fragment, Observer{ admin ->
                    if(admin != null){
                        Toast.makeText(fragment.context, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                    }else Toast.makeText(fragment.context, "¡Hubo un error al crear su cuenta!", Toast.LENGTH_SHORT).show()
                })
            }else Toast.makeText(fragment.context, "Usuario o Correo ya registrados", Toast.LENGTH_SHORT).show()
        }else if(usuario.isEmpty()){
            Toast.makeText(fragment.context, "Falta ingresar su Usuario", Toast.LENGTH_SHORT).show()
        }else if(correo.isEmpty()){
            Toast.makeText(fragment.context, "Falta ingresar su Correo", Toast.LENGTH_SHORT).show()
        }else if(contrasenia.isEmpty()){
            Toast.makeText(fragment.context, "Falta ingresar su Contraseña", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(fragment.context, "¡¡ERROR!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verificarUsuarioCorreo(usuario: String): Boolean{
        var res = false

        localDB.getCuentaAdministradorByUsuario(usuario).observe(fragment, Observer{ admin ->
            if(admin != null) res = true
        })

        localDB.getCuentaChoferByUsuario(usuario).observe(fragment, Observer{ chofer ->
            if(chofer != null) res = true
        })

        localDB.getCuentaPublicoByUsuario(usuario).observe(fragment, Observer{ publico ->
            if(publico != null) res = true
        })

        return res
    }
}