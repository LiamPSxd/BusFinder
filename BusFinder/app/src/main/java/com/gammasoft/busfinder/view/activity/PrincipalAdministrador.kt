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
import com.gammasoft.busfinder.databinding.ActivityAdministradorBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.*
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class PrincipalAdministrador: AppCompatActivity(){
    private lateinit var binding: ActivityAdministradorBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val localDB = LocalDataBase.getDB(this).crud()
    private val cloudDB = CloudDataBase.cloudDataBase

    private lateinit var prefs: SharedPreferences
    private var admin = Cuenta()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityAdministradorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.hide()

        navController = supportFragmentManager.findFragmentById(R.id.navHostAdministrador)!!.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentMapaAdmin, R.id.fragmentHomeAdmin, R.id.fragmentQuejaSugerencia, R.id.fragmentPerfilAdmin,)
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)

        prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.collection("Cuenta").whereEqualTo("correo", prefs.getString("correo", null)!!).get().addOnSuccessListener{
                for(cuenta in it) if(cuenta.exists()){
                    admin.setCorreo(cuenta.get("correo").toString())
                    admin.setContrasenia(cuenta.get("contrasenia").toString())
                    admin.setFoto(cuenta.get("foto").toString())
                    admin.setMetodo(cuenta.get("metodo").toString())
                    admin.setEstado(true)

                    var tipo = 3
                    when(cuenta.get("tipo").toString()){
                        "Administrador" -> tipo = 0
                        "Chofer" -> tipo = 1
                        "Publico General" -> tipo = 2
                    }
                    admin.setTipo(tipo)

                    CoroutineScope(Dispatchers.IO).launch{
                        localDB.addCuentas(admin)
                        CloudDataBase.addCuenta(admin)
                    }

                    cloudDB.collection("CuentaAdministrador").whereEqualTo("cuentaCorreo", admin.getCorreo()).get().addOnSuccessListener{ cAs ->
                        for(cA in cAs) if(cA.exists()){
                            cloudDB.collection("Administrador").whereEqualTo("usuario", cA.get("administradorUsuario").toString()).get().addOnSuccessListener{ admins ->
                                for(a in admins) if(a.exists()){
                                    migrarDatos(a.get("rfc").toString(), admin.getCorreo())
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

    private fun migrarDatos(rfc: String, correo: String){
        CoroutineScope(Dispatchers.IO).launch{
            if(rfc.isNotEmpty()){
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

                cloudDB.collection("Ruta").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
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

                cloudDB.collection("Parada").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
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

                        for(parada in it) if(parada.exists()){
                            cloudDB.collection("RutaParada").whereEqualTo("paradaID", parada.get("id").toString().toInt()).get().addOnSuccessListener{
                                CoroutineScope(Dispatchers.IO).launch{
                                    for(rutaParada in it) if(rutaParada.exists()){
                                        localDB.addRutaParadas(RutaParada(
                                            rutaParada.get("rutaID").toString().toInt(),
                                            rutaParada.get("paradaID").toString().toInt()
                                        ))
                                    }
                                }
                            }
                        }
                    }
                }

                cloudDB.collection("Tarifa").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
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

                cloudDB.collection("Coordenada").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
                    CoroutineScope(Dispatchers.IO).launch{
                        for(coordenada in it) if(coordenada.exists()){
                            localDB.addCoordenadas(Coordenada(
                                coordenada.get("id").toString().toInt(),
                                coordenada.get("longitud").toString().toDouble(),
                                coordenada.get("latitud").toString().toDouble(),
                                coordenada.get("administrador").toString()
                            ))
                        }

                        for(coordenada in it) if(coordenada.exists()){
                            cloudDB.collection("RutaCoordenada").whereEqualTo("coordenadaID", coordenada.get("id").toString().toInt()).get().addOnSuccessListener{
                                CoroutineScope(Dispatchers.IO).launch{
                                    for(rutaCoordenada in it) if(rutaCoordenada.exists()){
                                        localDB.addRutaCoordenadas(RutaCoordenada(
                                            rutaCoordenada.get("rutaID").toString().toInt(),
                                            rutaCoordenada.get("coordenadaID").toString().toInt()
                                        ))
                                    }
                                }
                            }
                        }
                    }
                }

                cloudDB.collection("CuentaAdministrador").whereEqualTo("cuentaCorreo", correo).get().addOnSuccessListener{ cAs ->
                    CoroutineScope(Dispatchers.IO).launch{
                        for(cA in cAs) if(cA.exists()){
                            cloudDB.collection("Administrador").whereEqualTo("usuario", cA.get("administradorUsuario").toString()).get().addOnSuccessListener{ admins ->
                                CoroutineScope(Dispatchers.IO).launch{
                                    for(admin in admins) if(admin.exists()){
                                        localDB.addAdministradores(Administrador(
                                                admin.get("usuario").toString(),
                                                admin.get("rfc").toString(),
                                                admin.get("nombre").toString(),
                                                admin.get("numeroCelular").toString().toLong(),
                                                admin.get("lineaTransporte").toString(),
                                                admin.get("codigo").toString().toLong()
                                        ))

                                        localDB.addCuentasAdministrador(CuentaAdministrador(
                                            cA.get("cuentaCorreo").toString(),
                                            cA.get("administradorUsuario").toString()
                                        ))
                                    }
                                }
                            }
                        }
                    }
                }

                cloudDB.collection("SugerenciaQueja").get().addOnSuccessListener{ qs ->
                    CoroutineScope(Dispatchers.IO).launch{
                        for(q in qs) if(q.exists()){
                            localDB.addSugerenciaQueja(
                                QuejaSugerencia(
                                q.get("id").toString().toInt(),
                                q.get("descripcion").toString(),
                                q.get("usuario").toString()
                            )
                            )
                        }
                    }
                }
            }else MensajeAlerta("ADVERTENCIA", "No se han podido migrar los datos de la cuenta").show(supportFragmentManager, "Advertencia")
        }
    }

    override fun onDestroy(){
        super.onDestroy()
        if(admin.getEstado()) exitProcess(0)
    }
}