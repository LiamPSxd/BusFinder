package com.gammasoft.busfinder.view.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.ActivityChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.*
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class PrincipalChofer: AppCompatActivity(){
    private lateinit var binding: ActivityChoferBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val localDB = LocalDataBase.getDB(this).crud()
    private val cloudDB = CloudDataBase.cloudDataBase

    private lateinit var prefs: SharedPreferences
    private var chofer = Cuenta()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityChoferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.hide()

        navController = supportFragmentManager.findFragmentById(R.id.navHostChofer)!!.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentMapaChofer, R.id.fragmentHomeChofer, R.id.fragmentPerfilChofer)
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)

        prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.collection("Cuenta").whereEqualTo("correo", prefs.getString("correo", null)!!).get().addOnSuccessListener{
                for(cuenta in it) if(cuenta.exists()){
                    chofer.setCorreo(cuenta.get("correo").toString())
                    chofer.setContrasenia(cuenta.get("contrasenia").toString())
                    chofer.setFoto(cuenta.get("foto").toString())
                    chofer.setMetodo(cuenta.get("metodo").toString())
                    chofer.setEstado(true)

                    var tipo = 3
                    when(cuenta.get("tipo").toString()){
                        "Administrador" -> tipo = 0
                        "Chofer" -> tipo = 1
                        "Publico General" -> tipo = 2
                    }
                    chofer.setTipo(tipo)

                    CoroutineScope(Dispatchers.IO).launch{
                        localDB.updateCuenta(chofer)
                    }

                    cloudDB.collection("CuentaChofer").whereEqualTo("cuentaCorreo", chofer.getCorreo()).get().addOnSuccessListener{ cCs ->
                        for(cC in cCs) if(cC.exists()){
                            cloudDB.collection("Chofer").whereEqualTo("usuario", cC.get("choferUsuario").toString()).get().addOnSuccessListener{ choferes ->
                                for(ch in choferes) if(ch.exists()){
                                    migrarDatos(ch.get("administrador").toString(), chofer.getCorreo())
                                    break
                                }
                            }
                            break
                        }
                    }
                }
            }
        }
    }

    private fun migrarDatos(rfcAdmin: String, correo: String){
        CoroutineScope(Dispatchers.IO).launch{
            if(rfcAdmin.isNotEmpty()){
                cloudDB.collection("Ruta").whereEqualTo("administrador", rfcAdmin).get().addOnSuccessListener{
                    CoroutineScope(Dispatchers.IO).launch{
                        for(ruta in it) if(ruta.exists()){
                            localDB.addRutas(Ruta(
                                ruta.get("id").toString().toInt(),
                                ruta.get("nombre").toString(),
                                ruta.get("administrador").toString()
                            ))
                        }
                    }
                }

                cloudDB.collection("Parada").whereEqualTo("administrador", rfcAdmin).get().addOnSuccessListener{
                    CoroutineScope(Dispatchers.IO).launch{
                        for(parada in it) if(parada.exists()){
                            localDB.addParadas(Parada(
                                parada.get("id").toString().toInt(),
                                parada.get("nombre").toString(),
                                parada.get("longitud").toString().toDouble(),
                                parada.get("latitud").toString().toDouble(),
                                parada.get("administrador").toString()
                            ))
                        }
                    }
                }

                cloudDB.collection("Tarifa").whereEqualTo("administrador", rfcAdmin).get().addOnSuccessListener{
                    CoroutineScope(Dispatchers.IO).launch{
                        for(tarifa in it) if(tarifa.exists()){
                            localDB.addTarifas(Tarifa(
                                tarifa.get("nombre").toString(),
                                tarifa.get("precio").toString().toDouble(),
                                tarifa.get("administrador").toString()
                            ))
                        }
                    }
                }

                cloudDB.collection("Coordenada").whereEqualTo("administrador", rfcAdmin).get().addOnSuccessListener{
                    CoroutineScope(Dispatchers.IO).launch{
                        for(coordenada in it) if(coordenada.exists()){
                            localDB.addCoordenadas(Coordenada(
                                coordenada.get("id").toString().toInt(),
                                coordenada.get("longitud").toString().toDouble(),
                                coordenada.get("latitud").toString().toDouble(),
                                coordenada.get("administrador").toString()
                            ))
                        }
                    }
                }

                cloudDB.collection("CuentaChofer").whereEqualTo("cuentaCorreo", correo).get().addOnSuccessListener{ cCs ->
                    CoroutineScope(Dispatchers.IO).launch{
                        for(cC in cCs) if(cC.exists()){
                            cloudDB.collection("Chofer").whereEqualTo("usuario", cC.get("choferUsuario").toString()).get().addOnSuccessListener{ choferes ->
                                CoroutineScope(Dispatchers.IO).launch{
                                    for(ch in choferes) if(ch.exists()){
                                        localDB.addChoferes(Chofer(
                                            ch.get("usuario").toString(),
                                            ch.get("rfc").toString(),
                                            ch.get("nombre").toString(),
                                            ch.get("numeroCelular").toString().toLong(),
                                            ch.get("lineaTransporte").toString(),
                                            ch.get("codigo").toString().toLong(),
                                            ch.get("numeroUsuarios").toString().toInt(),
                                            ch.get("calificacion").toString().toDouble(),
                                            ch.get("administracion").toString()
                                        ))

                                        localDB.addCuentasChofer(CuentaChofer(
                                            cC.get("cuentaCorreo").toString(),
                                            cC.get("administradorUsuario").toString()
                                        ))
                                    }
                                }
                            }
                        }
                    }
                }
            }else MensajeAlerta("ADVERTENCIA", "No se han podido migrar los datos de la cuenta").show(supportFragmentManager, "Advertencia")
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        if(chofer.getEstado()) exitProcess(0)
    }
}