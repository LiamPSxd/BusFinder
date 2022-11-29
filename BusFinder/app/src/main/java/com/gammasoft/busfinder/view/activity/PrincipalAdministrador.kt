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

    private lateinit var administrador: Administrador

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
                            chofer.getString("usuario").toString(),
                            chofer.getString("rfc").toString(),
                            chofer.getString("nombre").toString(),
                            chofer.getLong("numeroCelular").toString().toLong(),
                            chofer.getString("lineaTransporte").toString(),
                            chofer.getLong("codigo").toString().toLong(),
                            chofer.getLong("numeroUsuarios").toString().toInt(),
                            chofer.getDouble("calificacion").toString().toDouble(),
                            chofer.getString("administrador").toString()
                        ))
                    }
                }
            }

            cloudDB.collection("Ruta").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(ruta in it) if(ruta.exists()){
                        localDB.addRutas(Ruta(
                            ruta.getLong("id").toString().toInt(),
                            ruta.getString("nombre").toString(),
                            ruta.getString("administrador").toString()
                        ))
                    }
                }
            }

            cloudDB.collection("Parada").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(parada in it) if(parada.exists()){
                        localDB.addParadas(Parada(
                            parada.getString("id").toString().toInt(),
                            parada.getString("nombre").toString(),
                            parada.getString("longitud").toString().toDouble(),
                            parada.getString("latitud").toString().toDouble(),
                            parada.getString("administrador").toString()
                        ))
                    }
                }
            }

            cloudDB.collection("Tarifa").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(tarifa in it) if(tarifa.exists()){
                        localDB.addTarifas(Tarifa(
                            tarifa.getString("nombre").toString(),
                            tarifa.getDouble("precio").toString().toDouble(),
                            tarifa.getString("administrador").toString()
                        ))
                    }
                }
            }

            cloudDB.collection("Coordenada").whereEqualTo("administrador", rfc).get().addOnSuccessListener{
                CoroutineScope(Dispatchers.IO).launch{
                    for(coordenada in it) if(coordenada.exists()){
                        localDB.addCoordenadas(Coordenada(
                            coordenada.getString("id").toString().toInt(),
                            coordenada.getString("longitud").toString().toDouble(),
                            coordenada.getString("latitud").toString().toDouble(),
                            coordenada.getString("administrador").toString()
                        ))
                    }
                }
            }
        }
    }
}