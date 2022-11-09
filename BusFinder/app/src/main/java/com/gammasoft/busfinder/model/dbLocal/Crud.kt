package com.gammasoft.busfinder.model.dbLocal

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.busfinder.model.dbLocal.entidades.*
import com.example.busfinder.model.dbLocal.relaciones.*

@Dao
interface Crud{
//Cuenta
    @Query("SELECT * FROM Cuenta")
    fun getCuentas(): LiveData<List<Cuenta>>

    @Query("SELECT * FROM Cuenta WHERE correo = :correo")
    fun getCuentaByCorreo(correo: String): LiveData<Cuenta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCuentas(vararg cuentas: Cuenta)

    @Update
    fun updateCuenta(vararg cuenta: Cuenta)

    @Delete
    fun deleteCuenta(cuenta: Cuenta)

//Administrador
    @Query("SELECT * FROM Administrador")
    fun getAdministradores(): LiveData<List<Administrador>>

    @Query("SELECT * FROM Administrador WHERE usuario = :usuario")
    fun getAdministradorByUsuario(usuario: String): LiveData<Administrador>

    @Query("SELECT * FROM Administrador WHERE rfc = :rfc")
    fun getAdministradorByRFC(rfc: String): LiveData<Administrador>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAdministradores(vararg administradores: Administrador)

    @Update
    fun updateAdministrador(vararg administrador: Administrador)

    @Delete
    fun deleteAdministrador(administrador: Administrador)

//Chofer
    @Query("SELECT * FROM Chofer")
    fun getChoferes(): LiveData<List<Chofer>>

    @Query("SELECT * FROM Chofer WHERE usuario = :usuario")
    fun getChoferByUsuario(usuario: String): LiveData<Chofer>

    @Query("SELECT * FROM Chofer WHERE rfc = :rfc")
    fun getChoferByRFC(rfc: String): LiveData<Chofer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addChoferes(vararg choferes: Chofer)

    @Update
    fun updateChofer(vararg chofer: Chofer)

    @Delete
    fun deleteChofer(chofer: Chofer)

//PublicoGeneral
    @Query("SELECT * FROM PublicoGeneral")
    fun getPublicosGenerales(): LiveData<List<PublicoGeneral>>

    @Query("SELECT * FROM PublicoGeneral WHERE usuario = :usuario")
    fun getPublicoGeneralByUsuario(usuario: String): LiveData<PublicoGeneral>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPublicoGeneral(vararg publicoGeneral: PublicoGeneral)

    @Update
    fun updatePublicoGeneral(vararg publicoGeneral: PublicoGeneral)

    @Delete
    fun deletePublicoGeneral(publicoGeneral: PublicoGeneral)

//Ruta
    @Query("SELECT * FROM Ruta")
    fun getRutas(): LiveData<List<Ruta>>

    @Query("SELECT * FROM Ruta WHERE id = :id")
    fun getRutaById(id: Int): LiveData<Ruta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRutas(vararg rutas: Ruta)

    @Update
    fun updateRuta(vararg ruta: Ruta)

    @Delete
    fun deleteRuta(ruta: Ruta)

//Calle
    @Query("SELECT * FROM Calle")
    fun getCalles(): LiveData<List<Calle>>

    @Query("SELECT * FROM Calle WHERE id = :id")
    fun getCalleById(id: Int): LiveData<Calle>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCalles(vararg calles: Calle)

    @Update
    fun updateCalle(vararg calle: Calle)

    @Delete
    fun deleteCalle(calle: Calle)

//Parada
    @Query("SELECT * FROM Parada")
    fun getParadas(): LiveData<List<Parada>>

    @Query("SELECT * FROM Parada WHERE id = :id")
    fun getParadaById(id: Int): LiveData<Parada>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addParadas(vararg paradas: Parada)

    @Update
    fun updateParada(vararg parada: Parada)

    @Delete
    fun deleteParada(parada: Parada)

//Unidad
    @Query("SELECT * FROM Unidad")
    fun getUnidades(): LiveData<List<Unidad>>

    @Query("SELECT * FROM Unidad WHERE placa = :placa")
    fun getUnidadByPlaca(placa: String): LiveData<Unidad>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUnidades(vararg unidades: Unidad)

    @Update
    fun updateUnidad(vararg unidad: Unidad)

    @Delete
    fun deleteUnidad(unidad: Unidad)

//Tarifa
    @Query("SELECT * FROM Tarifa")
    fun getTarifas(): LiveData<List<Tarifa>>

    @Query("SELECT * FROM Tarifa WHERE nombre = :nombre")
    fun getTarifaByNombre(nombre: String): LiveData<Tarifa>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTarifas(vararg tarifas: Tarifa)

    @Update
    fun updateTarifa(vararg tarifa: Tarifa)

    @Delete
    fun deleteTarifa(tarifa: Tarifa)

//Horario
    @Query("SELECT * FROM Horario")
    fun getHorarios(): LiveData<List<Horario>>

    @Query("SELECT * FROM Horario WHERE id = :id")
    fun getHorarioById(id: Int): LiveData<Horario>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHorarios(vararg horarios: Horario)

    @Update
    fun updateHorario(vararg horario: Horario)

    @Delete
    fun deleteHorario(horario: Horario)

//Coordenada
    @Query("SELECT * FROM Coordenada")
    fun getCoordenadas(): LiveData<List<Coordenada>>

    @Query("SELECT * FROM Coordenada WHERE id = :id")
    fun getCoordenadaById(id: Int): LiveData<Coordenada>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoordenada(vararg coordenadas: Coordenada)

    @Update
    fun updateCoordenada(vararg coordenada: Coordenada)

    @Delete
    fun deleteCoordenada(coordenada: Coordenada)

//CuentaAdministrador
    @Query("SELECT * FROM CuentaAdministrador")
    fun getCuentasAdministrador(): LiveData<List<CuentaAdministrador>>

    @Query("SELECT * FROM CuentaAdministrador WHERE administrador_Usuario = :usuario")
    fun getCuentaAdministradorByUsuario(usuario: String): LiveData<CuentaAdministrador>

    @Query("SELECT correo, contrasenia, foto, tipo, estado FROM Cuenta INNER JOIN CuentaAdministrador " +
            "WHERE administrador_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    fun getCuentaByAdministradorUsuarioOCuentaCorreo(usuarioOCorreo: String): LiveData<Cuenta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCuentasAdministrador(vararg cuentasAdministrador: CuentaAdministrador)

    @Update
    fun updateCuentaAdministrador(vararg cuentaAdministrador: CuentaAdministrador)

    @Delete
    fun deleteCuentaAdministrador(cuentaAdministrador: CuentaAdministrador)

//CuentaChofer
    @Query("SELECT * FROM CuentaChofer")
    fun getCuentasChofer(): LiveData<List<CuentaChofer>>

    @Query("SELECT * FROM CuentaChofer WHERE chofer_Usuario = :usuario")
    fun getCuentaChoferByUsuario(usuario: String): LiveData<CuentaChofer>

    @Query("SELECT correo, contrasenia, foto, tipo, estado FROM Cuenta INNER JOIN CuentaChofer " +
            "WHERE chofer_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    fun getCuentaByChoferUsuarioOCuentaCorreo(usuarioOCorreo: String): LiveData<Cuenta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCuentasChofer(vararg cuentasChofer: CuentaChofer)

    @Update
    fun updateCuentaChofer(vararg cuentaChofer: CuentaChofer)

    @Delete
    fun deleteCuentaChofer(cuentaChofer: CuentaChofer)

//CuentaPublico
    @Query("SELECT * FROM CuentaPublico")
    fun getCuentasPublico(): LiveData<List<CuentaPublico>>

    @Query("SELECT * FROM CuentaPublico WHERE publico_General_Usuario = :usuario")
    fun getCuentaPublicoByUsuario(usuario: String): LiveData<CuentaPublico>

    @Query("SELECT correo, contrasenia, foto, tipo, estado FROM Cuenta INNER JOIN CuentaPublico " +
            "WHERE publico_General_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    fun getCuentaByPublicoUsuarioOCuentaCorreo(usuarioOCorreo: String): LiveData<Cuenta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCuentasPublico(vararg cuentasPublico: CuentaPublico)

    @Update
    fun updateCuentaPublico(vararg cuentaPublico: CuentaPublico)

    @Delete
    fun deleteCuentaPublico(cuentaPublico: CuentaPublico)

//CalleCoordenada
    @Query("SELECT * FROM CalleCoordenada")
    fun getCallesCoordenadas(): LiveData<List<CalleCoordenada>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCallesCoordenada(vararg calleCoordenadas: CalleCoordenada)

    @Update
    fun updateCalleCoordenada(vararg calleCoordenada: CalleCoordenada)

    @Delete
    fun deleteCalleCoordenada(calleCoordenada: CalleCoordenada)

//RutaCalle
    @Query("SELECT * FROM RutaCalle")
    fun getRutaCalles(): LiveData<List<RutaCalle>>

    @Query("SELECT * FROM RutaCalle WHERE ruta_ID = :rutaID")
    fun getCallesIDByRutaID(rutaID: Int): LiveData<List<RutaCalle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRutaCalles(vararg rutaCalles: RutaCalle)

    @Update
    fun updateRutaCalle(vararg rutaCalle: RutaCalle)

    @Delete
    fun deleteRutaCalle(rutaCalle: RutaCalle)

//RutaParada
    @Query("SELECT * FROM RutaParada")
    fun getRutaParadas(): LiveData<List<RutaParada>>

    @Query("SELECT * FROM RutaParada WHERE parada_ID = :paradaID")
    fun getRutaIDByParadaID(paradaID: Int): LiveData<RutaParada>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRutaParadas(vararg rutaParadas: RutaParada)

    @Update
    fun updateRutaParada(vararg rutaParada: RutaParada)

    @Delete
    fun deleteRutaParada(rutaParada: RutaParada)

//ParadaCoordenada
    @Query("SELECT * FROM ParadaCoordenada")
    fun getParadaCoordenadas(): LiveData<List<ParadaCoordenada>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addParadaCoordenadas(vararg paradaCoordenadas: ParadaCoordenada)

    @Update
    fun updateParadaCoordenada(vararg paradaCoordenada: ParadaCoordenada)

    @Delete
    fun deleteParadaCoordenada(paradaCoordenada: ParadaCoordenada)

//UnidadCoordenada
    @Query("SELECT * FROM UnidadCoordenada")
    fun getUnidadesCoordenadas(): LiveData<List<UnidadCoordenada>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUnidadCoordenadas(vararg unidadesCoordenadas: UnidadCoordenada)

    @Update
    fun updateUnidadCoordenada(vararg unidadCoordenada: UnidadCoordenada)

    @Delete
    fun deleteUnidadCoordenada(unidadCoordenada: UnidadCoordenada)

//HorarioCUR
    @Query("SELECT * FROM HorarioChoferUnidadRuta")
    fun getHorarioCURs(): LiveData<List<HorarioCUR>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHorariosCUR(vararg horarioCURs: HorarioCUR)

    @Update
    fun updateHorarioCUR(vararg horarioCUR: HorarioCUR)

    @Delete
    fun deleteHorarioCUR(horarioCUR: HorarioCUR)
}