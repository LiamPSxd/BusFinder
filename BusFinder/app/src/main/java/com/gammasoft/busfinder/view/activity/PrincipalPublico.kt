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
import com.gammasoft.busfinder.databinding.ActivityPublicoBinding
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral

class PrincipalPublico: AppCompatActivity(){
    private lateinit var binding: ActivityPublicoBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val localDB = LocalDataBase.getDB(this).crud()

    private lateinit var publico: PublicoGeneral

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

        val correo = intent.getStringExtra("cuenta")!!
        localDB.getCuentaByCorreo(correo).observe(this){ cuenta ->
            cuenta.setEstado(true)

            localDB.getCuentaPublicoByCorreo(cuenta.getCorreo()).observe(this){
                localDB.getPublicoGeneralByUsuario(it.getPublicoUsuario()).observe(this){ p ->
                    publico = p
                }
            }
        }

        supportFragmentManager.setFragmentResult("Publico", bundleOf("publico" to publico.getUsuario()))
    }
}