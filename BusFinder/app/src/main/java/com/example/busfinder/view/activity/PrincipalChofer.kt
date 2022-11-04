package com.example.busfinder.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.busfinder.R
import com.example.busfinder.databinding.ActivityChoferBinding

class PrincipalChofer: AppCompatActivity(){
    private lateinit var binding: ActivityChoferBinding

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityChoferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.navHostChofer)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                //R.id.navMapaChofer, R.id.navVisualizarChofer, R.id.navPerfilChofer
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navViewChofer.setupWithNavController(navController)
    }
}