package com.gammasoft.busfinder.model.dbLocal;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.gammasoft.busfinder.model.dbLocal.entidades.Administrador;
import com.gammasoft.busfinder.model.dbLocal.entidades.Chofer;
import com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada;
import com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta;
import com.gammasoft.busfinder.model.dbLocal.entidades.Horario;
import com.gammasoft.busfinder.model.dbLocal.entidades.Parada;
import com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral;
import com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia;
import com.gammasoft.busfinder.model.dbLocal.entidades.Ruta;
import com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa;
import com.gammasoft.busfinder.model.dbLocal.entidades.Unidad;
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador;
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer;
import com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico;
import com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR;
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada;
import com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada;
import com.gammasoft.busfinder.model.dbLocal.relaciones.UnidadCoordenada;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Crud_Impl implements Crud {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cuenta> __insertionAdapterOfCuenta;

  private final EntityInsertionAdapter<Administrador> __insertionAdapterOfAdministrador;

  private final EntityInsertionAdapter<Chofer> __insertionAdapterOfChofer;

  private final EntityInsertionAdapter<PublicoGeneral> __insertionAdapterOfPublicoGeneral;

  private final EntityInsertionAdapter<Ruta> __insertionAdapterOfRuta;

  private final EntityInsertionAdapter<Parada> __insertionAdapterOfParada;

  private final EntityInsertionAdapter<Unidad> __insertionAdapterOfUnidad;

  private final EntityInsertionAdapter<Tarifa> __insertionAdapterOfTarifa;

  private final EntityInsertionAdapter<Horario> __insertionAdapterOfHorario;

  private final EntityInsertionAdapter<Coordenada> __insertionAdapterOfCoordenada;

  private final EntityInsertionAdapter<QuejaSugerencia> __insertionAdapterOfQuejaSugerencia;

  private final EntityInsertionAdapter<CuentaAdministrador> __insertionAdapterOfCuentaAdministrador;

  private final EntityInsertionAdapter<CuentaChofer> __insertionAdapterOfCuentaChofer;

  private final EntityInsertionAdapter<CuentaPublico> __insertionAdapterOfCuentaPublico;

  private final EntityInsertionAdapter<RutaCoordenada> __insertionAdapterOfRutaCoordenada;

  private final EntityInsertionAdapter<RutaParada> __insertionAdapterOfRutaParada;

  private final EntityInsertionAdapter<UnidadCoordenada> __insertionAdapterOfUnidadCoordenada;

  private final EntityInsertionAdapter<HorarioCUR> __insertionAdapterOfHorarioCUR;

  private final EntityDeletionOrUpdateAdapter<Cuenta> __deletionAdapterOfCuenta;

  private final EntityDeletionOrUpdateAdapter<Administrador> __deletionAdapterOfAdministrador;

  private final EntityDeletionOrUpdateAdapter<Chofer> __deletionAdapterOfChofer;

  private final EntityDeletionOrUpdateAdapter<PublicoGeneral> __deletionAdapterOfPublicoGeneral;

  private final EntityDeletionOrUpdateAdapter<Ruta> __deletionAdapterOfRuta;

  private final EntityDeletionOrUpdateAdapter<Parada> __deletionAdapterOfParada;

  private final EntityDeletionOrUpdateAdapter<Unidad> __deletionAdapterOfUnidad;

  private final EntityDeletionOrUpdateAdapter<Tarifa> __deletionAdapterOfTarifa;

  private final EntityDeletionOrUpdateAdapter<Horario> __deletionAdapterOfHorario;

  private final EntityDeletionOrUpdateAdapter<Coordenada> __deletionAdapterOfCoordenada;

  private final EntityDeletionOrUpdateAdapter<QuejaSugerencia> __deletionAdapterOfQuejaSugerencia;

  private final EntityDeletionOrUpdateAdapter<CuentaAdministrador> __deletionAdapterOfCuentaAdministrador;

  private final EntityDeletionOrUpdateAdapter<CuentaChofer> __deletionAdapterOfCuentaChofer;

  private final EntityDeletionOrUpdateAdapter<CuentaPublico> __deletionAdapterOfCuentaPublico;

  private final EntityDeletionOrUpdateAdapter<RutaCoordenada> __deletionAdapterOfRutaCoordenada;

  private final EntityDeletionOrUpdateAdapter<RutaParada> __deletionAdapterOfRutaParada;

  private final EntityDeletionOrUpdateAdapter<UnidadCoordenada> __deletionAdapterOfUnidadCoordenada;

  private final EntityDeletionOrUpdateAdapter<HorarioCUR> __deletionAdapterOfHorarioCUR;

  private final EntityDeletionOrUpdateAdapter<Cuenta> __updateAdapterOfCuenta;

  private final EntityDeletionOrUpdateAdapter<Administrador> __updateAdapterOfAdministrador;

  private final EntityDeletionOrUpdateAdapter<Chofer> __updateAdapterOfChofer;

  private final EntityDeletionOrUpdateAdapter<PublicoGeneral> __updateAdapterOfPublicoGeneral;

  private final EntityDeletionOrUpdateAdapter<Ruta> __updateAdapterOfRuta;

  private final EntityDeletionOrUpdateAdapter<Parada> __updateAdapterOfParada;

  private final EntityDeletionOrUpdateAdapter<Unidad> __updateAdapterOfUnidad;

  private final EntityDeletionOrUpdateAdapter<Tarifa> __updateAdapterOfTarifa;

  private final EntityDeletionOrUpdateAdapter<Horario> __updateAdapterOfHorario;

  private final EntityDeletionOrUpdateAdapter<Coordenada> __updateAdapterOfCoordenada;

  private final EntityDeletionOrUpdateAdapter<QuejaSugerencia> __updateAdapterOfQuejaSugerencia;

  private final EntityDeletionOrUpdateAdapter<CuentaAdministrador> __updateAdapterOfCuentaAdministrador;

  private final EntityDeletionOrUpdateAdapter<CuentaChofer> __updateAdapterOfCuentaChofer;

  private final EntityDeletionOrUpdateAdapter<CuentaPublico> __updateAdapterOfCuentaPublico;

  private final EntityDeletionOrUpdateAdapter<RutaCoordenada> __updateAdapterOfRutaCoordenada;

  private final EntityDeletionOrUpdateAdapter<RutaParada> __updateAdapterOfRutaParada;

  private final EntityDeletionOrUpdateAdapter<UnidadCoordenada> __updateAdapterOfUnidadCoordenada;

  private final EntityDeletionOrUpdateAdapter<HorarioCUR> __updateAdapterOfHorarioCUR;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCuentas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAdministradoresByRFC;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAdministradores;

  private final SharedSQLiteStatement __preparedStmtOfDeleteChoferes;

  private final SharedSQLiteStatement __preparedStmtOfDeletePublicosGenerales;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRutas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteParadas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUnidades;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTarifas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteHorarios;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCoordenadaById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCoordenadas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSugerenciaQueja;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSugerenciasQuejas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCuentasAdministrador;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCuentasChofer;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCuentasPublico;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRutasCoordenadas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRutasParadas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUnidadesCoordenadas;

  private final SharedSQLiteStatement __preparedStmtOfDeleteHorariosCUR;

  public Crud_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCuenta = new EntityInsertionAdapter<Cuenta>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Cuenta` (`correo`,`contrasenia`,`foto`,`tipo`,`metodo`,`estado`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Cuenta value) {
        if (value.getCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCorreo());
        }
        if (value.getContrasenia() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContrasenia());
        }
        if (value.getFoto() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFoto());
        }
        stmt.bindLong(4, value.getTipo());
        if (value.getMetodo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMetodo());
        }
        final int _tmp = value.getEstado() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
    this.__insertionAdapterOfAdministrador = new EntityInsertionAdapter<Administrador>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Administrador` (`usuario`,`rfc`,`nombre`,`numero_Celular`,`linea_Transporte`,`codigo`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Administrador value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
        if (value.getRfc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRfc());
        }
        if (value.getNombre() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNombre());
        }
        stmt.bindLong(4, value.getNumCelular());
        if (value.getLinea() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLinea());
        }
        stmt.bindLong(6, value.getCodigo());
      }
    };
    this.__insertionAdapterOfChofer = new EntityInsertionAdapter<Chofer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Chofer` (`usuario`,`rfc`,`nombre`,`numero_Celular`,`linea_Transporte`,`codigo`,`noUsuarios`,`calificacion`,`administrador`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chofer value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
        if (value.getRfc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRfc());
        }
        if (value.getNombre() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNombre());
        }
        stmt.bindLong(4, value.getNumCelular());
        if (value.getLinea() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLinea());
        }
        stmt.bindLong(6, value.getCodigo());
        stmt.bindLong(7, value.getNoUsuarios());
        stmt.bindDouble(8, value.getCalificacion());
        if (value.getAdministrador() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAdministrador());
        }
      }
    };
    this.__insertionAdapterOfPublicoGeneral = new EntityInsertionAdapter<PublicoGeneral>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PublicoGeneral` (`usuario`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PublicoGeneral value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
      }
    };
    this.__insertionAdapterOfRuta = new EntityInsertionAdapter<Ruta>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Ruta` (`id`,`nombre`,`administrador`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ruta value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getAdministrador() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAdministrador());
        }
      }
    };
    this.__insertionAdapterOfParada = new EntityInsertionAdapter<Parada>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Parada` (`id`,`nombre`,`longitud`,`latitud`,`administrador`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Parada value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        stmt.bindDouble(3, value.getLongitud());
        stmt.bindDouble(4, value.getLatitud());
        if (value.getAdministrador() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAdministrador());
        }
      }
    };
    this.__insertionAdapterOfUnidad = new EntityInsertionAdapter<Unidad>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Unidad` (`placa`,`marca`,`modelo`,`numero`,`hora`,`fecha`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Unidad value) {
        if (value.getPlaca() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPlaca());
        }
        if (value.getMarca() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMarca());
        }
        if (value.getModelo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModelo());
        }
        stmt.bindLong(4, value.getNumero());
        if (value.getHora() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHora());
        }
        if (value.getFecha() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFecha());
        }
      }
    };
    this.__insertionAdapterOfTarifa = new EntityInsertionAdapter<Tarifa>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Tarifa` (`nombre`,`precio`,`administrador`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tarifa value) {
        if (value.getNombre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNombre());
        }
        stmt.bindDouble(2, value.getPrecio());
        if (value.getAdministrador() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAdministrador());
        }
      }
    };
    this.__insertionAdapterOfHorario = new EntityInsertionAdapter<Horario>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Horario` (`id`,`hora_Entrada`,`hora_Salida`,`fecha`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Horario value) {
        stmt.bindLong(1, value.getId());
        if (value.getHoraEntrada() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getHoraEntrada());
        }
        if (value.getHoraSalida() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getHoraSalida());
        }
        if (value.getFecha() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFecha());
        }
      }
    };
    this.__insertionAdapterOfCoordenada = new EntityInsertionAdapter<Coordenada>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Coordenada` (`id`,`longitud`,`latitud`,`administrador`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Coordenada value) {
        stmt.bindLong(1, value.getId());
        stmt.bindDouble(2, value.getLongitud());
        stmt.bindDouble(3, value.getLatitud());
        if (value.getAdministrador() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAdministrador());
        }
      }
    };
    this.__insertionAdapterOfQuejaSugerencia = new EntityInsertionAdapter<QuejaSugerencia>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `SugerenciaQueja` (`id`,`descripcion`,`usuario`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuejaSugerencia value) {
        stmt.bindLong(1, value.getId());
        if (value.getDescripcion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescripcion());
        }
        if (value.getUsuario() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUsuario());
        }
      }
    };
    this.__insertionAdapterOfCuentaAdministrador = new EntityInsertionAdapter<CuentaAdministrador>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `CuentaAdministrador` (`cuenta_Correo`,`administrador_Usuario`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaAdministrador value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getAdminUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAdminUsuario());
        }
      }
    };
    this.__insertionAdapterOfCuentaChofer = new EntityInsertionAdapter<CuentaChofer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `CuentaChofer` (`cuenta_Correo`,`chofer_Usuario`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaChofer value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getChoferUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChoferUsuario());
        }
      }
    };
    this.__insertionAdapterOfCuentaPublico = new EntityInsertionAdapter<CuentaPublico>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `CuentaPublico` (`cuenta_Correo`,`publico_General_Usuario`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaPublico value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getPublicoUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPublicoUsuario());
        }
      }
    };
    this.__insertionAdapterOfRutaCoordenada = new EntityInsertionAdapter<RutaCoordenada>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `RutaCoordenada` (`ruta_ID`,`coordenada_ID`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RutaCoordenada value) {
        stmt.bindLong(1, value.getRutaID());
        stmt.bindLong(2, value.getCoordenadaID());
      }
    };
    this.__insertionAdapterOfRutaParada = new EntityInsertionAdapter<RutaParada>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `RutaParada` (`ruta_ID`,`parada_ID`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RutaParada value) {
        stmt.bindLong(1, value.getRutaID());
        stmt.bindLong(2, value.getParadaID());
      }
    };
    this.__insertionAdapterOfUnidadCoordenada = new EntityInsertionAdapter<UnidadCoordenada>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `UnidadCoordenada` (`unidad_Placa`,`coordenada_ID`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnidadCoordenada value) {
        if (value.getUnidadPlaca() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUnidadPlaca());
        }
        stmt.bindLong(2, value.getCoordenadaID());
      }
    };
    this.__insertionAdapterOfHorarioCUR = new EntityInsertionAdapter<HorarioCUR>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `HorarioChoferUnidadRuta` (`horario_ID`,`chofer_Usuario`,`unidad_Placa`,`ruta_Ida_ID`,`ruta_Venida_ID`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HorarioCUR value) {
        stmt.bindLong(1, value.getHorarioId());
        if (value.getChoferUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChoferUsuario());
        }
        if (value.getUnidadPlaca() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUnidadPlaca());
        }
        stmt.bindLong(4, value.getRutaIdaId());
        stmt.bindLong(5, value.getRutaVenidaId());
      }
    };
    this.__deletionAdapterOfCuenta = new EntityDeletionOrUpdateAdapter<Cuenta>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Cuenta` WHERE `correo` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Cuenta value) {
        if (value.getCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCorreo());
        }
      }
    };
    this.__deletionAdapterOfAdministrador = new EntityDeletionOrUpdateAdapter<Administrador>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Administrador` WHERE `usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Administrador value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
      }
    };
    this.__deletionAdapterOfChofer = new EntityDeletionOrUpdateAdapter<Chofer>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Chofer` WHERE `usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chofer value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
      }
    };
    this.__deletionAdapterOfPublicoGeneral = new EntityDeletionOrUpdateAdapter<PublicoGeneral>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PublicoGeneral` WHERE `usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PublicoGeneral value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
      }
    };
    this.__deletionAdapterOfRuta = new EntityDeletionOrUpdateAdapter<Ruta>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Ruta` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ruta value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfParada = new EntityDeletionOrUpdateAdapter<Parada>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Parada` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Parada value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfUnidad = new EntityDeletionOrUpdateAdapter<Unidad>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Unidad` WHERE `placa` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Unidad value) {
        if (value.getPlaca() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPlaca());
        }
      }
    };
    this.__deletionAdapterOfTarifa = new EntityDeletionOrUpdateAdapter<Tarifa>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Tarifa` WHERE `nombre` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tarifa value) {
        if (value.getNombre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNombre());
        }
      }
    };
    this.__deletionAdapterOfHorario = new EntityDeletionOrUpdateAdapter<Horario>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Horario` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Horario value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfCoordenada = new EntityDeletionOrUpdateAdapter<Coordenada>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Coordenada` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Coordenada value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfQuejaSugerencia = new EntityDeletionOrUpdateAdapter<QuejaSugerencia>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `SugerenciaQueja` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuejaSugerencia value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__deletionAdapterOfCuentaAdministrador = new EntityDeletionOrUpdateAdapter<CuentaAdministrador>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `CuentaAdministrador` WHERE `cuenta_Correo` = ? AND `administrador_Usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaAdministrador value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getAdminUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAdminUsuario());
        }
      }
    };
    this.__deletionAdapterOfCuentaChofer = new EntityDeletionOrUpdateAdapter<CuentaChofer>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `CuentaChofer` WHERE `cuenta_Correo` = ? AND `chofer_Usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaChofer value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getChoferUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChoferUsuario());
        }
      }
    };
    this.__deletionAdapterOfCuentaPublico = new EntityDeletionOrUpdateAdapter<CuentaPublico>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `CuentaPublico` WHERE `cuenta_Correo` = ? AND `publico_General_Usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaPublico value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getPublicoUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPublicoUsuario());
        }
      }
    };
    this.__deletionAdapterOfRutaCoordenada = new EntityDeletionOrUpdateAdapter<RutaCoordenada>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `RutaCoordenada` WHERE `ruta_ID` = ? AND `coordenada_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RutaCoordenada value) {
        stmt.bindLong(1, value.getRutaID());
        stmt.bindLong(2, value.getCoordenadaID());
      }
    };
    this.__deletionAdapterOfRutaParada = new EntityDeletionOrUpdateAdapter<RutaParada>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `RutaParada` WHERE `ruta_ID` = ? AND `parada_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RutaParada value) {
        stmt.bindLong(1, value.getRutaID());
        stmt.bindLong(2, value.getParadaID());
      }
    };
    this.__deletionAdapterOfUnidadCoordenada = new EntityDeletionOrUpdateAdapter<UnidadCoordenada>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `UnidadCoordenada` WHERE `unidad_Placa` = ? AND `coordenada_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnidadCoordenada value) {
        if (value.getUnidadPlaca() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUnidadPlaca());
        }
        stmt.bindLong(2, value.getCoordenadaID());
      }
    };
    this.__deletionAdapterOfHorarioCUR = new EntityDeletionOrUpdateAdapter<HorarioCUR>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `HorarioChoferUnidadRuta` WHERE `horario_ID` = ? AND `chofer_Usuario` = ? AND `unidad_Placa` = ? AND `ruta_Ida_ID` = ? AND `ruta_Venida_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HorarioCUR value) {
        stmt.bindLong(1, value.getHorarioId());
        if (value.getChoferUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChoferUsuario());
        }
        if (value.getUnidadPlaca() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUnidadPlaca());
        }
        stmt.bindLong(4, value.getRutaIdaId());
        stmt.bindLong(5, value.getRutaVenidaId());
      }
    };
    this.__updateAdapterOfCuenta = new EntityDeletionOrUpdateAdapter<Cuenta>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Cuenta` SET `correo` = ?,`contrasenia` = ?,`foto` = ?,`tipo` = ?,`metodo` = ?,`estado` = ? WHERE `correo` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Cuenta value) {
        if (value.getCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCorreo());
        }
        if (value.getContrasenia() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContrasenia());
        }
        if (value.getFoto() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFoto());
        }
        stmt.bindLong(4, value.getTipo());
        if (value.getMetodo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMetodo());
        }
        final int _tmp = value.getEstado() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getCorreo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCorreo());
        }
      }
    };
    this.__updateAdapterOfAdministrador = new EntityDeletionOrUpdateAdapter<Administrador>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Administrador` SET `usuario` = ?,`rfc` = ?,`nombre` = ?,`numero_Celular` = ?,`linea_Transporte` = ?,`codigo` = ? WHERE `usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Administrador value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
        if (value.getRfc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRfc());
        }
        if (value.getNombre() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNombre());
        }
        stmt.bindLong(4, value.getNumCelular());
        if (value.getLinea() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLinea());
        }
        stmt.bindLong(6, value.getCodigo());
        if (value.getUsuario() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUsuario());
        }
      }
    };
    this.__updateAdapterOfChofer = new EntityDeletionOrUpdateAdapter<Chofer>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Chofer` SET `usuario` = ?,`rfc` = ?,`nombre` = ?,`numero_Celular` = ?,`linea_Transporte` = ?,`codigo` = ?,`noUsuarios` = ?,`calificacion` = ?,`administrador` = ? WHERE `usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Chofer value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
        if (value.getRfc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRfc());
        }
        if (value.getNombre() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNombre());
        }
        stmt.bindLong(4, value.getNumCelular());
        if (value.getLinea() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLinea());
        }
        stmt.bindLong(6, value.getCodigo());
        stmt.bindLong(7, value.getNoUsuarios());
        stmt.bindDouble(8, value.getCalificacion());
        if (value.getAdministrador() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAdministrador());
        }
        if (value.getUsuario() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUsuario());
        }
      }
    };
    this.__updateAdapterOfPublicoGeneral = new EntityDeletionOrUpdateAdapter<PublicoGeneral>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PublicoGeneral` SET `usuario` = ? WHERE `usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PublicoGeneral value) {
        if (value.getUsuario() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUsuario());
        }
        if (value.getUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUsuario());
        }
      }
    };
    this.__updateAdapterOfRuta = new EntityDeletionOrUpdateAdapter<Ruta>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Ruta` SET `id` = ?,`nombre` = ?,`administrador` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ruta value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        if (value.getAdministrador() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAdministrador());
        }
        stmt.bindLong(4, value.getId());
      }
    };
    this.__updateAdapterOfParada = new EntityDeletionOrUpdateAdapter<Parada>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Parada` SET `id` = ?,`nombre` = ?,`longitud` = ?,`latitud` = ?,`administrador` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Parada value) {
        stmt.bindLong(1, value.getId());
        if (value.getNombre() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNombre());
        }
        stmt.bindDouble(3, value.getLongitud());
        stmt.bindDouble(4, value.getLatitud());
        if (value.getAdministrador() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAdministrador());
        }
        stmt.bindLong(6, value.getId());
      }
    };
    this.__updateAdapterOfUnidad = new EntityDeletionOrUpdateAdapter<Unidad>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Unidad` SET `placa` = ?,`marca` = ?,`modelo` = ?,`numero` = ?,`hora` = ?,`fecha` = ? WHERE `placa` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Unidad value) {
        if (value.getPlaca() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPlaca());
        }
        if (value.getMarca() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMarca());
        }
        if (value.getModelo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModelo());
        }
        stmt.bindLong(4, value.getNumero());
        if (value.getHora() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHora());
        }
        if (value.getFecha() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFecha());
        }
        if (value.getPlaca() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPlaca());
        }
      }
    };
    this.__updateAdapterOfTarifa = new EntityDeletionOrUpdateAdapter<Tarifa>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Tarifa` SET `nombre` = ?,`precio` = ?,`administrador` = ? WHERE `nombre` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tarifa value) {
        if (value.getNombre() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNombre());
        }
        stmt.bindDouble(2, value.getPrecio());
        if (value.getAdministrador() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAdministrador());
        }
        if (value.getNombre() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNombre());
        }
      }
    };
    this.__updateAdapterOfHorario = new EntityDeletionOrUpdateAdapter<Horario>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Horario` SET `id` = ?,`hora_Entrada` = ?,`hora_Salida` = ?,`fecha` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Horario value) {
        stmt.bindLong(1, value.getId());
        if (value.getHoraEntrada() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getHoraEntrada());
        }
        if (value.getHoraSalida() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getHoraSalida());
        }
        if (value.getFecha() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFecha());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__updateAdapterOfCoordenada = new EntityDeletionOrUpdateAdapter<Coordenada>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Coordenada` SET `id` = ?,`longitud` = ?,`latitud` = ?,`administrador` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Coordenada value) {
        stmt.bindLong(1, value.getId());
        stmt.bindDouble(2, value.getLongitud());
        stmt.bindDouble(3, value.getLatitud());
        if (value.getAdministrador() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAdministrador());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__updateAdapterOfQuejaSugerencia = new EntityDeletionOrUpdateAdapter<QuejaSugerencia>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `SugerenciaQueja` SET `id` = ?,`descripcion` = ?,`usuario` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, QuejaSugerencia value) {
        stmt.bindLong(1, value.getId());
        if (value.getDescripcion() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescripcion());
        }
        if (value.getUsuario() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUsuario());
        }
        stmt.bindLong(4, value.getId());
      }
    };
    this.__updateAdapterOfCuentaAdministrador = new EntityDeletionOrUpdateAdapter<CuentaAdministrador>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CuentaAdministrador` SET `cuenta_Correo` = ?,`administrador_Usuario` = ? WHERE `cuenta_Correo` = ? AND `administrador_Usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaAdministrador value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getAdminUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAdminUsuario());
        }
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCuentaCorreo());
        }
        if (value.getAdminUsuario() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAdminUsuario());
        }
      }
    };
    this.__updateAdapterOfCuentaChofer = new EntityDeletionOrUpdateAdapter<CuentaChofer>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CuentaChofer` SET `cuenta_Correo` = ?,`chofer_Usuario` = ? WHERE `cuenta_Correo` = ? AND `chofer_Usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaChofer value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getChoferUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChoferUsuario());
        }
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCuentaCorreo());
        }
        if (value.getChoferUsuario() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getChoferUsuario());
        }
      }
    };
    this.__updateAdapterOfCuentaPublico = new EntityDeletionOrUpdateAdapter<CuentaPublico>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CuentaPublico` SET `cuenta_Correo` = ?,`publico_General_Usuario` = ? WHERE `cuenta_Correo` = ? AND `publico_General_Usuario` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CuentaPublico value) {
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCuentaCorreo());
        }
        if (value.getPublicoUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPublicoUsuario());
        }
        if (value.getCuentaCorreo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCuentaCorreo());
        }
        if (value.getPublicoUsuario() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPublicoUsuario());
        }
      }
    };
    this.__updateAdapterOfRutaCoordenada = new EntityDeletionOrUpdateAdapter<RutaCoordenada>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `RutaCoordenada` SET `ruta_ID` = ?,`coordenada_ID` = ? WHERE `ruta_ID` = ? AND `coordenada_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RutaCoordenada value) {
        stmt.bindLong(1, value.getRutaID());
        stmt.bindLong(2, value.getCoordenadaID());
        stmt.bindLong(3, value.getRutaID());
        stmt.bindLong(4, value.getCoordenadaID());
      }
    };
    this.__updateAdapterOfRutaParada = new EntityDeletionOrUpdateAdapter<RutaParada>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `RutaParada` SET `ruta_ID` = ?,`parada_ID` = ? WHERE `ruta_ID` = ? AND `parada_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RutaParada value) {
        stmt.bindLong(1, value.getRutaID());
        stmt.bindLong(2, value.getParadaID());
        stmt.bindLong(3, value.getRutaID());
        stmt.bindLong(4, value.getParadaID());
      }
    };
    this.__updateAdapterOfUnidadCoordenada = new EntityDeletionOrUpdateAdapter<UnidadCoordenada>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `UnidadCoordenada` SET `unidad_Placa` = ?,`coordenada_ID` = ? WHERE `unidad_Placa` = ? AND `coordenada_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UnidadCoordenada value) {
        if (value.getUnidadPlaca() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUnidadPlaca());
        }
        stmt.bindLong(2, value.getCoordenadaID());
        if (value.getUnidadPlaca() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUnidadPlaca());
        }
        stmt.bindLong(4, value.getCoordenadaID());
      }
    };
    this.__updateAdapterOfHorarioCUR = new EntityDeletionOrUpdateAdapter<HorarioCUR>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `HorarioChoferUnidadRuta` SET `horario_ID` = ?,`chofer_Usuario` = ?,`unidad_Placa` = ?,`ruta_Ida_ID` = ?,`ruta_Venida_ID` = ? WHERE `horario_ID` = ? AND `chofer_Usuario` = ? AND `unidad_Placa` = ? AND `ruta_Ida_ID` = ? AND `ruta_Venida_ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HorarioCUR value) {
        stmt.bindLong(1, value.getHorarioId());
        if (value.getChoferUsuario() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getChoferUsuario());
        }
        if (value.getUnidadPlaca() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUnidadPlaca());
        }
        stmt.bindLong(4, value.getRutaIdaId());
        stmt.bindLong(5, value.getRutaVenidaId());
        stmt.bindLong(6, value.getHorarioId());
        if (value.getChoferUsuario() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getChoferUsuario());
        }
        if (value.getUnidadPlaca() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUnidadPlaca());
        }
        stmt.bindLong(9, value.getRutaIdaId());
        stmt.bindLong(10, value.getRutaVenidaId());
      }
    };
    this.__preparedStmtOfDeleteCuentas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Cuenta";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAdministradoresByRFC = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Administrador WHERE rfc = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAdministradores = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Administrador";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteChoferes = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Chofer";
        return _query;
      }
    };
    this.__preparedStmtOfDeletePublicosGenerales = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM PublicoGeneral";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteRutas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Ruta";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteParadas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Parada";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUnidades = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Unidad";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteTarifas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Tarifa";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteHorarios = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Horario";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCoordenadaById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Coordenada WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCoordenadas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Coordenada";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSugerenciaQueja = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM SugerenciaQueja WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSugerenciasQuejas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM SugerenciaQueja";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCuentasAdministrador = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM CuentaAdministrador";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCuentasChofer = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM CuentaChofer";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCuentasPublico = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM CuentaPublico";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteRutasCoordenadas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM RutaCoordenada";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteRutasParadas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM RutaParada";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUnidadesCoordenadas = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM UnidadCoordenada";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteHorariosCUR = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM HorarioChoferUnidadRuta";
        return _query;
      }
    };
  }

  @Override
  public void addCuentas(final Cuenta... cuentas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCuenta.insert(cuentas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addAdministradores(final Administrador... administradores) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAdministrador.insert(administradores);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addChoferes(final Chofer... choferes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChofer.insert(choferes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addPublicoGeneral(final PublicoGeneral... publicoGeneral) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPublicoGeneral.insert(publicoGeneral);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addRutas(final Ruta... rutas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRuta.insert(rutas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addParadas(final Parada... paradas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfParada.insert(paradas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addUnidades(final Unidad... unidades) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUnidad.insert(unidades);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addTarifas(final Tarifa... tarifas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTarifa.insert(tarifas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addHorarios(final Horario... horarios) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHorario.insert(horarios);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addCoordenadas(final Coordenada... coordenadas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCoordenada.insert(coordenadas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addSugerenciaQueja(final QuejaSugerencia... quejaSugerencia) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfQuejaSugerencia.insert(quejaSugerencia);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addCuentasAdministrador(final CuentaAdministrador... cuentasAdministrador) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCuentaAdministrador.insert(cuentasAdministrador);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addCuentasChofer(final CuentaChofer... cuentasChofer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCuentaChofer.insert(cuentasChofer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addCuentasPublico(final CuentaPublico... cuentasPublico) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCuentaPublico.insert(cuentasPublico);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addRutaCoordenadas(final RutaCoordenada... rutaCoordenadas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRutaCoordenada.insert(rutaCoordenadas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addRutaParadas(final RutaParada... rutaParadas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRutaParada.insert(rutaParadas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addUnidadCoordenadas(final UnidadCoordenada... unidadesCoordenadas) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUnidadCoordenada.insert(unidadesCoordenadas);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addHorariosCUR(final HorarioCUR... horarioCURs) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHorarioCUR.insert(horarioCURs);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCuenta(final Cuenta cuenta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCuenta.handle(cuenta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAdministrador(final Administrador administrador) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAdministrador.handle(administrador);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteChofer(final Chofer chofer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChofer.handle(chofer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletePublicoGeneral(final PublicoGeneral publicoGeneral) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPublicoGeneral.handle(publicoGeneral);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteRuta(final Ruta ruta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRuta.handle(ruta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteParada(final Parada parada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfParada.handle(parada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUnidad(final Unidad unidad) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUnidad.handle(unidad);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTarifa(final Tarifa tarifa) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTarifa.handle(tarifa);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteHorario(final Horario horario) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfHorario.handle(horario);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCoordenada(final Coordenada coordenada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCoordenada.handle(coordenada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSugerenciaQueja(final QuejaSugerencia quejaSugerencia) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfQuejaSugerencia.handle(quejaSugerencia);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCuentaAdministrador(final CuentaAdministrador cuentaAdministrador) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCuentaAdministrador.handle(cuentaAdministrador);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCuentaChofer(final CuentaChofer cuentaChofer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCuentaChofer.handle(cuentaChofer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCuentaPublico(final CuentaPublico cuentaPublico) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCuentaPublico.handle(cuentaPublico);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteRutaCoordenada(final RutaCoordenada rutaCoordenada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRutaCoordenada.handle(rutaCoordenada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteRutaParada(final RutaParada rutaParada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRutaParada.handle(rutaParada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteUnidadCoordenada(final UnidadCoordenada unidadCoordenada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUnidadCoordenada.handle(unidadCoordenada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteHorarioCUR(final HorarioCUR horarioCUR) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfHorarioCUR.handle(horarioCUR);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCuenta(final Cuenta... cuenta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCuenta.handleMultiple(cuenta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAdministrador(final Administrador... administrador) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAdministrador.handleMultiple(administrador);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateChofer(final Chofer... chofer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChofer.handleMultiple(chofer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updatePublicoGeneral(final PublicoGeneral... publicoGeneral) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPublicoGeneral.handleMultiple(publicoGeneral);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateRuta(final Ruta... ruta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRuta.handleMultiple(ruta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateParada(final Parada... parada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfParada.handleMultiple(parada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUnidad(final Unidad... unidad) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUnidad.handleMultiple(unidad);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTarifa(final Tarifa... tarifa) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTarifa.handleMultiple(tarifa);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateHorario(final Horario... horario) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfHorario.handleMultiple(horario);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCoordenada(final Coordenada... coordenada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCoordenada.handleMultiple(coordenada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSugerenciaQueja(final QuejaSugerencia... quejaSugerencia) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfQuejaSugerencia.handleMultiple(quejaSugerencia);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCuentaAdministrador(final CuentaAdministrador... cuentaAdministrador) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCuentaAdministrador.handleMultiple(cuentaAdministrador);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCuentaChofer(final CuentaChofer... cuentaChofer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCuentaChofer.handleMultiple(cuentaChofer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCuentaPublico(final CuentaPublico... cuentaPublico) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCuentaPublico.handleMultiple(cuentaPublico);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateRutaCoordenada(final RutaCoordenada... rutaCoordenada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRutaCoordenada.handleMultiple(rutaCoordenada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateRutaParada(final RutaParada... rutaParada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRutaParada.handleMultiple(rutaParada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUnidadCoordenada(final UnidadCoordenada... unidadCoordenada) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUnidadCoordenada.handleMultiple(unidadCoordenada);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateHorarioCUR(final HorarioCUR... horarioCUR) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfHorarioCUR.handleMultiple(horarioCUR);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCuentas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCuentas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCuentas.release(_stmt);
    }
  }

  @Override
  public void deleteAdministradoresByRFC(final String rfc) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAdministradoresByRFC.acquire();
    int _argIndex = 1;
    if (rfc == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, rfc);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAdministradoresByRFC.release(_stmt);
    }
  }

  @Override
  public void deleteAdministradores() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAdministradores.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAdministradores.release(_stmt);
    }
  }

  @Override
  public void deleteChoferes() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteChoferes.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteChoferes.release(_stmt);
    }
  }

  @Override
  public void deletePublicosGenerales() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeletePublicosGenerales.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeletePublicosGenerales.release(_stmt);
    }
  }

  @Override
  public void deleteRutas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRutas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteRutas.release(_stmt);
    }
  }

  @Override
  public void deleteParadas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteParadas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteParadas.release(_stmt);
    }
  }

  @Override
  public void deleteUnidades() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUnidades.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUnidades.release(_stmt);
    }
  }

  @Override
  public void deleteTarifas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTarifas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTarifas.release(_stmt);
    }
  }

  @Override
  public void deleteHorarios() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteHorarios.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteHorarios.release(_stmt);
    }
  }

  @Override
  public void deleteCoordenadaById(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCoordenadaById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCoordenadaById.release(_stmt);
    }
  }

  @Override
  public void deleteCoordenadas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCoordenadas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCoordenadas.release(_stmt);
    }
  }

  @Override
  public void deleteSugerenciaQueja(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSugerenciaQueja.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSugerenciaQueja.release(_stmt);
    }
  }

  @Override
  public void deleteSugerenciasQuejas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSugerenciasQuejas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSugerenciasQuejas.release(_stmt);
    }
  }

  @Override
  public void deleteCuentasAdministrador() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCuentasAdministrador.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCuentasAdministrador.release(_stmt);
    }
  }

  @Override
  public void deleteCuentasChofer() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCuentasChofer.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCuentasChofer.release(_stmt);
    }
  }

  @Override
  public void deleteCuentasPublico() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCuentasPublico.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCuentasPublico.release(_stmt);
    }
  }

  @Override
  public void deleteRutasCoordenadas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRutasCoordenadas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteRutasCoordenadas.release(_stmt);
    }
  }

  @Override
  public void deleteRutasParadas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRutasParadas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteRutasParadas.release(_stmt);
    }
  }

  @Override
  public void deleteUnidadesCoordenadas() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUnidadesCoordenadas.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUnidadesCoordenadas.release(_stmt);
    }
  }

  @Override
  public void deleteHorariosCUR() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteHorariosCUR.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteHorariosCUR.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Cuenta>> getCuentas() {
    final String _sql = "SELECT * FROM Cuenta";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Cuenta"}, false, new Callable<List<Cuenta>>() {
      @Override
      public List<Cuenta> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "correo");
          final int _cursorIndexOfContrasenia = CursorUtil.getColumnIndexOrThrow(_cursor, "contrasenia");
          final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfMetodo = CursorUtil.getColumnIndexOrThrow(_cursor, "metodo");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final List<Cuenta> _result = new ArrayList<Cuenta>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Cuenta _item;
            final String _tmpCorreo;
            if (_cursor.isNull(_cursorIndexOfCorreo)) {
              _tmpCorreo = null;
            } else {
              _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
            }
            final String _tmpContrasenia;
            if (_cursor.isNull(_cursorIndexOfContrasenia)) {
              _tmpContrasenia = null;
            } else {
              _tmpContrasenia = _cursor.getString(_cursorIndexOfContrasenia);
            }
            final String _tmpFoto;
            if (_cursor.isNull(_cursorIndexOfFoto)) {
              _tmpFoto = null;
            } else {
              _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
            }
            final int _tmpTipo;
            _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
            final String _tmpMetodo;
            if (_cursor.isNull(_cursorIndexOfMetodo)) {
              _tmpMetodo = null;
            } else {
              _tmpMetodo = _cursor.getString(_cursorIndexOfMetodo);
            }
            final boolean _tmpEstado;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfEstado);
            _tmpEstado = _tmp != 0;
            _item = new Cuenta(_tmpCorreo,_tmpContrasenia,_tmpFoto,_tmpTipo,_tmpMetodo,_tmpEstado);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Cuenta> getCuentaByCorreo(final String correo) {
    final String _sql = "SELECT * FROM Cuenta WHERE correo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (correo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, correo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Cuenta"}, false, new Callable<Cuenta>() {
      @Override
      public Cuenta call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "correo");
          final int _cursorIndexOfContrasenia = CursorUtil.getColumnIndexOrThrow(_cursor, "contrasenia");
          final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
          final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
          final int _cursorIndexOfMetodo = CursorUtil.getColumnIndexOrThrow(_cursor, "metodo");
          final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
          final Cuenta _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCorreo;
            if (_cursor.isNull(_cursorIndexOfCorreo)) {
              _tmpCorreo = null;
            } else {
              _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
            }
            final String _tmpContrasenia;
            if (_cursor.isNull(_cursorIndexOfContrasenia)) {
              _tmpContrasenia = null;
            } else {
              _tmpContrasenia = _cursor.getString(_cursorIndexOfContrasenia);
            }
            final String _tmpFoto;
            if (_cursor.isNull(_cursorIndexOfFoto)) {
              _tmpFoto = null;
            } else {
              _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
            }
            final int _tmpTipo;
            _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
            final String _tmpMetodo;
            if (_cursor.isNull(_cursorIndexOfMetodo)) {
              _tmpMetodo = null;
            } else {
              _tmpMetodo = _cursor.getString(_cursorIndexOfMetodo);
            }
            final boolean _tmpEstado;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfEstado);
            _tmpEstado = _tmp != 0;
            _result = new Cuenta(_tmpCorreo,_tmpContrasenia,_tmpFoto,_tmpTipo,_tmpMetodo,_tmpEstado);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Administrador>> getAdministradores() {
    final String _sql = "SELECT * FROM Administrador";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Administrador"}, false, new Callable<List<Administrador>>() {
      @Override
      public List<Administrador> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final List<Administrador> _result = new ArrayList<Administrador>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Administrador _item;
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            _item = new Administrador(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Administrador> getAdministradorByUsuario(final String usuario) {
    final String _sql = "SELECT * FROM Administrador WHERE usuario = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usuario == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuario);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Administrador"}, false, new Callable<Administrador>() {
      @Override
      public Administrador call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final Administrador _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            _result = new Administrador(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Administrador> getAdministradorByRFC(final String rfc) {
    final String _sql = "SELECT * FROM Administrador WHERE rfc = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (rfc == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, rfc);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Administrador"}, false, new Callable<Administrador>() {
      @Override
      public Administrador call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final Administrador _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            _result = new Administrador(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Chofer>> getChoferes() {
    final String _sql = "SELECT * FROM Chofer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Chofer"}, false, new Callable<List<Chofer>>() {
      @Override
      public List<Chofer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNoUsuarios = CursorUtil.getColumnIndexOrThrow(_cursor, "noUsuarios");
          final int _cursorIndexOfCalificacion = CursorUtil.getColumnIndexOrThrow(_cursor, "calificacion");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Chofer> _result = new ArrayList<Chofer>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Chofer _item;
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            final int _tmpNoUsuarios;
            _tmpNoUsuarios = _cursor.getInt(_cursorIndexOfNoUsuarios);
            final double _tmpCalificacion;
            _tmpCalificacion = _cursor.getDouble(_cursorIndexOfCalificacion);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Chofer(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo,_tmpNoUsuarios,_tmpCalificacion,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Chofer> getChoferByUsuario(final String usuario) {
    final String _sql = "SELECT * FROM Chofer WHERE usuario = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usuario == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuario);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Chofer"}, false, new Callable<Chofer>() {
      @Override
      public Chofer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNoUsuarios = CursorUtil.getColumnIndexOrThrow(_cursor, "noUsuarios");
          final int _cursorIndexOfCalificacion = CursorUtil.getColumnIndexOrThrow(_cursor, "calificacion");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Chofer _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            final int _tmpNoUsuarios;
            _tmpNoUsuarios = _cursor.getInt(_cursorIndexOfNoUsuarios);
            final double _tmpCalificacion;
            _tmpCalificacion = _cursor.getDouble(_cursorIndexOfCalificacion);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Chofer(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo,_tmpNoUsuarios,_tmpCalificacion,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Chofer> getChoferByRFC(final String rfc) {
    final String _sql = "SELECT * FROM Chofer WHERE rfc = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (rfc == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, rfc);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Chofer"}, false, new Callable<Chofer>() {
      @Override
      public Chofer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNoUsuarios = CursorUtil.getColumnIndexOrThrow(_cursor, "noUsuarios");
          final int _cursorIndexOfCalificacion = CursorUtil.getColumnIndexOrThrow(_cursor, "calificacion");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Chofer _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            final int _tmpNoUsuarios;
            _tmpNoUsuarios = _cursor.getInt(_cursorIndexOfNoUsuarios);
            final double _tmpCalificacion;
            _tmpCalificacion = _cursor.getDouble(_cursorIndexOfCalificacion);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Chofer(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo,_tmpNoUsuarios,_tmpCalificacion,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Chofer> getChoferByNombre(final String nombre) {
    final String _sql = "SELECT * FROM Chofer WHERE nombre = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nombre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nombre);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Chofer"}, false, new Callable<Chofer>() {
      @Override
      public Chofer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNoUsuarios = CursorUtil.getColumnIndexOrThrow(_cursor, "noUsuarios");
          final int _cursorIndexOfCalificacion = CursorUtil.getColumnIndexOrThrow(_cursor, "calificacion");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Chofer _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            final int _tmpNoUsuarios;
            _tmpNoUsuarios = _cursor.getInt(_cursorIndexOfNoUsuarios);
            final double _tmpCalificacion;
            _tmpCalificacion = _cursor.getDouble(_cursorIndexOfCalificacion);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Chofer(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo,_tmpNoUsuarios,_tmpCalificacion,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Chofer>> getChoferesByAdministrador(final String administrador) {
    final String _sql = "SELECT * FROM Chofer WHERE administrador = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (administrador == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, administrador);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Chofer"}, false, new Callable<List<Chofer>>() {
      @Override
      public List<Chofer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNoUsuarios = CursorUtil.getColumnIndexOrThrow(_cursor, "noUsuarios");
          final int _cursorIndexOfCalificacion = CursorUtil.getColumnIndexOrThrow(_cursor, "calificacion");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Chofer> _result = new ArrayList<Chofer>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Chofer _item;
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            final int _tmpNoUsuarios;
            _tmpNoUsuarios = _cursor.getInt(_cursorIndexOfNoUsuarios);
            final double _tmpCalificacion;
            _tmpCalificacion = _cursor.getDouble(_cursorIndexOfCalificacion);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Chofer(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo,_tmpNoUsuarios,_tmpCalificacion,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Chofer> getChoferByRFCYAdministrador(final String rfc,
      final String administrador) {
    final String _sql = "SELECT * FROM Chofer WHERE rfc = ? AND administrador = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (rfc == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, rfc);
    }
    _argIndex = 2;
    if (administrador == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, administrador);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Chofer"}, false, new Callable<Chofer>() {
      @Override
      public Chofer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final int _cursorIndexOfRfc = CursorUtil.getColumnIndexOrThrow(_cursor, "rfc");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfNumCelular = CursorUtil.getColumnIndexOrThrow(_cursor, "numero_Celular");
          final int _cursorIndexOfLinea = CursorUtil.getColumnIndexOrThrow(_cursor, "linea_Transporte");
          final int _cursorIndexOfCodigo = CursorUtil.getColumnIndexOrThrow(_cursor, "codigo");
          final int _cursorIndexOfNoUsuarios = CursorUtil.getColumnIndexOrThrow(_cursor, "noUsuarios");
          final int _cursorIndexOfCalificacion = CursorUtil.getColumnIndexOrThrow(_cursor, "calificacion");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Chofer _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            final String _tmpRfc;
            if (_cursor.isNull(_cursorIndexOfRfc)) {
              _tmpRfc = null;
            } else {
              _tmpRfc = _cursor.getString(_cursorIndexOfRfc);
            }
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final long _tmpNumCelular;
            _tmpNumCelular = _cursor.getLong(_cursorIndexOfNumCelular);
            final String _tmpLinea;
            if (_cursor.isNull(_cursorIndexOfLinea)) {
              _tmpLinea = null;
            } else {
              _tmpLinea = _cursor.getString(_cursorIndexOfLinea);
            }
            final long _tmpCodigo;
            _tmpCodigo = _cursor.getLong(_cursorIndexOfCodigo);
            final int _tmpNoUsuarios;
            _tmpNoUsuarios = _cursor.getInt(_cursorIndexOfNoUsuarios);
            final double _tmpCalificacion;
            _tmpCalificacion = _cursor.getDouble(_cursorIndexOfCalificacion);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Chofer(_tmpUsuario,_tmpRfc,_tmpNombre,_tmpNumCelular,_tmpLinea,_tmpCodigo,_tmpNoUsuarios,_tmpCalificacion,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<PublicoGeneral>> getPublicosGenerales() {
    final String _sql = "SELECT * FROM PublicoGeneral";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"PublicoGeneral"}, false, new Callable<List<PublicoGeneral>>() {
      @Override
      public List<PublicoGeneral> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final List<PublicoGeneral> _result = new ArrayList<PublicoGeneral>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PublicoGeneral _item;
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            _item = new PublicoGeneral(_tmpUsuario);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<PublicoGeneral> getPublicoGeneralByUsuario(final String usuario) {
    final String _sql = "SELECT * FROM PublicoGeneral WHERE usuario = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usuario == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuario);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"PublicoGeneral"}, false, new Callable<PublicoGeneral>() {
      @Override
      public PublicoGeneral call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final PublicoGeneral _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            _result = new PublicoGeneral(_tmpUsuario);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Ruta>> getRutas() {
    final String _sql = "SELECT * FROM Ruta";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Ruta"}, false, new Callable<List<Ruta>>() {
      @Override
      public List<Ruta> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Ruta> _result = new ArrayList<Ruta>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Ruta _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Ruta(_tmpId,_tmpNombre,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Ruta> getRutaById(final int id) {
    final String _sql = "SELECT * FROM Ruta WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Ruta"}, false, new Callable<Ruta>() {
      @Override
      public Ruta call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Ruta _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Ruta(_tmpId,_tmpNombre,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Ruta> getRutaByNombre(final String nombre) {
    final String _sql = "SELECT * FROM Ruta WHERE nombre = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nombre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nombre);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Ruta"}, false, new Callable<Ruta>() {
      @Override
      public Ruta call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Ruta _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Ruta(_tmpId,_tmpNombre,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Ruta>> getRutasByAdministrador(final String administrador) {
    final String _sql = "SELECT * FROM Ruta WHERE administrador = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (administrador == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, administrador);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Ruta"}, false, new Callable<List<Ruta>>() {
      @Override
      public List<Ruta> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Ruta> _result = new ArrayList<Ruta>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Ruta _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Ruta(_tmpId,_tmpNombre,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Parada>> getParadas() {
    final String _sql = "SELECT * FROM Parada";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Parada"}, false, new Callable<List<Parada>>() {
      @Override
      public List<Parada> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "longitud");
          final int _cursorIndexOfLatitud = CursorUtil.getColumnIndexOrThrow(_cursor, "latitud");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Parada> _result = new ArrayList<Parada>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Parada _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final double _tmpLongitud;
            _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            final double _tmpLatitud;
            _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Parada(_tmpId,_tmpNombre,_tmpLongitud,_tmpLatitud,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Parada> getParadaById(final int id) {
    final String _sql = "SELECT * FROM Parada WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Parada"}, false, new Callable<Parada>() {
      @Override
      public Parada call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "longitud");
          final int _cursorIndexOfLatitud = CursorUtil.getColumnIndexOrThrow(_cursor, "latitud");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Parada _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final double _tmpLongitud;
            _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            final double _tmpLatitud;
            _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Parada(_tmpId,_tmpNombre,_tmpLongitud,_tmpLatitud,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Parada> getParadaByNombre(final String nombre) {
    final String _sql = "SELECT * FROM Parada WHERE nombre = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nombre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nombre);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Parada"}, false, new Callable<Parada>() {
      @Override
      public Parada call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "longitud");
          final int _cursorIndexOfLatitud = CursorUtil.getColumnIndexOrThrow(_cursor, "latitud");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Parada _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final double _tmpLongitud;
            _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            final double _tmpLatitud;
            _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Parada(_tmpId,_tmpNombre,_tmpLongitud,_tmpLatitud,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Parada>> getParadasByAdministrador(final String administrador) {
    final String _sql = "SELECT * FROM Parada WHERE administrador = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (administrador == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, administrador);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Parada"}, false, new Callable<List<Parada>>() {
      @Override
      public List<Parada> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "longitud");
          final int _cursorIndexOfLatitud = CursorUtil.getColumnIndexOrThrow(_cursor, "latitud");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Parada> _result = new ArrayList<Parada>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Parada _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final double _tmpLongitud;
            _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            final double _tmpLatitud;
            _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Parada(_tmpId,_tmpNombre,_tmpLongitud,_tmpLatitud,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Unidad>> getUnidades() {
    final String _sql = "SELECT * FROM Unidad";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Unidad"}, false, new Callable<List<Unidad>>() {
      @Override
      public List<Unidad> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPlaca = CursorUtil.getColumnIndexOrThrow(_cursor, "placa");
          final int _cursorIndexOfMarca = CursorUtil.getColumnIndexOrThrow(_cursor, "marca");
          final int _cursorIndexOfModelo = CursorUtil.getColumnIndexOrThrow(_cursor, "modelo");
          final int _cursorIndexOfNumero = CursorUtil.getColumnIndexOrThrow(_cursor, "numero");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final List<Unidad> _result = new ArrayList<Unidad>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Unidad _item;
            final String _tmpPlaca;
            if (_cursor.isNull(_cursorIndexOfPlaca)) {
              _tmpPlaca = null;
            } else {
              _tmpPlaca = _cursor.getString(_cursorIndexOfPlaca);
            }
            final String _tmpMarca;
            if (_cursor.isNull(_cursorIndexOfMarca)) {
              _tmpMarca = null;
            } else {
              _tmpMarca = _cursor.getString(_cursorIndexOfMarca);
            }
            final String _tmpModelo;
            if (_cursor.isNull(_cursorIndexOfModelo)) {
              _tmpModelo = null;
            } else {
              _tmpModelo = _cursor.getString(_cursorIndexOfModelo);
            }
            final int _tmpNumero;
            _tmpNumero = _cursor.getInt(_cursorIndexOfNumero);
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final String _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getString(_cursorIndexOfFecha);
            }
            _item = new Unidad(_tmpPlaca,_tmpMarca,_tmpModelo,_tmpNumero,_tmpHora,_tmpFecha);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Unidad> getUnidadByPlaca(final String placa) {
    final String _sql = "SELECT * FROM Unidad WHERE placa = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (placa == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, placa);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Unidad"}, false, new Callable<Unidad>() {
      @Override
      public Unidad call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPlaca = CursorUtil.getColumnIndexOrThrow(_cursor, "placa");
          final int _cursorIndexOfMarca = CursorUtil.getColumnIndexOrThrow(_cursor, "marca");
          final int _cursorIndexOfModelo = CursorUtil.getColumnIndexOrThrow(_cursor, "modelo");
          final int _cursorIndexOfNumero = CursorUtil.getColumnIndexOrThrow(_cursor, "numero");
          final int _cursorIndexOfHora = CursorUtil.getColumnIndexOrThrow(_cursor, "hora");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final Unidad _result;
          if(_cursor.moveToFirst()) {
            final String _tmpPlaca;
            if (_cursor.isNull(_cursorIndexOfPlaca)) {
              _tmpPlaca = null;
            } else {
              _tmpPlaca = _cursor.getString(_cursorIndexOfPlaca);
            }
            final String _tmpMarca;
            if (_cursor.isNull(_cursorIndexOfMarca)) {
              _tmpMarca = null;
            } else {
              _tmpMarca = _cursor.getString(_cursorIndexOfMarca);
            }
            final String _tmpModelo;
            if (_cursor.isNull(_cursorIndexOfModelo)) {
              _tmpModelo = null;
            } else {
              _tmpModelo = _cursor.getString(_cursorIndexOfModelo);
            }
            final int _tmpNumero;
            _tmpNumero = _cursor.getInt(_cursorIndexOfNumero);
            final String _tmpHora;
            if (_cursor.isNull(_cursorIndexOfHora)) {
              _tmpHora = null;
            } else {
              _tmpHora = _cursor.getString(_cursorIndexOfHora);
            }
            final String _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getString(_cursorIndexOfFecha);
            }
            _result = new Unidad(_tmpPlaca,_tmpMarca,_tmpModelo,_tmpNumero,_tmpHora,_tmpFecha);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Tarifa>> getTarifas() {
    final String _sql = "SELECT * FROM Tarifa";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Tarifa"}, false, new Callable<List<Tarifa>>() {
      @Override
      public List<Tarifa> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Tarifa> _result = new ArrayList<Tarifa>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Tarifa _item;
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Tarifa(_tmpNombre,_tmpPrecio,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Tarifa> getTarifaByNombre(final String nombre) {
    final String _sql = "SELECT * FROM Tarifa WHERE nombre = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nombre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nombre);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Tarifa"}, false, new Callable<Tarifa>() {
      @Override
      public Tarifa call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Tarifa _result;
          if(_cursor.moveToFirst()) {
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Tarifa(_tmpNombre,_tmpPrecio,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Tarifa>> getTarifasByAdministrador(final String administrador) {
    final String _sql = "SELECT * FROM Tarifa WHERE administrador = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (administrador == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, administrador);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Tarifa"}, false, new Callable<List<Tarifa>>() {
      @Override
      public List<Tarifa> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfPrecio = CursorUtil.getColumnIndexOrThrow(_cursor, "precio");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Tarifa> _result = new ArrayList<Tarifa>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Tarifa _item;
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final double _tmpPrecio;
            _tmpPrecio = _cursor.getDouble(_cursorIndexOfPrecio);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Tarifa(_tmpNombre,_tmpPrecio,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Horario>> getHorarios() {
    final String _sql = "SELECT * FROM Horario";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Horario"}, false, new Callable<List<Horario>>() {
      @Override
      public List<Horario> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfHoraEntrada = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_Entrada");
          final int _cursorIndexOfHoraSalida = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_Salida");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final List<Horario> _result = new ArrayList<Horario>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Horario _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpHoraEntrada;
            if (_cursor.isNull(_cursorIndexOfHoraEntrada)) {
              _tmpHoraEntrada = null;
            } else {
              _tmpHoraEntrada = _cursor.getString(_cursorIndexOfHoraEntrada);
            }
            final String _tmpHoraSalida;
            if (_cursor.isNull(_cursorIndexOfHoraSalida)) {
              _tmpHoraSalida = null;
            } else {
              _tmpHoraSalida = _cursor.getString(_cursorIndexOfHoraSalida);
            }
            final String _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getString(_cursorIndexOfFecha);
            }
            _item = new Horario(_tmpId,_tmpHoraEntrada,_tmpHoraSalida,_tmpFecha);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Horario> getHorarioById(final int id) {
    final String _sql = "SELECT * FROM Horario WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Horario"}, false, new Callable<Horario>() {
      @Override
      public Horario call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfHoraEntrada = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_Entrada");
          final int _cursorIndexOfHoraSalida = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_Salida");
          final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
          final Horario _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpHoraEntrada;
            if (_cursor.isNull(_cursorIndexOfHoraEntrada)) {
              _tmpHoraEntrada = null;
            } else {
              _tmpHoraEntrada = _cursor.getString(_cursorIndexOfHoraEntrada);
            }
            final String _tmpHoraSalida;
            if (_cursor.isNull(_cursorIndexOfHoraSalida)) {
              _tmpHoraSalida = null;
            } else {
              _tmpHoraSalida = _cursor.getString(_cursorIndexOfHoraSalida);
            }
            final String _tmpFecha;
            if (_cursor.isNull(_cursorIndexOfFecha)) {
              _tmpFecha = null;
            } else {
              _tmpFecha = _cursor.getString(_cursorIndexOfFecha);
            }
            _result = new Horario(_tmpId,_tmpHoraEntrada,_tmpHoraSalida,_tmpFecha);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Coordenada>> getCoordenadas() {
    final String _sql = "SELECT * FROM Coordenada";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Coordenada"}, false, new Callable<List<Coordenada>>() {
      @Override
      public List<Coordenada> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "longitud");
          final int _cursorIndexOfLatitud = CursorUtil.getColumnIndexOrThrow(_cursor, "latitud");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Coordenada> _result = new ArrayList<Coordenada>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Coordenada _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final double _tmpLongitud;
            _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            final double _tmpLatitud;
            _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Coordenada(_tmpId,_tmpLongitud,_tmpLatitud,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Coordenada> getCoordenadaById(final int id) {
    final String _sql = "SELECT * FROM Coordenada WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Coordenada"}, false, new Callable<Coordenada>() {
      @Override
      public Coordenada call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "longitud");
          final int _cursorIndexOfLatitud = CursorUtil.getColumnIndexOrThrow(_cursor, "latitud");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final Coordenada _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final double _tmpLongitud;
            _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            final double _tmpLatitud;
            _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _result = new Coordenada(_tmpId,_tmpLongitud,_tmpLatitud,_tmpAdministrador);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Coordenada>> getCoordenadasByAdministrador(final String administrador) {
    final String _sql = "SELECT * FROM Coordenada WHERE administrador = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (administrador == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, administrador);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Coordenada"}, false, new Callable<List<Coordenada>>() {
      @Override
      public List<Coordenada> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "longitud");
          final int _cursorIndexOfLatitud = CursorUtil.getColumnIndexOrThrow(_cursor, "latitud");
          final int _cursorIndexOfAdministrador = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador");
          final List<Coordenada> _result = new ArrayList<Coordenada>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Coordenada _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final double _tmpLongitud;
            _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            final double _tmpLatitud;
            _tmpLatitud = _cursor.getDouble(_cursorIndexOfLatitud);
            final String _tmpAdministrador;
            if (_cursor.isNull(_cursorIndexOfAdministrador)) {
              _tmpAdministrador = null;
            } else {
              _tmpAdministrador = _cursor.getString(_cursorIndexOfAdministrador);
            }
            _item = new Coordenada(_tmpId,_tmpLongitud,_tmpLatitud,_tmpAdministrador);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<QuejaSugerencia>> getSugerenciasQuejas() {
    final String _sql = "SELECT * FROM SugerenciaQueja";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"SugerenciaQueja"}, false, new Callable<List<QuejaSugerencia>>() {
      @Override
      public List<QuejaSugerencia> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final List<QuejaSugerencia> _result = new ArrayList<QuejaSugerencia>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final QuejaSugerencia _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDescripcion;
            if (_cursor.isNull(_cursorIndexOfDescripcion)) {
              _tmpDescripcion = null;
            } else {
              _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
            }
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            _item = new QuejaSugerencia(_tmpId,_tmpDescripcion,_tmpUsuario);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<QuejaSugerencia> getSugerenciasQuejasById(final int id) {
    final String _sql = "SELECT * FROM SugerenciaQueja WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"SugerenciaQueja"}, false, new Callable<QuejaSugerencia>() {
      @Override
      public QuejaSugerencia call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
          final int _cursorIndexOfUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "usuario");
          final QuejaSugerencia _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDescripcion;
            if (_cursor.isNull(_cursorIndexOfDescripcion)) {
              _tmpDescripcion = null;
            } else {
              _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
            }
            final String _tmpUsuario;
            if (_cursor.isNull(_cursorIndexOfUsuario)) {
              _tmpUsuario = null;
            } else {
              _tmpUsuario = _cursor.getString(_cursorIndexOfUsuario);
            }
            _result = new QuejaSugerencia(_tmpId,_tmpDescripcion,_tmpUsuario);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<CuentaAdministrador>> getCuentasAdministrador() {
    final String _sql = "SELECT * FROM CuentaAdministrador";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaAdministrador"}, false, new Callable<List<CuentaAdministrador>>() {
      @Override
      public List<CuentaAdministrador> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfAdminUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador_Usuario");
          final List<CuentaAdministrador> _result = new ArrayList<CuentaAdministrador>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CuentaAdministrador _item;
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpAdminUsuario;
            if (_cursor.isNull(_cursorIndexOfAdminUsuario)) {
              _tmpAdminUsuario = null;
            } else {
              _tmpAdminUsuario = _cursor.getString(_cursorIndexOfAdminUsuario);
            }
            _item = new CuentaAdministrador(_tmpCuentaCorreo,_tmpAdminUsuario);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<CuentaAdministrador> getCuentaAdministradorByUsuario(final String usuario) {
    final String _sql = "SELECT * FROM CuentaAdministrador WHERE administrador_Usuario = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usuario == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuario);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaAdministrador"}, false, new Callable<CuentaAdministrador>() {
      @Override
      public CuentaAdministrador call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfAdminUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador_Usuario");
          final CuentaAdministrador _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpAdminUsuario;
            if (_cursor.isNull(_cursorIndexOfAdminUsuario)) {
              _tmpAdminUsuario = null;
            } else {
              _tmpAdminUsuario = _cursor.getString(_cursorIndexOfAdminUsuario);
            }
            _result = new CuentaAdministrador(_tmpCuentaCorreo,_tmpAdminUsuario);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<CuentaAdministrador> getCuentaAdministradorByCorreo(final String correo) {
    final String _sql = "SELECT * FROM CuentaAdministrador WHERE cuenta_Correo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (correo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, correo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaAdministrador"}, false, new Callable<CuentaAdministrador>() {
      @Override
      public CuentaAdministrador call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfAdminUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "administrador_Usuario");
          final CuentaAdministrador _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpAdminUsuario;
            if (_cursor.isNull(_cursorIndexOfAdminUsuario)) {
              _tmpAdminUsuario = null;
            } else {
              _tmpAdminUsuario = _cursor.getString(_cursorIndexOfAdminUsuario);
            }
            _result = new CuentaAdministrador(_tmpCuentaCorreo,_tmpAdminUsuario);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Cuenta> getCuentaByAdministradorUsuarioOCuentaCorreo(
      final String usuarioOCorreo) {
    final String _sql = "SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaAdministrador WHERE administrador_Usuario = ? OR cuenta_Correo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (usuarioOCorreo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuarioOCorreo);
    }
    _argIndex = 2;
    if (usuarioOCorreo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuarioOCorreo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Cuenta","CuentaAdministrador"}, false, new Callable<Cuenta>() {
      @Override
      public Cuenta call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCorreo = 0;
          final int _cursorIndexOfContrasenia = 1;
          final int _cursorIndexOfFoto = 2;
          final int _cursorIndexOfTipo = 3;
          final int _cursorIndexOfMetodo = 4;
          final int _cursorIndexOfEstado = 5;
          final Cuenta _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCorreo;
            if (_cursor.isNull(_cursorIndexOfCorreo)) {
              _tmpCorreo = null;
            } else {
              _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
            }
            final String _tmpContrasenia;
            if (_cursor.isNull(_cursorIndexOfContrasenia)) {
              _tmpContrasenia = null;
            } else {
              _tmpContrasenia = _cursor.getString(_cursorIndexOfContrasenia);
            }
            final String _tmpFoto;
            if (_cursor.isNull(_cursorIndexOfFoto)) {
              _tmpFoto = null;
            } else {
              _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
            }
            final int _tmpTipo;
            _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
            final String _tmpMetodo;
            if (_cursor.isNull(_cursorIndexOfMetodo)) {
              _tmpMetodo = null;
            } else {
              _tmpMetodo = _cursor.getString(_cursorIndexOfMetodo);
            }
            final boolean _tmpEstado;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfEstado);
            _tmpEstado = _tmp != 0;
            _result = new Cuenta(_tmpCorreo,_tmpContrasenia,_tmpFoto,_tmpTipo,_tmpMetodo,_tmpEstado);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<CuentaChofer>> getCuentasChofer() {
    final String _sql = "SELECT * FROM CuentaChofer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaChofer"}, false, new Callable<List<CuentaChofer>>() {
      @Override
      public List<CuentaChofer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfChoferUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "chofer_Usuario");
          final List<CuentaChofer> _result = new ArrayList<CuentaChofer>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CuentaChofer _item;
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpChoferUsuario;
            if (_cursor.isNull(_cursorIndexOfChoferUsuario)) {
              _tmpChoferUsuario = null;
            } else {
              _tmpChoferUsuario = _cursor.getString(_cursorIndexOfChoferUsuario);
            }
            _item = new CuentaChofer(_tmpCuentaCorreo,_tmpChoferUsuario);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<CuentaChofer> getCuentaChoferByUsuario(final String usuario) {
    final String _sql = "SELECT * FROM CuentaChofer WHERE chofer_Usuario = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usuario == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuario);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaChofer"}, false, new Callable<CuentaChofer>() {
      @Override
      public CuentaChofer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfChoferUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "chofer_Usuario");
          final CuentaChofer _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpChoferUsuario;
            if (_cursor.isNull(_cursorIndexOfChoferUsuario)) {
              _tmpChoferUsuario = null;
            } else {
              _tmpChoferUsuario = _cursor.getString(_cursorIndexOfChoferUsuario);
            }
            _result = new CuentaChofer(_tmpCuentaCorreo,_tmpChoferUsuario);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<CuentaChofer> getCuentaChoferByCorreo(final String correo) {
    final String _sql = "SELECT * FROM CuentaChofer WHERE cuenta_Correo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (correo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, correo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaChofer"}, false, new Callable<CuentaChofer>() {
      @Override
      public CuentaChofer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfChoferUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "chofer_Usuario");
          final CuentaChofer _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpChoferUsuario;
            if (_cursor.isNull(_cursorIndexOfChoferUsuario)) {
              _tmpChoferUsuario = null;
            } else {
              _tmpChoferUsuario = _cursor.getString(_cursorIndexOfChoferUsuario);
            }
            _result = new CuentaChofer(_tmpCuentaCorreo,_tmpChoferUsuario);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Cuenta> getCuentaByChoferUsuarioOCuentaCorreo(final String usuarioOCorreo) {
    final String _sql = "SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaChofer WHERE chofer_Usuario = ? OR cuenta_Correo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (usuarioOCorreo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuarioOCorreo);
    }
    _argIndex = 2;
    if (usuarioOCorreo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuarioOCorreo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Cuenta","CuentaChofer"}, false, new Callable<Cuenta>() {
      @Override
      public Cuenta call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCorreo = 0;
          final int _cursorIndexOfContrasenia = 1;
          final int _cursorIndexOfFoto = 2;
          final int _cursorIndexOfTipo = 3;
          final int _cursorIndexOfMetodo = 4;
          final int _cursorIndexOfEstado = 5;
          final Cuenta _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCorreo;
            if (_cursor.isNull(_cursorIndexOfCorreo)) {
              _tmpCorreo = null;
            } else {
              _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
            }
            final String _tmpContrasenia;
            if (_cursor.isNull(_cursorIndexOfContrasenia)) {
              _tmpContrasenia = null;
            } else {
              _tmpContrasenia = _cursor.getString(_cursorIndexOfContrasenia);
            }
            final String _tmpFoto;
            if (_cursor.isNull(_cursorIndexOfFoto)) {
              _tmpFoto = null;
            } else {
              _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
            }
            final int _tmpTipo;
            _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
            final String _tmpMetodo;
            if (_cursor.isNull(_cursorIndexOfMetodo)) {
              _tmpMetodo = null;
            } else {
              _tmpMetodo = _cursor.getString(_cursorIndexOfMetodo);
            }
            final boolean _tmpEstado;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfEstado);
            _tmpEstado = _tmp != 0;
            _result = new Cuenta(_tmpCorreo,_tmpContrasenia,_tmpFoto,_tmpTipo,_tmpMetodo,_tmpEstado);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<CuentaPublico>> getCuentasPublico() {
    final String _sql = "SELECT * FROM CuentaPublico";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaPublico"}, false, new Callable<List<CuentaPublico>>() {
      @Override
      public List<CuentaPublico> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfPublicoUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "publico_General_Usuario");
          final List<CuentaPublico> _result = new ArrayList<CuentaPublico>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CuentaPublico _item;
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpPublicoUsuario;
            if (_cursor.isNull(_cursorIndexOfPublicoUsuario)) {
              _tmpPublicoUsuario = null;
            } else {
              _tmpPublicoUsuario = _cursor.getString(_cursorIndexOfPublicoUsuario);
            }
            _item = new CuentaPublico(_tmpCuentaCorreo,_tmpPublicoUsuario);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<CuentaPublico> getCuentaPublicoByUsuario(final String usuario) {
    final String _sql = "SELECT * FROM CuentaPublico WHERE publico_General_Usuario = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (usuario == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuario);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaPublico"}, false, new Callable<CuentaPublico>() {
      @Override
      public CuentaPublico call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfPublicoUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "publico_General_Usuario");
          final CuentaPublico _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpPublicoUsuario;
            if (_cursor.isNull(_cursorIndexOfPublicoUsuario)) {
              _tmpPublicoUsuario = null;
            } else {
              _tmpPublicoUsuario = _cursor.getString(_cursorIndexOfPublicoUsuario);
            }
            _result = new CuentaPublico(_tmpCuentaCorreo,_tmpPublicoUsuario);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<CuentaPublico> getCuentaPublicoByCorreo(final String correo) {
    final String _sql = "SELECT * FROM CuentaPublico WHERE cuenta_Correo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (correo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, correo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"CuentaPublico"}, false, new Callable<CuentaPublico>() {
      @Override
      public CuentaPublico call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCuentaCorreo = CursorUtil.getColumnIndexOrThrow(_cursor, "cuenta_Correo");
          final int _cursorIndexOfPublicoUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "publico_General_Usuario");
          final CuentaPublico _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCuentaCorreo;
            if (_cursor.isNull(_cursorIndexOfCuentaCorreo)) {
              _tmpCuentaCorreo = null;
            } else {
              _tmpCuentaCorreo = _cursor.getString(_cursorIndexOfCuentaCorreo);
            }
            final String _tmpPublicoUsuario;
            if (_cursor.isNull(_cursorIndexOfPublicoUsuario)) {
              _tmpPublicoUsuario = null;
            } else {
              _tmpPublicoUsuario = _cursor.getString(_cursorIndexOfPublicoUsuario);
            }
            _result = new CuentaPublico(_tmpCuentaCorreo,_tmpPublicoUsuario);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Cuenta> getCuentaByPublicoUsuarioOCuentaCorreo(final String usuarioOCorreo) {
    final String _sql = "SELECT correo, contrasenia, foto, tipo, metodo, estado FROM Cuenta INNER JOIN CuentaPublico WHERE publico_General_Usuario = ? OR cuenta_Correo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (usuarioOCorreo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuarioOCorreo);
    }
    _argIndex = 2;
    if (usuarioOCorreo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, usuarioOCorreo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Cuenta","CuentaPublico"}, false, new Callable<Cuenta>() {
      @Override
      public Cuenta call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCorreo = 0;
          final int _cursorIndexOfContrasenia = 1;
          final int _cursorIndexOfFoto = 2;
          final int _cursorIndexOfTipo = 3;
          final int _cursorIndexOfMetodo = 4;
          final int _cursorIndexOfEstado = 5;
          final Cuenta _result;
          if(_cursor.moveToFirst()) {
            final String _tmpCorreo;
            if (_cursor.isNull(_cursorIndexOfCorreo)) {
              _tmpCorreo = null;
            } else {
              _tmpCorreo = _cursor.getString(_cursorIndexOfCorreo);
            }
            final String _tmpContrasenia;
            if (_cursor.isNull(_cursorIndexOfContrasenia)) {
              _tmpContrasenia = null;
            } else {
              _tmpContrasenia = _cursor.getString(_cursorIndexOfContrasenia);
            }
            final String _tmpFoto;
            if (_cursor.isNull(_cursorIndexOfFoto)) {
              _tmpFoto = null;
            } else {
              _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
            }
            final int _tmpTipo;
            _tmpTipo = _cursor.getInt(_cursorIndexOfTipo);
            final String _tmpMetodo;
            if (_cursor.isNull(_cursorIndexOfMetodo)) {
              _tmpMetodo = null;
            } else {
              _tmpMetodo = _cursor.getString(_cursorIndexOfMetodo);
            }
            final boolean _tmpEstado;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfEstado);
            _tmpEstado = _tmp != 0;
            _result = new Cuenta(_tmpCorreo,_tmpContrasenia,_tmpFoto,_tmpTipo,_tmpMetodo,_tmpEstado);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<RutaCoordenada>> getRutaCoordenadas() {
    final String _sql = "SELECT * FROM RutaCoordenada";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"RutaCoordenada"}, false, new Callable<List<RutaCoordenada>>() {
      @Override
      public List<RutaCoordenada> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRutaID = CursorUtil.getColumnIndexOrThrow(_cursor, "ruta_ID");
          final int _cursorIndexOfCoordenadaID = CursorUtil.getColumnIndexOrThrow(_cursor, "coordenada_ID");
          final List<RutaCoordenada> _result = new ArrayList<RutaCoordenada>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RutaCoordenada _item;
            final int _tmpRutaID;
            _tmpRutaID = _cursor.getInt(_cursorIndexOfRutaID);
            final int _tmpCoordenadaID;
            _tmpCoordenadaID = _cursor.getInt(_cursorIndexOfCoordenadaID);
            _item = new RutaCoordenada(_tmpRutaID,_tmpCoordenadaID);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<RutaCoordenada>> getCoordenadasIDByRutaID(final int rutaID) {
    final String _sql = "SELECT * FROM RutaCoordenada WHERE ruta_ID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, rutaID);
    return __db.getInvalidationTracker().createLiveData(new String[]{"RutaCoordenada"}, false, new Callable<List<RutaCoordenada>>() {
      @Override
      public List<RutaCoordenada> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRutaID = CursorUtil.getColumnIndexOrThrow(_cursor, "ruta_ID");
          final int _cursorIndexOfCoordenadaID = CursorUtil.getColumnIndexOrThrow(_cursor, "coordenada_ID");
          final List<RutaCoordenada> _result = new ArrayList<RutaCoordenada>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RutaCoordenada _item;
            final int _tmpRutaID;
            _tmpRutaID = _cursor.getInt(_cursorIndexOfRutaID);
            final int _tmpCoordenadaID;
            _tmpCoordenadaID = _cursor.getInt(_cursorIndexOfCoordenadaID);
            _item = new RutaCoordenada(_tmpRutaID,_tmpCoordenadaID);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<RutaCoordenada> getRutaCoordenadaByRutaID(final int rutaID) {
    final String _sql = "SELECT * FROM RutaCoordenada WHERE ruta_ID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, rutaID);
    return __db.getInvalidationTracker().createLiveData(new String[]{"RutaCoordenada"}, false, new Callable<RutaCoordenada>() {
      @Override
      public RutaCoordenada call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRutaID = CursorUtil.getColumnIndexOrThrow(_cursor, "ruta_ID");
          final int _cursorIndexOfCoordenadaID = CursorUtil.getColumnIndexOrThrow(_cursor, "coordenada_ID");
          final RutaCoordenada _result;
          if(_cursor.moveToFirst()) {
            final int _tmpRutaID;
            _tmpRutaID = _cursor.getInt(_cursorIndexOfRutaID);
            final int _tmpCoordenadaID;
            _tmpCoordenadaID = _cursor.getInt(_cursorIndexOfCoordenadaID);
            _result = new RutaCoordenada(_tmpRutaID,_tmpCoordenadaID);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<RutaParada>> getRutaParadas() {
    final String _sql = "SELECT * FROM RutaParada";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"RutaParada"}, false, new Callable<List<RutaParada>>() {
      @Override
      public List<RutaParada> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRutaID = CursorUtil.getColumnIndexOrThrow(_cursor, "ruta_ID");
          final int _cursorIndexOfParadaID = CursorUtil.getColumnIndexOrThrow(_cursor, "parada_ID");
          final List<RutaParada> _result = new ArrayList<RutaParada>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RutaParada _item;
            final int _tmpRutaID;
            _tmpRutaID = _cursor.getInt(_cursorIndexOfRutaID);
            final int _tmpParadaID;
            _tmpParadaID = _cursor.getInt(_cursorIndexOfParadaID);
            _item = new RutaParada(_tmpRutaID,_tmpParadaID);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<RutaParada> getRutaIDByParadaID(final int paradaID) {
    final String _sql = "SELECT * FROM RutaParada WHERE parada_ID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, paradaID);
    return __db.getInvalidationTracker().createLiveData(new String[]{"RutaParada"}, false, new Callable<RutaParada>() {
      @Override
      public RutaParada call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRutaID = CursorUtil.getColumnIndexOrThrow(_cursor, "ruta_ID");
          final int _cursorIndexOfParadaID = CursorUtil.getColumnIndexOrThrow(_cursor, "parada_ID");
          final RutaParada _result;
          if(_cursor.moveToFirst()) {
            final int _tmpRutaID;
            _tmpRutaID = _cursor.getInt(_cursorIndexOfRutaID);
            final int _tmpParadaID;
            _tmpParadaID = _cursor.getInt(_cursorIndexOfParadaID);
            _result = new RutaParada(_tmpRutaID,_tmpParadaID);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<UnidadCoordenada>> getUnidadesCoordenadas() {
    final String _sql = "SELECT * FROM UnidadCoordenada";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"UnidadCoordenada"}, false, new Callable<List<UnidadCoordenada>>() {
      @Override
      public List<UnidadCoordenada> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUnidadPlaca = CursorUtil.getColumnIndexOrThrow(_cursor, "unidad_Placa");
          final int _cursorIndexOfCoordenadaID = CursorUtil.getColumnIndexOrThrow(_cursor, "coordenada_ID");
          final List<UnidadCoordenada> _result = new ArrayList<UnidadCoordenada>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UnidadCoordenada _item;
            final String _tmpUnidadPlaca;
            if (_cursor.isNull(_cursorIndexOfUnidadPlaca)) {
              _tmpUnidadPlaca = null;
            } else {
              _tmpUnidadPlaca = _cursor.getString(_cursorIndexOfUnidadPlaca);
            }
            final int _tmpCoordenadaID;
            _tmpCoordenadaID = _cursor.getInt(_cursorIndexOfCoordenadaID);
            _item = new UnidadCoordenada(_tmpUnidadPlaca,_tmpCoordenadaID);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<HorarioCUR>> getHorarioCURs() {
    final String _sql = "SELECT * FROM HorarioChoferUnidadRuta";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"HorarioChoferUnidadRuta"}, false, new Callable<List<HorarioCUR>>() {
      @Override
      public List<HorarioCUR> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHorarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "horario_ID");
          final int _cursorIndexOfChoferUsuario = CursorUtil.getColumnIndexOrThrow(_cursor, "chofer_Usuario");
          final int _cursorIndexOfUnidadPlaca = CursorUtil.getColumnIndexOrThrow(_cursor, "unidad_Placa");
          final int _cursorIndexOfRutaIdaId = CursorUtil.getColumnIndexOrThrow(_cursor, "ruta_Ida_ID");
          final int _cursorIndexOfRutaVenidaId = CursorUtil.getColumnIndexOrThrow(_cursor, "ruta_Venida_ID");
          final List<HorarioCUR> _result = new ArrayList<HorarioCUR>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final HorarioCUR _item;
            final int _tmpHorarioId;
            _tmpHorarioId = _cursor.getInt(_cursorIndexOfHorarioId);
            final String _tmpChoferUsuario;
            if (_cursor.isNull(_cursorIndexOfChoferUsuario)) {
              _tmpChoferUsuario = null;
            } else {
              _tmpChoferUsuario = _cursor.getString(_cursorIndexOfChoferUsuario);
            }
            final String _tmpUnidadPlaca;
            if (_cursor.isNull(_cursorIndexOfUnidadPlaca)) {
              _tmpUnidadPlaca = null;
            } else {
              _tmpUnidadPlaca = _cursor.getString(_cursorIndexOfUnidadPlaca);
            }
            final int _tmpRutaIdaId;
            _tmpRutaIdaId = _cursor.getInt(_cursorIndexOfRutaIdaId);
            final int _tmpRutaVenidaId;
            _tmpRutaVenidaId = _cursor.getInt(_cursorIndexOfRutaVenidaId);
            _item = new HorarioCUR(_tmpHorarioId,_tmpChoferUsuario,_tmpUnidadPlaca,_tmpRutaIdaId,_tmpRutaVenidaId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
