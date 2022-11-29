package com.gammasoft.busfinder.controller

import android.content.Intent
import android.view.View
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.fragment.app.Fragment
import com.facebook.login.LoginManager
import com.gammasoft.busfinder.databinding.FragmentPerfilAdminChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.activity.Bienvenida
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PerfilAdministradorChoferEvento(private val fragment: Fragment,
                                      private val binding: FragmentPerfilAdminChoferBinding,
                                      private val cuenta: Cuenta): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnCambiarFotoPerfil.id -> cambiarFotoPerfil()
            binding.btnCerrarSesion.id -> cerrarSesion()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(fragment.parentFragmentManager, "Error")
        }
    }

    private val pickMedia = fragment.registerForActivityResult(PickVisualMedia()){ uri ->
        if(uri != null) Picasso.get().load(uri).into(binding.fotoPerfil)
    }

    private fun cambiarFotoPerfil() =
        pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))

    private fun cerrarSesion(){
        val localDB = LocalDataBase.getDB(fragment.requireContext()).crud()

        cuenta.setEstado(false)

        when(cuenta.mostrarTipo()){
            "Administrador" -> {
                CoroutineScope(Dispatchers.IO).launch{
                    localDB.deleteChoferes()
                    localDB.deleteRutas()
                    localDB.deleteParadas()
                    localDB.deleteTarifas()
                    localDB.deleteCoordenadas()
                }
            }

            "Chofer" -> {
                CoroutineScope(Dispatchers.IO).launch{
                    localDB.deleteRutas()
                    localDB.deleteParadas()
                    localDB.deleteTarifas()
                    localDB.deleteCoordenadas()
                }
            }
        }

        when(cuenta.getMetodo()){
            "Correo", "Google" -> CloudDataBase.getAuth().signOut()

            "Facebook" -> LoginManager.getInstance().logOut()

            "Twitter" -> {}

            else -> MensajeAlerta("ERROR", "Método de la cuenta no encontrado").show(fragment.parentFragmentManager, "Error")
        }

        fragment.activity?.startActivity(Intent(fragment.context, Bienvenida::class.java))
        fragment.activity?.finish()
    }
}