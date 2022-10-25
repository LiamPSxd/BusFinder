package com.example.busfinder.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.busfinder.R
import com.example.busfinder.databinding.ActivityPublicoBinding

class PrincipalPublico: AppCompatActivity(){
    private lateinit var binding: ActivityPublicoBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityPublicoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.navHostPublico)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navVisualizarPublico, R.id.navMapaPublico, R.id.navPerfilPublico
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navViewPublico.setupWithNavController(navController)
    }
}