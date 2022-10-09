package com.example.busfinder.model.dbLocal

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import com.example.busfinder.model.dbLocal.entidades.Administrador
import com.example.busfinder.model.dbLocal.relaciones.CalleCoordenada
import com.example.busfinder.model.dbLocal.entidades.*
import com.example.busfinder.model.dbLocal.relaciones.*

@Dao
interface Crud{
//Cuenta
    @Query("SELECT * FROM Cuenta")
    fun getCuentas(): LiveData<List<Cuenta>>

    @Query("SELECT * FROM Cuenta WHERE correo = :correo")
    fun getCuentaByCorreo(correo: String): LiveData<Cuenta>

    @Insert
    suspend fun addCuentas(vararg cuentas: Cuenta)

    @Update
    suspend fun updateCuenta(vararg cuenta: Cuenta)

    @Delete
    suspend fun deleteCuenta(cuenta: Cuenta)

//Administrador
    @Query("SELECT * FROM Administrador")
    fun getAdministradores(): LiveData<List<Administrador>>

    @Query("SELECT * FROM Administrador WHERE usuario = :usuario")
    fun getAdministradorByUsuario(usuario: String): LiveData<Administrador>

    @Insert
    suspend fun addAdministradores(vararg administradores: Administrador)

    @Update
    suspend fun updateAdministrador(vararg administrador: Administrador)

    @Delete
    suspend fun deleteAdministrador(administrador: Administrador)

//Chofer
    @Query("SELECT * FROM Chofer")
    fun getChoferes(): LiveData<List<Chofer>>

    @Query("SELECT * FROM Chofer WHERE usuario = :usuario")
    fun getChoferByUsuario(usuario: String): LiveData<Chofer>

    @Insert
    suspend fun addChoferes(vararg choferes: Chofer)

    @Update
    suspend fun updateChofer(vararg chofer: Chofer)

    @Delete
    suspend fun deleteChofer(chofer: Chofer)

//PublicoGeneral
    @Query("SELECT * FROM PublicoGeneral")
    fun getPublicosGenerales(): LiveData<List<PublicoGeneral>>

    @Query("SELECT * FROM PublicoGeneral WHERE usuario = :usuario")
    fun getPublicoGeneralByUsuario(usuario: String): LiveData<PublicoGeneral>

    @Insert
    suspend fun addPublicoGeneral(vararg publicoGeneral: PublicoGeneral)

    @Update
    suspend fun updatePublicoGeneral(vararg publicoGeneral: PublicoGeneral)

    @Delete
    suspend fun deletePublicoGeneral(publicoGeneral: PublicoGeneral)

//Ruta
    @Query("SELECT * FROM Ruta")
    fun getRutas(): LiveData<List<Ruta>>

    @Query("SELECT * FROM Ruta WHERE id = :id")
    fun getRutaById(id: Int): LiveData<Ruta>

    @Insert
    suspend fun addRutas(vararg rutas: Ruta)

    @Update
    suspend fun updateRuta(vararg ruta: Ruta)

    @Delete
    suspend fun deleteRuta(ruta: Ruta)

//Calle
    @Query("SELECT * FROM Calle")
    fun getCalles(): LiveData<List<Calle>>

    @Query("SELECT * FROM Calle WHERE id = :id")
    fun getCalleById(id: Int): LiveData<Calle>

    @Insert
    suspend fun addCalles(vararg calles: Calle)

    @Update
    suspend fun updateCalle(vararg calle: Calle)

    @Delete
    suspend fun deleteCalle(calle: Calle)

//Unidad
    @Query("SELECT * FROM Unidad")
    fun getUnidades(): LiveData<List<Unidad>>

    @Query("SELECT * FROM Unidad WHERE placa = :placa")
    fun getUnidadByPlaca(placa: String): LiveData<Unidad>

    @Insert
    suspend fun addUnidades(vararg unidades: Unidad)

    @Update
    suspend fun updateUnidad(vararg unidad: Unidad)

    @Delete
    suspend fun deleteUnidad(unidad: Unidad)

//Tarifa
    @Query("SELECT * FROM Tarifa")
    fun getTarifas(): LiveData<List<Tarifa>>

    @Query("SELECT * FROM Tarifa WHERE nombre = :nombre")
    fun getTarifaByNombre(nombre: String): LiveData<Tarifa>

    @Insert
    suspend fun addTarifas(vararg tarifas: Tarifa)

    @Update
    suspend fun updateTarifa(vararg tarifa: Tarifa)

    @Delete
    suspend fun deleteTarifa(tarifa: Tarifa)

//Horario
    @Query("SELECT * FROM Horario")
    fun getHorarios(): LiveData<List<Horario>>

    @Query("SELECT * FROM Horario WHERE id = :id")
    fun getHorarioById(id: Int): LiveData<Horario>

    @Insert
    suspend fun addHorarios(vararg horarios: Horario)

    @Update
    suspend fun updateHorario(vararg horario: Horario)

    @Delete
    suspend fun deleteHorario(horario: Horario)

//Coordenada
    @Query("SELECT * FROM Coordenada")
    fun getCoordenadas(): LiveData<List<Coordenada>>

    @Query("SELECT * FROM Coordenada WHERE id = :id")
    fun getCoordenadaById(id: Int): LiveData<Coordenada>

    @Insert
    suspend fun addCoordenada(vararg coordenadas: Coordenada)

    @Update
    suspend fun updateCoordenada(vararg coordenada: Coordenada)

    @Delete
    suspend fun deleteCoordenada(coordenada: Coordenada)

//CuentaAdministrador
    @Query("SELECT * FROM CuentaAdministrador")
    fun getCuentasAdministrador(): LiveData<List<CuentaAdministrador>>

    @Query("SELECT * FROM CuentaAdministrador WHERE administrador_Usuario = :usuario")
    fun getCuentaAdministradorByUsuario(usuario: String): LiveData<CuentaAdministrador>

    @Query("SELECT correo, contrasenia, tipo FROM Cuenta INNER JOIN CuentaAdministrador WHERE CuentaAdministrador.administrador_Usuario = :usuario")
    fun getCuentaByAdministradorUsuario(usuario: String): LiveData<Cuenta>

    @Insert
    suspend fun addCuentasAdministrador(vararg cuentasAdministrador: CuentaAdministrador)

    @Update
    suspend fun updateCuentaAdministrador(vararg cuentaAdministrador: CuentaAdministrador)

    @Delete
    suspend fun deleteCuentaAdministrador(cuentaAdministrador: CuentaAdministrador)

//CuentaChofer
    @Query("SELECT * FROM CuentaChofer")
    fun getCuentasChofer(): LiveData<List<CuentaChofer>>

    @Query("SELECT * FROM CuentaChofer WHERE chofer_Usuario = :usuario")
    fun getCuentaChoferByUsuario(usuario: String): LiveData<CuentaChofer>

    @Query("SELECT correo, contrasenia, tipo FROM Cuenta INNER JOIN CuentaChofer WHERE CuentaChofer.chofer_Usuario = :usuario")
    fun getCuentaByChoferUsuario(usuario: String): LiveData<Cuenta>

    @Insert
    suspend fun addCuentasChofer(vararg cuentasChofer: CuentaChofer)

    @Update
    suspend fun updateCuentaChofer(vararg cuentaChofer: CuentaChofer)

    @Delete
    suspend fun deleteCuentaChofer(cuentaChofer: CuentaChofer)

//CuentaPublico
    @Query("SELECT * FROM CuentaPublico")
    fun getCuentasPublico(): LiveData<List<CuentaPublico>>

    @Query("SELECT * FROM CuentaPublico WHERE publico_General_Usuario = :usuario")
    fun getCuentaPublicoByUsuario(usuario: String): LiveData<CuentaPublico>

    @Query("SELECT correo, contrasenia, tipo FROM Cuenta INNER JOIN CuentaPublico WHERE CuentaPublico.publico_General_Usuario = :usuario")
    fun getCuentaByPublicoUsuario(usuario: String): LiveData<Cuenta>

    @Insert
    suspend fun addCuentasPublico(vararg cuentasPublico: CuentaPublico)

    @Update
    suspend fun updateCuentaPublico(vararg cuentaPublico: CuentaPublico)

    @Delete
    suspend fun deleteCuentaPublico(cuentaPublico: CuentaPublico)

//CalleCoordenada
    @Query("SELECT * FROM CalleCoordenada")
    fun getCallesCoordenadas(): LiveData<List<CalleCoordenada>>

    @Insert
    suspend fun addCallesCoordenada(vararg calleCoordenadas: CalleCoordenada)

    @Update
    suspend fun updateCalleCoordenada(vararg calleCoordenada: CalleCoordenada)

    @Delete
    suspend fun deleteCalleCoordenada(calleCoordenada: CalleCoordenada)

//RutaCalle
    @Query("SELECT * FROM RutaCalle")
    fun getRutaCalles(): LiveData<List<RutaCalle>>

    @Insert
    suspend fun addRutaCalles(vararg rutaCalles: RutaCalle)

    @Update
    suspend fun updateRutaCalle(vararg rutaCalle: RutaCalle)

    @Delete
    suspend fun deleteRutaCalle(rutaCalle: RutaCalle)

//UnidadCoordenada
    @Query("SELECT * FROM UnidadCoordenada")
    fun getUnidadesCoordenadas(): LiveData<List<UnidadCoordenada>>

    @Insert
    suspend fun addUnidadCoordenadas(vararg unidadesCoordenadas: UnidadCoordenada)

    @Update
    suspend fun updateUnidadCoordenada(vararg unidadCoordenada: UnidadCoordenada)

    @Delete
    suspend fun deleteUnidadCoordenada(unidadCoordenada: UnidadCoordenada)

//HorarioCUR
    @Query("SELECT * FROM HorarioChoferUnidadRuta")
    fun getHorarioCURs(): LiveData<List<HorarioCUR>>

    @Insert
    suspend fun addHorariosCUR(vararg horarioCURs: HorarioCUR)

    @Update
    suspend fun updateHorarioCUR(vararg horarioCUR: HorarioCUR)

    @Delete
    suspend fun deleteHorarioCUR(horarioCUR: HorarioCUR)
}