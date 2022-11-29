package com.gammasoft.busfinder.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.ActivityAdministradorBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.*
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PrincipalAdministrador: AppCompatActivity(){
    private lateinit var binding: ActivityAdministradorBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val localDB = LocalDataBase.getDB(this).crud()
    private val cloudDB = CloudDataBase.cloudDataBase

    private var administrador = Administrador()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityAdministradorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.hide()

        navController = supportFragmentManager.findFragmentById(R.id.navHostAdministrador)!!.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentMapaAdmin, R.id.fragmentHomeAdmin, R.id.fragmentPerfilAdmin)
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)

        migrarDatos()

        val correo = intent.getStringExtra("cuenta")!!
        localDB.getCuentaByCorreo(correo).observe(this){ cuenta ->
            cuenta.setEstado(true)

            localDB.getCuentaAdministradorByCorreo(cuenta.getCorreo()).observe(this){
                localDB.getAdministradorByUsuario(it.getAdminUsuario()).observe(this){ admin ->
                    administrador = admin
                }
            }
        }

        supportFragmentManager.setFragmentResult("Administrador", bundleOf("administrador" to administrador.getRfc()))
    }

    private fun migrarDatos(){
        CoroutineScope(Dispatchers.IO).launch{
            val rfc = administrador.getNombre()

            cloudDB.collection("Chofer").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
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
                }
            }
        }
    }
}