package com.gammasoft.busfinder.controller

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.UnknownHostException

class Conexion{
    companion object{
        private var exitValue = 1

        fun comprobarConexion(activity: Activity): String{
            var conexion = "NO INTERNET"

            val redInfo = (activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).allNetworkInfo

            for(info in redInfo){
                if(info.typeName.equals("WIFI", ignoreCase = true))
                    if(info.isConnected && ping()) conexion = "WIFI"

                if(info.typeName.equals("MOBILE", ignoreCase = true))
                    if(info.isConnected && ping()) conexion = "MOBILE"
            }

            return conexion
        }

        private fun ping(): Boolean{
            try{
                CoroutineScope(Dispatchers.IO).launch{
                    val ipProcess = withContext(Dispatchers.IO){
                        Runtime.getRuntime().exec("/system/bin/ping -c 1 www.google.com")
                    }

                    setExitValue(withContext(Dispatchers.IO){
                        ipProcess.waitFor()
                    })

                    ipProcess.destroy()
                }

                return getExitValue() == 0
            }catch(_: UnknownHostException){
            }catch(_: IOException){
            }catch(_: InterruptedException){}

            return false
        }

        private fun setExitValue(ev: Int){
            exitValue = ev
        }

        private fun getExitValue(): Int{
            return exitValue
        }
    }
}