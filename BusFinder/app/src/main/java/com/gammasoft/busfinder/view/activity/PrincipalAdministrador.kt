package com.gammasoft.busfinder.view.activity

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
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer
import com.gammasoft.busfinder.model.dbLocal.entidades.Parada
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta
import com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa
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

        val correo = intent.getStringExtra("cuenta")
        localDB.getCuentaByCorreo(correo!!).observe(this){
            it.setEstado(true)
        }
    }

    private fun migrarDatos(){
        CoroutineScope(Dispatchers.IO).launch{
            cloudDB.collection("Chofer").get().addOnSuccessListener{
                for(chofer in it) if(chofer.exists()){
                    localDB.addChoferes(Chofer(
                        chofer.getString("usuario").toString(),
                        chofer.getString("rfc").toString(),
                        chofer.getString("nombre").toString(),
                        chofer.getLong("numeroCelular").toString().toLong(),
                        chofer.getString("lineaTransporte").toString(),
                        chofer.getLong("codigo").toString().toLong(),
                        chofer.getLong("numeroUsuarios").toString().toInt(),
                        chofer.getDouble("calificacion").toString().toDouble()
                    ))
                }
            }

            cloudDB.collection("Ruta").get().addOnSuccessListener{
                for(ruta in it) if(ruta.exists()){
                    localDB.addRutas(Ruta(
                        ruta.getLong("id").toString().toInt(),
                        ruta.getString("nombre").toString()
                    ))
                }
            }

            cloudDB.collection("Parada").get().addOnSuccessListener{
                for(parada in it) if(parada.exists()){
                    localDB.addParadas(Parada(
                        parada.getString("id").toString().toInt(),
                        parada.getString("nombre").toString(),
                    ))
                }
            }

            cloudDB.collection("Tarifa").get().addOnSuccessListener{
                for(tarifa in it) if(tarifa.exists()){
                    localDB.addTarifas(Tarifa(
                        tarifa.getString("nombre").toString(),
                        tarifa.getDouble("precio").toString().toDouble()
                    ))
                }
            }
        }
    }
}