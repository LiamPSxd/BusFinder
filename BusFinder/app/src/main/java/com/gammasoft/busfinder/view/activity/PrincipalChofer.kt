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
import com.gammasoft.busfinder.databinding.ActivityChoferBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.*
import com.gammasoft.busfinder.model.dbNube.CloudDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PrincipalChofer: AppCompatActivity(){
    private lateinit var binding: ActivityChoferBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val localDB = LocalDataBase.getDB(this).crud()
    private val cloudDB = CloudDataBase.cloudDataBase

    private var chofer = Chofer()

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

        migrarDatos()

        val correo = intent.getStringExtra("cuenta")!!
        localDB.getCuentaByCorreo(correo).observe(this){ cuenta ->
            cuenta.setEstado(true)

            localDB.getCuentaChoferByCorreo(cuenta.getCorreo()).observe(this){
                localDB.getChoferByUsuario(it.getChoferUsuario()).observe(this){ ch ->
                    chofer = ch
                }
            }
        }

        supportFragmentManager.setFragmentResult("Chofer", bundleOf("chofer" to chofer.getRfc()))
    }

    private fun migrarDatos(){
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.collection("Ruta").whereEqualTo("administrador", chofer.getAdministrador()).get().addOnSuccessListener{
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

            cloudDB.collection("Parada").whereEqualTo("administrador", chofer.getAdministrador()).get().addOnSuccessListener{
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

            cloudDB.collection("Tarifa").whereEqualTo("administrador", chofer.getAdministrador()).get().addOnSuccessListener{
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

            cloudDB.collection("Coordenada").whereEqualTo("administrador", chofer.getAdministrador()).get().addOnSuccessListener{
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