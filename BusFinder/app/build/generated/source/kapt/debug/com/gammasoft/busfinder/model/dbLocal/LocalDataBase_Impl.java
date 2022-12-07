package com.gammasoft.busfinder.model.dbLocal;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LocalDataBase_Impl extends LocalDataBase {
  private volatile Crud _crud;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Cuenta` (`correo` TEXT NOT NULL, `contrasenia` TEXT NOT NULL, `foto` TEXT NOT NULL, `tipo` INTEGER NOT NULL, `metodo` TEXT NOT NULL, `estado` INTEGER NOT NULL, PRIMARY KEY(`correo`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Administrador` (`usuario` TEXT NOT NULL, `rfc` TEXT NOT NULL, `nombre` TEXT NOT NULL, `numero_Celular` INTEGER NOT NULL, `linea_Transporte` TEXT NOT NULL, `codigo` INTEGER NOT NULL, PRIMARY KEY(`usuario`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Chofer` (`usuario` TEXT NOT NULL, `rfc` TEXT NOT NULL, `nombre` TEXT NOT NULL, `numero_Celular` INTEGER NOT NULL, `linea_Transporte` TEXT NOT NULL, `codigo` INTEGER NOT NULL, `noUsuarios` INTEGER NOT NULL, `calificacion` REAL NOT NULL, `administrador` TEXT NOT NULL, PRIMARY KEY(`usuario`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PublicoGeneral` (`usuario` TEXT NOT NULL, PRIMARY KEY(`usuario`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Ruta` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `administrador` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Parada` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT NOT NULL, `longitud` REAL NOT NULL, `latitud` REAL NOT NULL, `administrador` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Coordenada` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `longitud` REAL NOT NULL, `latitud` REAL NOT NULL, `administrador` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Unidad` (`placa` TEXT NOT NULL, `marca` TEXT NOT NULL, `modelo` TEXT NOT NULL, `numero` INTEGER NOT NULL, `hora` TEXT NOT NULL, `fecha` TEXT NOT NULL, PRIMARY KEY(`placa`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Tarifa` (`nombre` TEXT NOT NULL, `precio` REAL NOT NULL, `administrador` TEXT NOT NULL, PRIMARY KEY(`nombre`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Horario` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `hora_Entrada` TEXT NOT NULL, `hora_Salida` TEXT NOT NULL, `fecha` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SugerenciaQueja` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `descripcion` TEXT NOT NULL, `usuario` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CuentaAdministrador` (`cuenta_Correo` TEXT NOT NULL, `administrador_Usuario` TEXT NOT NULL, PRIMARY KEY(`cuenta_Correo`, `administrador_Usuario`), FOREIGN KEY(`cuenta_Correo`) REFERENCES `Cuenta`(`correo`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`administrador_Usuario`) REFERENCES `Administrador`(`usuario`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_CuentaAdministrador_cuenta_Correo` ON `CuentaAdministrador` (`cuenta_Correo`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_CuentaAdministrador_administrador_Usuario` ON `CuentaAdministrador` (`administrador_Usuario`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CuentaChofer` (`cuenta_Correo` TEXT NOT NULL, `chofer_Usuario` TEXT NOT NULL, PRIMARY KEY(`cuenta_Correo`, `chofer_Usuario`), FOREIGN KEY(`cuenta_Correo`) REFERENCES `Cuenta`(`correo`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`chofer_Usuario`) REFERENCES `Chofer`(`usuario`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_CuentaChofer_cuenta_Correo` ON `CuentaChofer` (`cuenta_Correo`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_CuentaChofer_chofer_Usuario` ON `CuentaChofer` (`chofer_Usuario`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CuentaPublico` (`cuenta_Correo` TEXT NOT NULL, `publico_General_Usuario` TEXT NOT NULL, PRIMARY KEY(`cuenta_Correo`, `publico_General_Usuario`), FOREIGN KEY(`cuenta_Correo`) REFERENCES `Cuenta`(`correo`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`publico_General_Usuario`) REFERENCES `PublicoGeneral`(`usuario`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_CuentaPublico_cuenta_Correo` ON `CuentaPublico` (`cuenta_Correo`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_CuentaPublico_publico_General_Usuario` ON `CuentaPublico` (`publico_General_Usuario`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `RutaCoordenada` (`ruta_ID` INTEGER NOT NULL, `coordenada_ID` INTEGER NOT NULL, PRIMARY KEY(`ruta_ID`, `coordenada_ID`), FOREIGN KEY(`ruta_ID`) REFERENCES `Ruta`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`coordenada_ID`) REFERENCES `Coordenada`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_RutaCoordenada_ruta_ID` ON `RutaCoordenada` (`ruta_ID`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_RutaCoordenada_coordenada_ID` ON `RutaCoordenada` (`coordenada_ID`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `RutaParada` (`ruta_ID` INTEGER NOT NULL, `parada_ID` INTEGER NOT NULL, PRIMARY KEY(`ruta_ID`, `parada_ID`), FOREIGN KEY(`ruta_ID`) REFERENCES `Ruta`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`parada_ID`) REFERENCES `Parada`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_RutaParada_ruta_ID` ON `RutaParada` (`ruta_ID`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_RutaParada_parada_ID` ON `RutaParada` (`parada_ID`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UnidadCoordenada` (`unidad_Placa` TEXT NOT NULL, `coordenada_ID` INTEGER NOT NULL, PRIMARY KEY(`unidad_Placa`, `coordenada_ID`), FOREIGN KEY(`unidad_Placa`) REFERENCES `Unidad`(`placa`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`coordenada_ID`) REFERENCES `Coordenada`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_UnidadCoordenada_unidad_Placa` ON `UnidadCoordenada` (`unidad_Placa`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_UnidadCoordenada_coordenada_ID` ON `UnidadCoordenada` (`coordenada_ID`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `HorarioChoferUnidadRuta` (`horario_ID` INTEGER NOT NULL, `chofer_Usuario` TEXT NOT NULL, `unidad_Placa` TEXT NOT NULL, `ruta_Ida_ID` INTEGER NOT NULL, `ruta_Venida_ID` INTEGER NOT NULL, PRIMARY KEY(`horario_ID`, `chofer_Usuario`, `unidad_Placa`, `ruta_Ida_ID`, `ruta_Venida_ID`), FOREIGN KEY(`horario_ID`) REFERENCES `Horario`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`chofer_Usuario`) REFERENCES `Chofer`(`usuario`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`unidad_Placa`) REFERENCES `Unidad`(`placa`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`ruta_Ida_ID`) REFERENCES `Ruta`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`ruta_Venida_ID`) REFERENCES `Ruta`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_HorarioChoferUnidadRuta_horario_ID` ON `HorarioChoferUnidadRuta` (`horario_ID`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_HorarioChoferUnidadRuta_chofer_Usuario` ON `HorarioChoferUnidadRuta` (`chofer_Usuario`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_HorarioChoferUnidadRuta_unidad_Placa` ON `HorarioChoferUnidadRuta` (`unidad_Placa`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_HorarioChoferUnidadRuta_ruta_Ida_ID` ON `HorarioChoferUnidadRuta` (`ruta_Ida_ID`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_HorarioChoferUnidadRuta_ruta_Venida_ID` ON `HorarioChoferUnidadRuta` (`ruta_Venida_ID`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '92a3e2cfbe5adfd321979365891559ab')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Cuenta`");
        _db.execSQL("DROP TABLE IF EXISTS `Administrador`");
        _db.execSQL("DROP TABLE IF EXISTS `Chofer`");
        _db.execSQL("DROP TABLE IF EXISTS `PublicoGeneral`");
        _db.execSQL("DROP TABLE IF EXISTS `Ruta`");
        _db.execSQL("DROP TABLE IF EXISTS `Parada`");
        _db.execSQL("DROP TABLE IF EXISTS `Coordenada`");
        _db.execSQL("DROP TABLE IF EXISTS `Unidad`");
        _db.execSQL("DROP TABLE IF EXISTS `Tarifa`");
        _db.execSQL("DROP TABLE IF EXISTS `Horario`");
        _db.execSQL("DROP TABLE IF EXISTS `SugerenciaQueja`");
        _db.execSQL("DROP TABLE IF EXISTS `CuentaAdministrador`");
        _db.execSQL("DROP TABLE IF EXISTS `CuentaChofer`");
        _db.execSQL("DROP TABLE IF EXISTS `CuentaPublico`");
        _db.execSQL("DROP TABLE IF EXISTS `RutaCoordenada`");
        _db.execSQL("DROP TABLE IF EXISTS `RutaParada`");
        _db.execSQL("DROP TABLE IF EXISTS `UnidadCoordenada`");
        _db.execSQL("DROP TABLE IF EXISTS `HorarioChoferUnidadRuta`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCuenta = new HashMap<String, TableInfo.Column>(6);
        _columnsCuenta.put("correo", new TableInfo.Column("correo", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuenta.put("contrasenia", new TableInfo.Column("contrasenia", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuenta.put("foto", new TableInfo.Column("foto", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuenta.put("tipo", new TableInfo.Column("tipo", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuenta.put("metodo", new TableInfo.Column("metodo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuenta.put("estado", new TableInfo.Column("estado", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCuenta = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCuenta = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCuenta = new TableInfo("Cuenta", _columnsCuenta, _foreignKeysCuenta, _indicesCuenta);
        final TableInfo _existingCuenta = TableInfo.read(_db, "Cuenta");
        if (! _infoCuenta.equals(_existingCuenta)) {
          return new RoomOpenHelper.ValidationResult(false, "Cuenta(com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta).\n"
                  + " Expected:\n" + _infoCuenta + "\n"
                  + " Found:\n" + _existingCuenta);
        }
        final HashMap<String, TableInfo.Column> _columnsAdministrador = new HashMap<String, TableInfo.Column>(6);
        _columnsAdministrador.put("usuario", new TableInfo.Column("usuario", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdministrador.put("rfc", new TableInfo.Column("rfc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdministrador.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdministrador.put("numero_Celular", new TableInfo.Column("numero_Celular", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdministrador.put("linea_Transporte", new TableInfo.Column("linea_Transporte", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAdministrador.put("codigo", new TableInfo.Column("codigo", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAdministrador = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAdministrador = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAdministrador = new TableInfo("Administrador", _columnsAdministrador, _foreignKeysAdministrador, _indicesAdministrador);
        final TableInfo _existingAdministrador = TableInfo.read(_db, "Administrador");
        if (! _infoAdministrador.equals(_existingAdministrador)) {
          return new RoomOpenHelper.ValidationResult(false, "Administrador(com.gammasoft.busfinder.model.dbLocal.entidades.Administrador).\n"
                  + " Expected:\n" + _infoAdministrador + "\n"
                  + " Found:\n" + _existingAdministrador);
        }
        final HashMap<String, TableInfo.Column> _columnsChofer = new HashMap<String, TableInfo.Column>(9);
        _columnsChofer.put("usuario", new TableInfo.Column("usuario", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChofer.put("rfc", new TableInfo.Column("rfc", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChofer.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChofer.put("numero_Celular", new TableInfo.Column("numero_Celular", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChofer.put("linea_Transporte", new TableInfo.Column("linea_Transporte", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChofer.put("codigo", new TableInfo.Column("codigo", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChofer.put("noUsuarios", new TableInfo.Column("noUsuarios", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChofer.put("calificacion", new TableInfo.Column("calificacion", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChofer.put("administrador", new TableInfo.Column("administrador", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChofer = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesChofer = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoChofer = new TableInfo("Chofer", _columnsChofer, _foreignKeysChofer, _indicesChofer);
        final TableInfo _existingChofer = TableInfo.read(_db, "Chofer");
        if (! _infoChofer.equals(_existingChofer)) {
          return new RoomOpenHelper.ValidationResult(false, "Chofer(com.gammasoft.busfinder.model.dbLocal.entidades.Chofer).\n"
                  + " Expected:\n" + _infoChofer + "\n"
                  + " Found:\n" + _existingChofer);
        }
        final HashMap<String, TableInfo.Column> _columnsPublicoGeneral = new HashMap<String, TableInfo.Column>(1);
        _columnsPublicoGeneral.put("usuario", new TableInfo.Column("usuario", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPublicoGeneral = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPublicoGeneral = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPublicoGeneral = new TableInfo("PublicoGeneral", _columnsPublicoGeneral, _foreignKeysPublicoGeneral, _indicesPublicoGeneral);
        final TableInfo _existingPublicoGeneral = TableInfo.read(_db, "PublicoGeneral");
        if (! _infoPublicoGeneral.equals(_existingPublicoGeneral)) {
          return new RoomOpenHelper.ValidationResult(false, "PublicoGeneral(com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral).\n"
                  + " Expected:\n" + _infoPublicoGeneral + "\n"
                  + " Found:\n" + _existingPublicoGeneral);
        }
        final HashMap<String, TableInfo.Column> _columnsRuta = new HashMap<String, TableInfo.Column>(3);
        _columnsRuta.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRuta.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRuta.put("administrador", new TableInfo.Column("administrador", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRuta = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRuta = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRuta = new TableInfo("Ruta", _columnsRuta, _foreignKeysRuta, _indicesRuta);
        final TableInfo _existingRuta = TableInfo.read(_db, "Ruta");
        if (! _infoRuta.equals(_existingRuta)) {
          return new RoomOpenHelper.ValidationResult(false, "Ruta(com.gammasoft.busfinder.model.dbLocal.entidades.Ruta).\n"
                  + " Expected:\n" + _infoRuta + "\n"
                  + " Found:\n" + _existingRuta);
        }
        final HashMap<String, TableInfo.Column> _columnsParada = new HashMap<String, TableInfo.Column>(5);
        _columnsParada.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsParada.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsParada.put("longitud", new TableInfo.Column("longitud", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsParada.put("latitud", new TableInfo.Column("latitud", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsParada.put("administrador", new TableInfo.Column("administrador", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysParada = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesParada = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoParada = new TableInfo("Parada", _columnsParada, _foreignKeysParada, _indicesParada);
        final TableInfo _existingParada = TableInfo.read(_db, "Parada");
        if (! _infoParada.equals(_existingParada)) {
          return new RoomOpenHelper.ValidationResult(false, "Parada(com.gammasoft.busfinder.model.dbLocal.entidades.Parada).\n"
                  + " Expected:\n" + _infoParada + "\n"
                  + " Found:\n" + _existingParada);
        }
        final HashMap<String, TableInfo.Column> _columnsCoordenada = new HashMap<String, TableInfo.Column>(4);
        _columnsCoordenada.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoordenada.put("longitud", new TableInfo.Column("longitud", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoordenada.put("latitud", new TableInfo.Column("latitud", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCoordenada.put("administrador", new TableInfo.Column("administrador", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCoordenada = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCoordenada = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCoordenada = new TableInfo("Coordenada", _columnsCoordenada, _foreignKeysCoordenada, _indicesCoordenada);
        final TableInfo _existingCoordenada = TableInfo.read(_db, "Coordenada");
        if (! _infoCoordenada.equals(_existingCoordenada)) {
          return new RoomOpenHelper.ValidationResult(false, "Coordenada(com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada).\n"
                  + " Expected:\n" + _infoCoordenada + "\n"
                  + " Found:\n" + _existingCoordenada);
        }
        final HashMap<String, TableInfo.Column> _columnsUnidad = new HashMap<String, TableInfo.Column>(6);
        _columnsUnidad.put("placa", new TableInfo.Column("placa", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnidad.put("marca", new TableInfo.Column("marca", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnidad.put("modelo", new TableInfo.Column("modelo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnidad.put("numero", new TableInfo.Column("numero", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnidad.put("hora", new TableInfo.Column("hora", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnidad.put("fecha", new TableInfo.Column("fecha", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUnidad = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUnidad = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUnidad = new TableInfo("Unidad", _columnsUnidad, _foreignKeysUnidad, _indicesUnidad);
        final TableInfo _existingUnidad = TableInfo.read(_db, "Unidad");
        if (! _infoUnidad.equals(_existingUnidad)) {
          return new RoomOpenHelper.ValidationResult(false, "Unidad(com.gammasoft.busfinder.model.dbLocal.entidades.Unidad).\n"
                  + " Expected:\n" + _infoUnidad + "\n"
                  + " Found:\n" + _existingUnidad);
        }
        final HashMap<String, TableInfo.Column> _columnsTarifa = new HashMap<String, TableInfo.Column>(3);
        _columnsTarifa.put("nombre", new TableInfo.Column("nombre", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTarifa.put("precio", new TableInfo.Column("precio", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTarifa.put("administrador", new TableInfo.Column("administrador", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTarifa = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTarifa = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTarifa = new TableInfo("Tarifa", _columnsTarifa, _foreignKeysTarifa, _indicesTarifa);
        final TableInfo _existingTarifa = TableInfo.read(_db, "Tarifa");
        if (! _infoTarifa.equals(_existingTarifa)) {
          return new RoomOpenHelper.ValidationResult(false, "Tarifa(com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa).\n"
                  + " Expected:\n" + _infoTarifa + "\n"
                  + " Found:\n" + _existingTarifa);
        }
        final HashMap<String, TableInfo.Column> _columnsHorario = new HashMap<String, TableInfo.Column>(4);
        _columnsHorario.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHorario.put("hora_Entrada", new TableInfo.Column("hora_Entrada", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHorario.put("hora_Salida", new TableInfo.Column("hora_Salida", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHorario.put("fecha", new TableInfo.Column("fecha", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHorario = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHorario = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHorario = new TableInfo("Horario", _columnsHorario, _foreignKeysHorario, _indicesHorario);
        final TableInfo _existingHorario = TableInfo.read(_db, "Horario");
        if (! _infoHorario.equals(_existingHorario)) {
          return new RoomOpenHelper.ValidationResult(false, "Horario(com.gammasoft.busfinder.model.dbLocal.entidades.Horario).\n"
                  + " Expected:\n" + _infoHorario + "\n"
                  + " Found:\n" + _existingHorario);
        }
        final HashMap<String, TableInfo.Column> _columnsSugerenciaQueja = new HashMap<String, TableInfo.Column>(3);
        _columnsSugerenciaQueja.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSugerenciaQueja.put("descripcion", new TableInfo.Column("descripcion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSugerenciaQueja.put("usuario", new TableInfo.Column("usuario", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSugerenciaQueja = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSugerenciaQueja = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSugerenciaQueja = new TableInfo("SugerenciaQueja", _columnsSugerenciaQueja, _foreignKeysSugerenciaQueja, _indicesSugerenciaQueja);
        final TableInfo _existingSugerenciaQueja = TableInfo.read(_db, "SugerenciaQueja");
        if (! _infoSugerenciaQueja.equals(_existingSugerenciaQueja)) {
          return new RoomOpenHelper.ValidationResult(false, "SugerenciaQueja(com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia).\n"
                  + " Expected:\n" + _infoSugerenciaQueja + "\n"
                  + " Found:\n" + _existingSugerenciaQueja);
        }
        final HashMap<String, TableInfo.Column> _columnsCuentaAdministrador = new HashMap<String, TableInfo.Column>(2);
        _columnsCuentaAdministrador.put("cuenta_Correo", new TableInfo.Column("cuenta_Correo", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuentaAdministrador.put("administrador_Usuario", new TableInfo.Column("administrador_Usuario", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCuentaAdministrador = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysCuentaAdministrador.add(new TableInfo.ForeignKey("Cuenta", "NO ACTION", "NO ACTION",Arrays.asList("cuenta_Correo"), Arrays.asList("correo")));
        _foreignKeysCuentaAdministrador.add(new TableInfo.ForeignKey("Administrador", "NO ACTION", "NO ACTION",Arrays.asList("administrador_Usuario"), Arrays.asList("usuario")));
        final HashSet<TableInfo.Index> _indicesCuentaAdministrador = new HashSet<TableInfo.Index>(2);
        _indicesCuentaAdministrador.add(new TableInfo.Index("index_CuentaAdministrador_cuenta_Correo", false, Arrays.asList("cuenta_Correo"), Arrays.asList("ASC")));
        _indicesCuentaAdministrador.add(new TableInfo.Index("index_CuentaAdministrador_administrador_Usuario", false, Arrays.asList("administrador_Usuario"), Arrays.asList("ASC")));
        final TableInfo _infoCuentaAdministrador = new TableInfo("CuentaAdministrador", _columnsCuentaAdministrador, _foreignKeysCuentaAdministrador, _indicesCuentaAdministrador);
        final TableInfo _existingCuentaAdministrador = TableInfo.read(_db, "CuentaAdministrador");
        if (! _infoCuentaAdministrador.equals(_existingCuentaAdministrador)) {
          return new RoomOpenHelper.ValidationResult(false, "CuentaAdministrador(com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador).\n"
                  + " Expected:\n" + _infoCuentaAdministrador + "\n"
                  + " Found:\n" + _existingCuentaAdministrador);
        }
        final HashMap<String, TableInfo.Column> _columnsCuentaChofer = new HashMap<String, TableInfo.Column>(2);
        _columnsCuentaChofer.put("cuenta_Correo", new TableInfo.Column("cuenta_Correo", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuentaChofer.put("chofer_Usuario", new TableInfo.Column("chofer_Usuario", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCuentaChofer = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysCuentaChofer.add(new TableInfo.ForeignKey("Cuenta", "NO ACTION", "NO ACTION",Arrays.asList("cuenta_Correo"), Arrays.asList("correo")));
        _foreignKeysCuentaChofer.add(new TableInfo.ForeignKey("Chofer", "NO ACTION", "NO ACTION",Arrays.asList("chofer_Usuario"), Arrays.asList("usuario")));
        final HashSet<TableInfo.Index> _indicesCuentaChofer = new HashSet<TableInfo.Index>(2);
        _indicesCuentaChofer.add(new TableInfo.Index("index_CuentaChofer_cuenta_Correo", false, Arrays.asList("cuenta_Correo"), Arrays.asList("ASC")));
        _indicesCuentaChofer.add(new TableInfo.Index("index_CuentaChofer_chofer_Usuario", false, Arrays.asList("chofer_Usuario"), Arrays.asList("ASC")));
        final TableInfo _infoCuentaChofer = new TableInfo("CuentaChofer", _columnsCuentaChofer, _foreignKeysCuentaChofer, _indicesCuentaChofer);
        final TableInfo _existingCuentaChofer = TableInfo.read(_db, "CuentaChofer");
        if (! _infoCuentaChofer.equals(_existingCuentaChofer)) {
          return new RoomOpenHelper.ValidationResult(false, "CuentaChofer(com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer).\n"
                  + " Expected:\n" + _infoCuentaChofer + "\n"
                  + " Found:\n" + _existingCuentaChofer);
        }
        final HashMap<String, TableInfo.Column> _columnsCuentaPublico = new HashMap<String, TableInfo.Column>(2);
        _columnsCuentaPublico.put("cuenta_Correo", new TableInfo.Column("cuenta_Correo", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuentaPublico.put("publico_General_Usuario", new TableInfo.Column("publico_General_Usuario", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCuentaPublico = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysCuentaPublico.add(new TableInfo.ForeignKey("Cuenta", "NO ACTION", "NO ACTION",Arrays.asList("cuenta_Correo"), Arrays.asList("correo")));
        _foreignKeysCuentaPublico.add(new TableInfo.ForeignKey("PublicoGeneral", "NO ACTION", "NO ACTION",Arrays.asList("publico_General_Usuario"), Arrays.asList("usuario")));
        final HashSet<TableInfo.Index> _indicesCuentaPublico = new HashSet<TableInfo.Index>(2);
        _indicesCuentaPublico.add(new TableInfo.Index("index_CuentaPublico_cuenta_Correo", false, Arrays.asList("cuenta_Correo"), Arrays.asList("ASC")));
        _indicesCuentaPublico.add(new TableInfo.Index("index_CuentaPublico_publico_General_Usuario", false, Arrays.asList("publico_General_Usuario"), Arrays.asList("ASC")));
        final TableInfo _infoCuentaPublico = new TableInfo("CuentaPublico", _columnsCuentaPublico, _foreignKeysCuentaPublico, _indicesCuentaPublico);
        final TableInfo _existingCuentaPublico = TableInfo.read(_db, "CuentaPublico");
        if (! _infoCuentaPublico.equals(_existingCuentaPublico)) {
          return new RoomOpenHelper.ValidationResult(false, "CuentaPublico(com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico).\n"
                  + " Expected:\n" + _infoCuentaPublico + "\n"
                  + " Found:\n" + _existingCuentaPublico);
        }
        final HashMap<String, TableInfo.Column> _columnsRutaCoordenada = new HashMap<String, TableInfo.Column>(2);
        _columnsRutaCoordenada.put("ruta_ID", new TableInfo.Column("ruta_ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRutaCoordenada.put("coordenada_ID", new TableInfo.Column("coordenada_ID", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRutaCoordenada = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysRutaCoordenada.add(new TableInfo.ForeignKey("Ruta", "NO ACTION", "NO ACTION",Arrays.asList("ruta_ID"), Arrays.asList("id")));
        _foreignKeysRutaCoordenada.add(new TableInfo.ForeignKey("Coordenada", "NO ACTION", "NO ACTION",Arrays.asList("coordenada_ID"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesRutaCoordenada = new HashSet<TableInfo.Index>(2);
        _indicesRutaCoordenada.add(new TableInfo.Index("index_RutaCoordenada_ruta_ID", false, Arrays.asList("ruta_ID"), Arrays.asList("ASC")));
        _indicesRutaCoordenada.add(new TableInfo.Index("index_RutaCoordenada_coordenada_ID", false, Arrays.asList("coordenada_ID"), Arrays.asList("ASC")));
        final TableInfo _infoRutaCoordenada = new TableInfo("RutaCoordenada", _columnsRutaCoordenada, _foreignKeysRutaCoordenada, _indicesRutaCoordenada);
        final TableInfo _existingRutaCoordenada = TableInfo.read(_db, "RutaCoordenada");
        if (! _infoRutaCoordenada.equals(_existingRutaCoordenada)) {
          return new RoomOpenHelper.ValidationResult(false, "RutaCoordenada(com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada).\n"
                  + " Expected:\n" + _infoRutaCoordenada + "\n"
                  + " Found:\n" + _existingRutaCoordenada);
        }
        final HashMap<String, TableInfo.Column> _columnsRutaParada = new HashMap<String, TableInfo.Column>(2);
        _columnsRutaParada.put("ruta_ID", new TableInfo.Column("ruta_ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRutaParada.put("parada_ID", new TableInfo.Column("parada_ID", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRutaParada = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysRutaParada.add(new TableInfo.ForeignKey("Ruta", "NO ACTION", "NO ACTION",Arrays.asList("ruta_ID"), Arrays.asList("id")));
        _foreignKeysRutaParada.add(new TableInfo.ForeignKey("Parada", "NO ACTION", "NO ACTION",Arrays.asList("parada_ID"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesRutaParada = new HashSet<TableInfo.Index>(2);
        _indicesRutaParada.add(new TableInfo.Index("index_RutaParada_ruta_ID", false, Arrays.asList("ruta_ID"), Arrays.asList("ASC")));
        _indicesRutaParada.add(new TableInfo.Index("index_RutaParada_parada_ID", false, Arrays.asList("parada_ID"), Arrays.asList("ASC")));
        final TableInfo _infoRutaParada = new TableInfo("RutaParada", _columnsRutaParada, _foreignKeysRutaParada, _indicesRutaParada);
        final TableInfo _existingRutaParada = TableInfo.read(_db, "RutaParada");
        if (! _infoRutaParada.equals(_existingRutaParada)) {
          return new RoomOpenHelper.ValidationResult(false, "RutaParada(com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada).\n"
                  + " Expected:\n" + _infoRutaParada + "\n"
                  + " Found:\n" + _existingRutaParada);
        }
        final HashMap<String, TableInfo.Column> _columnsUnidadCoordenada = new HashMap<String, TableInfo.Column>(2);
        _columnsUnidadCoordenada.put("unidad_Placa", new TableInfo.Column("unidad_Placa", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnidadCoordenada.put("coordenada_ID", new TableInfo.Column("coordenada_ID", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUnidadCoordenada = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysUnidadCoordenada.add(new TableInfo.ForeignKey("Unidad", "NO ACTION", "NO ACTION",Arrays.asList("unidad_Placa"), Arrays.asList("placa")));
        _foreignKeysUnidadCoordenada.add(new TableInfo.ForeignKey("Coordenada", "NO ACTION", "NO ACTION",Arrays.asList("coordenada_ID"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUnidadCoordenada = new HashSet<TableInfo.Index>(2);
        _indicesUnidadCoordenada.add(new TableInfo.Index("index_UnidadCoordenada_unidad_Placa", false, Arrays.asList("unidad_Placa"), Arrays.asList("ASC")));
        _indicesUnidadCoordenada.add(new TableInfo.Index("index_UnidadCoordenada_coordenada_ID", false, Arrays.asList("coordenada_ID"), Arrays.asList("ASC")));
        final TableInfo _infoUnidadCoordenada = new TableInfo("UnidadCoordenada", _columnsUnidadCoordenada, _foreignKeysUnidadCoordenada, _indicesUnidadCoordenada);
        final TableInfo _existingUnidadCoordenada = TableInfo.read(_db, "UnidadCoordenada");
        if (! _infoUnidadCoordenada.equals(_existingUnidadCoordenada)) {
          return new RoomOpenHelper.ValidationResult(false, "UnidadCoordenada(com.gammasoft.busfinder.model.dbLocal.relaciones.UnidadCoordenada).\n"
                  + " Expected:\n" + _infoUnidadCoordenada + "\n"
                  + " Found:\n" + _existingUnidadCoordenada);
        }
        final HashMap<String, TableInfo.Column> _columnsHorarioChoferUnidadRuta = new HashMap<String, TableInfo.Column>(5);
        _columnsHorarioChoferUnidadRuta.put("horario_ID", new TableInfo.Column("horario_ID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHorarioChoferUnidadRuta.put("chofer_Usuario", new TableInfo.Column("chofer_Usuario", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHorarioChoferUnidadRuta.put("unidad_Placa", new TableInfo.Column("unidad_Placa", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHorarioChoferUnidadRuta.put("ruta_Ida_ID", new TableInfo.Column("ruta_Ida_ID", "INTEGER", true, 4, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHorarioChoferUnidadRuta.put("ruta_Venida_ID", new TableInfo.Column("ruta_Venida_ID", "INTEGER", true, 5, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHorarioChoferUnidadRuta = new HashSet<TableInfo.ForeignKey>(5);
        _foreignKeysHorarioChoferUnidadRuta.add(new TableInfo.ForeignKey("Horario", "NO ACTION", "NO ACTION",Arrays.asList("horario_ID"), Arrays.asList("id")));
        _foreignKeysHorarioChoferUnidadRuta.add(new TableInfo.ForeignKey("Chofer", "NO ACTION", "NO ACTION",Arrays.asList("chofer_Usuario"), Arrays.asList("usuario")));
        _foreignKeysHorarioChoferUnidadRuta.add(new TableInfo.ForeignKey("Unidad", "NO ACTION", "NO ACTION",Arrays.asList("unidad_Placa"), Arrays.asList("placa")));
        _foreignKeysHorarioChoferUnidadRuta.add(new TableInfo.ForeignKey("Ruta", "NO ACTION", "NO ACTION",Arrays.asList("ruta_Ida_ID"), Arrays.asList("id")));
        _foreignKeysHorarioChoferUnidadRuta.add(new TableInfo.ForeignKey("Ruta", "NO ACTION", "NO ACTION",Arrays.asList("ruta_Venida_ID"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesHorarioChoferUnidadRuta = new HashSet<TableInfo.Index>(5);
        _indicesHorarioChoferUnidadRuta.add(new TableInfo.Index("index_HorarioChoferUnidadRuta_horario_ID", false, Arrays.asList("horario_ID"), Arrays.asList("ASC")));
        _indicesHorarioChoferUnidadRuta.add(new TableInfo.Index("index_HorarioChoferUnidadRuta_chofer_Usuario", false, Arrays.asList("chofer_Usuario"), Arrays.asList("ASC")));
        _indicesHorarioChoferUnidadRuta.add(new TableInfo.Index("index_HorarioChoferUnidadRuta_unidad_Placa", false, Arrays.asList("unidad_Placa"), Arrays.asList("ASC")));
        _indicesHorarioChoferUnidadRuta.add(new TableInfo.Index("index_HorarioChoferUnidadRuta_ruta_Ida_ID", false, Arrays.asList("ruta_Ida_ID"), Arrays.asList("ASC")));
        _indicesHorarioChoferUnidadRuta.add(new TableInfo.Index("index_HorarioChoferUnidadRuta_ruta_Venida_ID", false, Arrays.asList("ruta_Venida_ID"), Arrays.asList("ASC")));
        final TableInfo _infoHorarioChoferUnidadRuta = new TableInfo("HorarioChoferUnidadRuta", _columnsHorarioChoferUnidadRuta, _foreignKeysHorarioChoferUnidadRuta, _indicesHorarioChoferUnidadRuta);
        final TableInfo _existingHorarioChoferUnidadRuta = TableInfo.read(_db, "HorarioChoferUnidadRuta");
        if (! _infoHorarioChoferUnidadRuta.equals(_existingHorarioChoferUnidadRuta)) {
          return new RoomOpenHelper.ValidationResult(false, "HorarioChoferUnidadRuta(com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR).\n"
                  + " Expected:\n" + _infoHorarioChoferUnidadRuta + "\n"
                  + " Found:\n" + _existingHorarioChoferUnidadRuta);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "92a3e2cfbe5adfd321979365891559ab", "e2f9deb6cd8649f2aa5dd5254eae20a2");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Cuenta","Administrador","Chofer","PublicoGeneral","Ruta","Parada","Coordenada","Unidad","Tarifa","Horario","SugerenciaQueja","CuentaAdministrador","CuentaChofer","CuentaPublico","RutaCoordenada","RutaParada","UnidadCoordenada","HorarioChoferUnidadRuta");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Cuenta`");
      _db.execSQL("DELETE FROM `Administrador`");
      _db.execSQL("DELETE FROM `Chofer`");
      _db.execSQL("DELETE FROM `PublicoGeneral`");
      _db.execSQL("DELETE FROM `Ruta`");
      _db.execSQL("DELETE FROM `Parada`");
      _db.execSQL("DELETE FROM `Coordenada`");
      _db.execSQL("DELETE FROM `Unidad`");
      _db.execSQL("DELETE FROM `Tarifa`");
      _db.execSQL("DELETE FROM `Horario`");
      _db.execSQL("DELETE FROM `SugerenciaQueja`");
      _db.execSQL("DELETE FROM `CuentaAdministrador`");
      _db.execSQL("DELETE FROM `CuentaChofer`");
      _db.execSQL("DELETE FROM `CuentaPublico`");
      _db.execSQL("DELETE FROM `RutaCoordenada`");
      _db.execSQL("DELETE FROM `RutaParada`");
      _db.execSQL("DELETE FROM `UnidadCoordenada`");
      _db.execSQL("DELETE FROM `HorarioChoferUnidadRuta`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(Crud.class, Crud_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public Crud crud() {
    if (_crud != null) {
      return _crud;
    } else {
      synchronized(this) {
        if(_crud == null) {
          _crud = new Crud_Impl(this);
        }
        return _crud;
      }
    }
  }
}
