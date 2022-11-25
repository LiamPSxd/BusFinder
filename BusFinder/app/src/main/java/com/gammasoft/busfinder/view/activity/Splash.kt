package com.gammasoft.busfinder.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class Splash: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        val screenSplash =  installSplashScreen()
        super.onCreate(savedInstanceState)

        Thread.sleep(1000)
        screenSplash.setKeepOnScreenCondition{ true }
        startActivity(Intent(this, Bienvenida::class.java))
        finish()
    }
}