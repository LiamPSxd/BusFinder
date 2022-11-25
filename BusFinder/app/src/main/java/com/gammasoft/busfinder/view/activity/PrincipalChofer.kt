package com.gammasoft.busfinder.view.activity

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

class PrincipalChofer: AppCompatActivity(){
    private lateinit var binding: ActivityChoferBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private val localDB = LocalDataBase.getDB(this).crud()

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

        val correo = intent.getStringExtra("cuenta")
        localDB.getCuentaByCorreo(correo!!).observe(this){
            it.setEstado(true)
        }
    }
}