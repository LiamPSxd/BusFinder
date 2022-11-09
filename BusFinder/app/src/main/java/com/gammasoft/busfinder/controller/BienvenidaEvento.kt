package com.gammasoft.busfinder.controller

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.ActivityBienvenidaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.activity.*
import com.gammasoft.busfinder.view.dialog.MensajeAlerta

class BienvenidaEvento(private var activity: AppCompatActivity,
                       private var binding: ActivityBienvenidaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnIniciarSesion.id -> iniciarSesion()
            binding.btnCrearCuenta.id -> crearCuenta()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
        }
    }

    private fun iniciarSesion(){
        activity.startActivity(Intent(activity, IniciarSesion::class.java))
    }

    private fun crearCuenta(){
        activity.startActivity(Intent(activity, CrearCuenta::class.java))
    }

    fun sesion(): Boolean{
        var res = false
        lateinit var cuentas: List<Cuenta>
        activity.setVisible(false)

        when(Conexion.comprobarConexion(activity)){
            "WIFI" -> {
                val cloudDB = CloudDataBase

                cuentas = cloudDB.getCuentas()
            }

            "MOBILE", "NO INTERNET" -> {
                val localDB = LocalDataBase.getDB(activity).crud()

                localDB.getCuentas().observe(activity){
                    cuentas = it
                }
            }
        }

        for(cuenta in cuentas){
            if(cuenta.getEstado()){
                when(cuenta.mostrarTipo()){
                    "Administrador" -> {
                        activity.startActivity(Intent(activity, PrincipalAdministrador::class.java))
                        res = true
                    }

                    "Chofer" -> {
                        activity.startActivity(Intent(activity, PrincipalChofer::class.java))
                        res = true
                    }

                    "Publico General" -> {
                        activity.startActivity(Intent(activity, PrincipalPublico::class.java))
                        res = true
                    }

                    "Error" -> MensajeAlerta("ADVERTENCIA", "No se ha encontrado la cuenta").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                    else -> MensajeAlerta("ERROR", "Actividad no encontrada").mostrar(R.anim.zoom_in, R.anim.zoom_out)
                }
            }
        }

        return res
    }
}