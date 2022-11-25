package com.gammasoft.busfinder.controller

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gammasoft.busfinder.databinding.ActivityBienvenidaBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.activity.*
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BienvenidaEvento(private var activity: AppCompatActivity,
                       private var binding: ActivityBienvenidaBinding): View.OnClickListener{
    override fun onClick(v: View?){
        when(v?.id){
            binding.btnIniciarSesion.id -> iniciarSesion()
            binding.btnCrearCuenta.id -> crearCuenta()
            else -> MensajeAlerta("ERROR", "Acción no encontrada").show(activity.supportFragmentManager, "Error")
        }
    }

    private fun iniciarSesion(){
        activity.startActivity(Intent(activity, IniciarSesion::class.java))
    }

    private fun crearCuenta(){
        activity.startActivity(Intent(activity, CrearCuenta::class.java))
    }

    private fun iniciarPantallaPrincipal(cuentas: ArrayList<Cuenta>): Boolean{
        if(cuentas.size != 0) for(cuenta in cuentas){
            if(cuenta.getEstado()){
                when(cuenta.mostrarTipo()){
                    "Administrador" -> {
                        val intent = Intent(activity, PrincipalAdministrador::class.java)
                        intent.putExtra("cuenta", cuenta.getCorreo())
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        activity.startActivity(intent)
                        return true
                    }

                    "Chofer" -> {
                        val intent = Intent(activity, PrincipalChofer::class.java)
                        intent.putExtra("cuenta", cuenta.getCorreo())
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        activity.startActivity(intent)
                        return true
                    }

                    "Publico General" -> {
                        val intent = Intent(activity, PrincipalPublico::class.java)
                        intent.putExtra("cuenta", cuenta.getCorreo())
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        activity.startActivity(intent)
                        return true
                    }

                    "Error" -> MensajeAlerta("ADVERTENCIA", "No se ha encontrado la cuenta").show(activity.supportFragmentManager, "Advertencia")
                    else -> MensajeAlerta("ERROR", "Actividad no encontrada").show(activity.supportFragmentManager, "Error")
                }
            }
        }

        return false
    }

    fun sesion(): Boolean{
        var cuentas = ArrayList<Cuenta>()
        var res = false

        when(Conexion.comprobarConexion(activity)){
            "WIFI", "MOBILE" -> CoroutineScope(Dispatchers.IO).launch{
                CloudDataBase.cloudDataBase.collection("Cuenta").whereEqualTo("estado", true).get().addOnSuccessListener{
                    for(cuenta in it) if(cuenta.exists()){
                        var tipo = 3
                        when(cuenta.getString("tipo").toString()){
                            "Administrador" -> tipo = 0
                            "Chofer" -> tipo = 1
                            "Publico General" -> tipo = 2
                        }

                        cuentas.add(Cuenta(
                            cuenta.getString("correo").toString(),
                            cuenta.getString("contrasenia").toString(),
                            cuenta.getString("foto").toString(),
                            tipo,
                            cuenta.getString("metodo").toString(),
                            cuenta.getBoolean("estado").toString().toBoolean()
                        ))
                    }

                    if(iniciarPantallaPrincipal(cuentas)) res = true
                }
            }

            "NO INTERNET" -> {
                val localDB = LocalDataBase.getDB(activity).crud()

                localDB.getCuentas().observe(activity){
                    cuentas = it as ArrayList<Cuenta>
                }

                if(iniciarPantallaPrincipal(cuentas)) res = true
            }
        }

        return res
    }
}