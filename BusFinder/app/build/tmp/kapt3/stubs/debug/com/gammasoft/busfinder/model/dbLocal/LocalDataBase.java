package com.gammasoft.busfinder.model.dbLocal;

import java.lang.System;

@androidx.room.Database(entities = {com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta.class, com.gammasoft.busfinder.model.dbLocal.entidades.Administrador.class, com.gammasoft.busfinder.model.dbLocal.entidades.Chofer.class, com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral.class, com.gammasoft.busfinder.model.dbLocal.entidades.Ruta.class, com.gammasoft.busfinder.model.dbLocal.entidades.Parada.class, com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada.class, com.gammasoft.busfinder.model.dbLocal.entidades.Unidad.class, com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa.class, com.gammasoft.busfinder.model.dbLocal.entidades.Horario.class, com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia.class, com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador.class, com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer.class, com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico.class, com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada.class, com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada.class, com.gammasoft.busfinder.model.dbLocal.relaciones.UnidadCoordenada.class, com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR.class}, version = 4, exportSchema = false)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/LocalDataBase;", "Landroidx/room/RoomDatabase;", "()V", "crud", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "Companion", "app_debug"})
public abstract class LocalDataBase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.model.dbLocal.LocalDataBase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.gammasoft.busfinder.model.dbLocal.LocalDataBase INSTANCE;
    
    public LocalDataBase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gammasoft.busfinder.model.dbLocal.Crud crud();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/LocalDataBase$Companion;", "", "()V", "INSTANCE", "Lcom/gammasoft/busfinder/model/dbLocal/LocalDataBase;", "getDB", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.model.dbLocal.LocalDataBase getDB(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}