package com.example.busfinder.model.dbLocal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busfinder.model.dbLocal.entidades.*
import com.example.busfinder.model.dbLocal.relaciones.*

@Database(entities = [Cuenta::class, Administrador::class, Chofer::class,
    PublicoGeneral::class, Ruta::class, Calle::class, Parada::class,
    Coordenada::class, Unidad::class, Tarifa::class, Horario::class,
    CuentaAdministrador::class, CuentaChofer::class, CuentaPublico::class,
    ParadaCoordenada::class, CalleCoordenada::class, RutaCalle::class,
    RutaParada::class, UnidadCoordenada::class, HorarioCUR::class],
    version = 3,
    exportSchema = false)
abstract class LocalDataBase: RoomDatabase(){
    abstract fun crud(): Crud

    companion object{
        @Volatile
        private var INSTANCE: LocalDataBase? = null

        fun getDB(context: Context): LocalDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDataBase::class.java,
                    "localDataBase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}