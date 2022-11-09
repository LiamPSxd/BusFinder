package com.gammasoft.busfinder.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.databinding.ActivityAdministradorBinding

class PrincipalAdministrador: AppCompatActivity(){
    private lateinit var binding: ActivityAdministradorBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityAdministradorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.hide()

        navController = findNavController(R.id.navHostAdministrador)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navVisualizarAdmin, R.id.navBorrarAdmin, R.id.navAgregarAdmin /*, R.id.navModificarAdmin, R.id.navPerfilAdmin*/
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navViewAdmin.setupWithNavController(navController)
    }
}