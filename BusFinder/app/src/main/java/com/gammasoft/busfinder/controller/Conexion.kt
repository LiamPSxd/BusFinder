package com.gammasoft.busfinder.controller

import android.content.Context
import android.net.ConnectivityManager
import com.gammasoft.busfinder.R
import com.gammasoft.busfinder.view.dialog.MensajeAlerta
import java.io.IOException
import java.net.UnknownHostException

abstract class Conexion{
    companion object{
        private fun ping(): Boolean {
            val runtime = Runtime.getRuntime()

            try{
                val ipProcess = runtime.exec("/system/bin/ping -c 1 www.google.com")
                val exitValue = ipProcess.waitFor()
                ipProcess.destroy()

                return exitValue == 0
            }catch(e: UnknownHostException){
                MensajeAlerta("UnknownHostException", "${e.printStackTrace()}").mostrar(R.anim.zoom_in, R.anim.zoom_out)
            }catch(e: IOException){
                MensajeAlerta("IOException", "${e.printStackTrace()}").mostrar(R.anim.zoom_in, R.anim.zoom_out)
            }catch(e: InterruptedException){
                MensajeAlerta("InterruptedException", "${e.printStackTrace()}").mostrar(R.anim.zoom_in, R.anim.zoom_out)
            }

            return false
        }

        fun comprobarConexion(contexto: Context): String{
            var res = "NO INTERNET"

            val redInfo = (contexto.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).allNetworkInfo

            for(info in redInfo){
                if(info.typeName.equals("WIFI", ignoreCase = true))
                    if(info.isConnected && ping()) res = "WIFI"

                if(info.typeName.equals("MOBILE", ignoreCase = true))
                    if(info.isConnected && ping()) res = "MOBILE"
            }

            return res
        }
    }
}