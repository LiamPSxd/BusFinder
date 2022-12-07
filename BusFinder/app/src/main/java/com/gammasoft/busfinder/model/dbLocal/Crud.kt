package com.gammasoft.busfinder.model.dbLocal

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gammasoft.busfinder.model.dbLocal.entidades.*
import com.gammasoft.busfinder.model.dbLocal.relaciones.*

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

    @Query("DELETE FROM Cuenta")
    fun deleteCuentas()

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

    @Query("DELETE FROM Administrador WHERE rfc = :rfc")
    fun deleteAdministradoresByRFC(rfc: String)

    @Query("DELETE FROM Administrador")
    fun deleteAdministradores()

//Chofer
    @Query("SELECT * FROM Chofer")
    fun getChoferes(): LiveData<List<Chofer>>

    @Query("SELECT * FROM Chofer WHERE usuario = :usuario")
    fun getChoferByUsuario(usuario: String): LiveData<Chofer>

    @Query("SELECT * FROM Chofer WHERE rfc = :rfc")
    fun getChoferByRFC(rfc: String): LiveData<Chofer>

    @Query("SELECT * FROM Chofer WHERE nombre = :nombre")
    fun getChoferByNombre(nombre: String): LiveData<Chofer>

    @Query("SELECT * FROM Chofer WHERE administrador = :administrador")
    fun getChoferesByAdministrador(administrador: String): LiveData<List<Chofer>>

    @Query("SELECT * FROM Chofer WHERE rfc = :rfc AND administrador = :administrador")
    fun getChoferByRFCYAdministrador(rfc: String, administrador: String): LiveData<Chofer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addChoferes(vararg choferes: Chofer)

    @Update
    fun updateChofer(vararg chofer: Chofer)

    @Delete
    fun deleteChofer(chofer: Chofer)

    @Query("DELETE FROM Chofer")
    fun deleteChoferes()

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

    @Query("DELETE FROM PublicoGeneral")
    fun deletePublicosGenerales()

//Ruta
    @Query("SELECT * FROM Ruta")
    fun getRutas(): LiveData<List<Ruta>>

    @Query("SELECT * FROM Ruta WHERE id = :id")
    fun getRutaById(id: Int): LiveData<Ruta>

    @Query("SELECT * FROM Ruta WHERE nombre = :nombre")
    fun getRutaByNombre(nombre: String): LiveData<Ruta>

    @Query("SELECT * FROM Ruta WHERE administrador = :administrador")
    fun getRutasByAdministrador(administrador: String): LiveData<List<Ruta>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRutas(vararg rutas: Ruta)

    @Update
    fun updateRuta(vararg ruta: Ruta)

    @Delete
    fun deleteRuta(ruta: Ruta)

    @Query("DELETE FROM Ruta")
    fun deleteRutas()

//Parada
    @Query("SELECT * FROM Parada")
    fun getParadas(): LiveData<List<Parada>>

    @Query("SELECT * FROM Parada WHERE id = :id")
    fun getParadaById(id: Int): LiveData<Parada>

    @Query("SELECT * FROM Parada WHERE nombre = :nombre")
    fun getParadaByNombre(nombre: String): LiveData<Parada>

    @Query("SELECT * FROM Parada WHERE administrador = :administrador")
    fun getParadasByAdministrador(administrador: String): LiveData<List<Parada>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addParadas(vararg paradas: Parada)

    @Update
    fun updateParada(vararg parada: Parada)

    @Delete
    fun deleteParada(parada: Parada)

    @Query("DELETE FROM Parada")
    fun deleteParadas()

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

    @Query("DELETE FROM Unidad")
    fun deleteUnidades()

//Tarifa
    @Query("SELECT * FROM Tarifa")
    fun getTarifas(): LiveData<List<Tarifa>>

    @Query("SELECT * FROM Tarifa WHERE nombre = :nombre")
    fun getTarifaByNombre(nombre: String): LiveData<Tarifa>

    @Query("SELECT * FROM Tarifa WHERE administrador = :administrador")
    fun getTarifasByAdministrador(administrador: String): LiveData<List<Tarifa>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTarifas(vararg tarifas: Tarifa)

    @Update
    fun updateTarifa(vararg tarifa: Tarifa)

    @Delete
    fun deleteTarifa(tarifa: Tarifa)

    @Query("DELETE FROM Tarifa")
    fun deleteTarifas()

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

    @Query("DELETE FROM Horario")
    fun deleteHorarios()

//Coordenada
    @Query("SELECT * FROM Coordenada")
    fun getCoordenadas(): LiveData<List<Coordenada>>

    @Query("SELECT * FROM Coordenada WHERE id = :id")
    fun getCoordenadaById(id: Int): LiveData<Coordenada>

    @Query("SELECT * FROM Coordenada WHERE administrador = :administrador")
    fun getCoordenadasByAdministrador(administrador: String): LiveData<List<Coordenada>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoordenadas(vararg coordenadas: Coordenada)

    @Update
    fun updateCoordenada(vararg coordenada: Coordenada)

    @Delete
    fun deleteCoordenada(coordenada: Coordenada)

    @Query("DELETE FROM Coordenada WHERE id = :id")
    fun deleteCoordenadaById(id: Int)

    @Query("DELETE FROM Coordenada")
    fun deleteCoordenadas()

//SugerenciaQueja
    @Query("SELECT * FROM SugerenciaQueja")
    fun getSugerenciasQuejas(): LiveData<List<QuejaSugerencia>>

    @Query("SELECT * FROM SugerenciaQueja WHERE id = :id")
    fun getSugerenciasQuejasById(id: Int): LiveData<QuejaSugerencia>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSugerenciaQueja(vararg quejaSugerencia: QuejaSugerencia)

    @Update
    fun updateSugerenciaQueja(vararg quejaSugerencia: QuejaSugerencia)

    @Delete
    fun deleteSugerenciaQueja(quejaSugerencia: QuejaSugerencia)

    @Query("DELETE FROM SugerenciaQueja WHERE id = :id")
    fun deleteSugerenciaQueja(id: Int)

    @Query("DELETE FROM SugerenciaQueja")
    fun deleteSugerenciasQuejas()

//CuentaAdministrador
    @Query("SELECT * FROM CuentaAdministrador")
    fun getCuentasAdministrador(): LiveData<List<CuentaAdministrador>>

    @Query("SELECT * FROM CuentaAdministrador WHERE administrador_Usuario = :usuario")
    fun getCuentaAdministradorByUsuario(usuario: String): LiveData<CuentaAdministrador>

    @Query("SELECT * FROM CuentaAdministrador WHERE cuenta_Correo = :correo")
    fun getCuentaAdministradorByCorreo(correo: String): LiveData<CuentaAdministrador>

    @Query("SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaAdministrador " +
            "WHERE administrador_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    fun getCuentaByAdministradorUsuarioOCuentaCorreo(usuarioOCorreo: String): LiveData<Cuenta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCuentasAdministrador(vararg cuentasAdministrador: CuentaAdministrador)

    @Update
    fun updateCuentaAdministrador(vararg cuentaAdministrador: CuentaAdministrador)

    @Delete
    fun deleteCuentaAdministrador(cuentaAdministrador: CuentaAdministrador)

    @Query("DELETE FROM CuentaAdministrador")
    fun deleteCuentasAdministrador()

//CuentaChofer
    @Query("SELECT * FROM CuentaChofer")
    fun getCuentasChofer(): LiveData<List<CuentaChofer>>

    @Query("SELECT * FROM CuentaChofer WHERE chofer_Usuario = :usuario")
    fun getCuentaChoferByUsuario(usuario: String): LiveData<CuentaChofer>

    @Query("SELECT * FROM CuentaChofer WHERE cuenta_Correo = :correo")
    fun getCuentaChoferByCorreo(correo: String): LiveData<CuentaChofer>

    @Query("SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaChofer " +
            "WHERE chofer_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    fun getCuentaByChoferUsuarioOCuentaCorreo(usuarioOCorreo: String): LiveData<Cuenta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCuentasChofer(vararg cuentasChofer: CuentaChofer)

    @Update
    fun updateCuentaChofer(vararg cuentaChofer: CuentaChofer)

    @Delete
    fun deleteCuentaChofer(cuentaChofer: CuentaChofer)

    @Query("DELETE FROM CuentaChofer")
    fun deleteCuentasChofer()

//CuentaPublico
    @Query("SELECT * FROM CuentaPublico")
    fun getCuentasPublico(): LiveData<List<CuentaPublico>>

    @Query("SELECT * FROM CuentaPublico WHERE publico_General_Usuario = :usuario")
    fun getCuentaPublicoByUsuario(usuario: String): LiveData<CuentaPublico>

    @Query("SELECT * FROM CuentaPublico WHERE cuenta_Correo = :correo")
    fun getCuentaPublicoByCorreo(correo: String): LiveData<CuentaPublico>

    @Query("SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaPublico " +
            "WHERE publico_General_Usuario = :usuarioOCorreo OR cuenta_Correo = :usuarioOCorreo")
    fun getCuentaByPublicoUsuarioOCuentaCorreo(usuarioOCorreo: String): LiveData<Cuenta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCuentasPublico(vararg cuentasPublico: CuentaPublico)

    @Update
    fun updateCuentaPublico(vararg cuentaPublico: CuentaPublico)

    @Delete
    fun deleteCuentaPublico(cuentaPublico: CuentaPublico)

    @Query("DELETE FROM CuentaPublico")
    fun deleteCuentasPublico()

//RutaCoordenada
    @Query("SELECT * FROM RutaCoordenada")
    fun getRutaCoordenadas(): LiveData<List<RutaCoordenada>>

    @Query("SELECT * FROM RutaCoordenada WHERE ruta_ID = :rutaID")
    fun getCoordenadasIDByRutaID(rutaID: Int): LiveData<List<RutaCoordenada>>

    @Query("SELECT * FROM RutaCoordenada WHERE ruta_ID = :rutaID")
    fun getRutaCoordenadaByRutaID(rutaID: Int): LiveData<RutaCoordenada>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRutaCoordenadas(vararg rutaCoordenadas: RutaCoordenada)

    @Update
    fun updateRutaCoordenada(vararg rutaCoordenada: RutaCoordenada)

    @Delete
    fun deleteRutaCoordenada(rutaCoordenada: RutaCoordenada)

    @Query("DELETE FROM RutaCoordenada")
    fun deleteRutasCoordenadas()

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

    @Query("DELETE FROM RutaParada")
    fun deleteRutasParadas()

//UnidadCoordenada
    @Query("SELECT * FROM UnidadCoordenada")
    fun getUnidadesCoordenadas(): LiveData<List<UnidadCoordenada>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUnidadCoordenadas(vararg unidadesCoordenadas: UnidadCoordenada)

    @Update
    fun updateUnidadCoordenada(vararg unidadCoordenada: UnidadCoordenada)

    @Delete
    fun deleteUnidadCoordenada(unidadCoordenada: UnidadCoordenada)

    @Query("DELETE FROM UnidadCoordenada")
    fun deleteUnidadesCoordenadas()

//HorarioCUR
    @Query("SELECT * FROM HorarioChoferUnidadRuta")
    fun getHorarioCURs(): LiveData<List<HorarioCUR>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addHorariosCUR(vararg horarioCURs: HorarioCUR)

    @Update
    fun updateHorarioCUR(vararg horarioCUR: HorarioCUR)

    @Delete
    fun deleteHorarioCUR(horarioCUR: HorarioCUR)

    @Query("DELETE FROM HorarioChoferUnidadRuta")
    fun deleteHorariosCUR()
}