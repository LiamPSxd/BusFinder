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
import com.gammasoft.busfinder.databinding.ActivityPublicoBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.*
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class PrincipalPublico: AppCompatActivity(){
    private lateinit var binding: ActivityPublicoBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val localDB = LocalDataBase.getDB(this).crud()
    private val cloudDB = CloudDataBase.cloudDataBase

    private lateinit var prefs: SharedPreferences
    private var publico = Cuenta()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityPublicoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.hide()

        navController = supportFragmentManager.findFragmentById(R.id.navHostPublico)!!.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentHomePublico, R.id.fragmentMapaPublico, R.id.fragmentPerfilPublico)
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)

        prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.collection("Cuenta").whereEqualTo("correo", prefs.getString("correo", null)!!).get().addOnSuccessListener{
                for(cuenta in it) if(cuenta.exists()){
                    publico.setCorreo(cuenta.get("correo").toString())
                    publico.setContrasenia(cuenta.get("contrasenia").toString())
                    publico.setFoto(cuenta.get("foto").toString())
                    publico.setMetodo(cuenta.get("metodo").toString())
                    publico.setEstado(true)

                    var tipo = 3
                    when(cuenta.get("tipo").toString()){
                        "Administrador" -> tipo = 0
                        "Chofer" -> tipo = 1
                        "Publico General" -> tipo = 2
                    }
                    publico.setTipo(tipo)

                    CoroutineScope(Dispatchers.IO).launch{
                        localDB.updateCuenta(publico)
                    }

                    migrarDatos(publico.getCorreo())
                    break
                }
            }
        }
    }

    private fun migrarDatos(correo: String){
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.collection("Chofer").get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(chofer in it) if(chofer.exists()){
                        localDB.addChoferes(Chofer(
                            chofer.get("usuario").toString(),
                            chofer.get("rfc").toString(),
                            chofer.get("nombre").toString(),
                            chofer.get("numeroCelular").toString().toLong(),
                            chofer.get("lineaTransporte").toString(),
                            chofer.get("codigo").toString().toLong(),
                            chofer.get("numeroUsuarios").toString().toInt(),
                            chofer.get("calificacion").toString().toDouble(),
                            chofer.get("administrador").toString()
                        ))
                    }
                }
            }

            cloudDB.collection("Ruta").get().addOnSuccessListener{
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

            cloudDB.collection("Parada").get().addOnSuccessListener{
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

            cloudDB.collection("Tarifa").get().addOnSuccessListener{
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

            cloudDB.collection("Coordenada").get().addOnSuccessListener{
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

            cloudDB.collection("CuentaPublic").whereEqualTo("cuentaCorreo", correo).get().addOnSuccessListener{ cPs ->
                for(cP in cPs) if(cP.exists()){
                    cloudDB.collection("PublicoGeneral").whereEqualTo("usuario", cP.get("publicoGeneralUsuario").toString()).get().addOnSuccessListener{ publicos ->
                        CoroutineScope(Dispatchers.IO).launch{
                            for(p in publicos) if(p.exists()){
                                localDB.addPublicoGeneral(PublicoGeneral(
                                    p.get("usuario").toString()
                                ))
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        if(publico.getEstado()) exitProcess(0)
    }
}