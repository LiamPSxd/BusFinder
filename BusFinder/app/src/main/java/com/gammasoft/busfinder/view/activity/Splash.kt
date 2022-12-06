package com.gammasoft.busfinder.view.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.model.dbLocal.Crud
import com.gammasoft.busfinder.model.dbLocal.LocalDataBase
import com.gammasoft.busfinder.view.dialog.MensajeAlerta

class Splash: AppCompatActivity(){
    private lateinit var prefs: SharedPreferences
    private lateinit var localDB: Crud

    private lateinit var intnt: Intent

    override fun onCreate(savedInstanceState: Bundle?){
        val screenSplash =  installSplashScreen()
        super.onCreate(savedInstanceState)

        prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        localDB = LocalDataBase.getDB(this).crud()

        Thread.sleep(1000)
        screenSplash.setKeepOnScreenCondition{ true }

        if(!sesion()) startActivity(Intent(this, Bienvenida::class.java))
        else if(sesion()){
            intnt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intnt.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intnt)
        }

        finish()
    }

    private fun sesion(): Boolean{
        var res = false

        if(prefs.getString("estado", null).toBoolean()){
            when(prefs.getString("tipo", null)!!){
                "Administrador" -> {
                    intnt = Intent(this, PrincipalAdministrador::class.java)
                    res = true
                }

                "Chofer" -> {
                    intnt = Intent(this, PrincipalChofer::class.java)
                    res = true
                }

                "Publico General" -> {
                    intnt = Intent(this, PrincipalPublico::class.java)
                    res =  true
                }

                "Error" -> MensajeAlerta("ADVERTENCIA", "No se ha encontrado la cuenta").show(supportFragmentManager, "Advertencia")
                else -> MensajeAlerta("ERROR", "Actividad no encontrada").show(supportFragmentManager, "Error")
            }
        }

        return res
    }
}