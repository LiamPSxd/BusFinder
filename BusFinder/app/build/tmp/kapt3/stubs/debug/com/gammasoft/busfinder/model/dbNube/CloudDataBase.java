package com.gammasoft.busfinder.model.dbNube;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/gammasoft/busfinder/model/dbNube/CloudDataBase;", "", "()V", "Companion", "app_debug"})
public abstract class CloudDataBase {
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.model.dbNube.CloudDataBase.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    private static final com.google.firebase.firestore.FirebaseFirestore cloudDataBase = null;
    
    public CloudDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&J\u000e\u0010\'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\b2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\b2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020\b2\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020AJ\u0016\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020GR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006H"}, d2 = {"Lcom/gammasoft/busfinder/model/dbNube/CloudDataBase$Companion;", "", "()V", "cloudDataBase", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getCloudDataBase", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "addAdministrador", "", "admin", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Administrador;", "addChofer", "chofer", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Chofer;", "addCodigoAdministrador", "codigo", "Lcom/gammasoft/busfinder/model/dbNube/Codigo;", "addCodigoChofer", "addCoordenada", "coordenada", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Coordenada;", "addCuenta", "cuenta", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Cuenta;", "addCuentaAdministrador", "cuentaAdmin", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaAdministrador;", "addCuentaChofer", "cuentaChofer", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaChofer;", "addCuentaPublico", "cuentaPublico", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaPublico;", "addHorario", "horario", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Horario;", "addHorarioCUR", "horarioCUR", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/HorarioCUR;", "addParada", "parada", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Parada;", "addPublicoGeneral", "publico", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/PublicoGeneral;", "addQuejaSugerencia", "quejaSugerencia", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/QuejaSugerencia;", "addRuta", "ruta", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Ruta;", "addRutaCoordenada", "rutaCoordenada", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/RutaCoordenada;", "addRutaParada", "rutaParada", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/RutaParada;", "addTarifa", "tarifa", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Tarifa;", "addUnidad", "unidad", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Unidad;", "addUnidadCoordenada", "unidadCoor", "Lcom/gammasoft/busfinder/model/dbLocal/relaciones/UnidadCoordenada;", "delete", "coleccion", "", "documento", "getAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.firebase.firestore.FirebaseFirestore getCloudDataBase() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.google.firebase.auth.FirebaseAuth getAuth() {
            return null;
        }
        
        public final void delete(@org.jetbrains.annotations.NotNull()
        java.lang.String coleccion, @org.jetbrains.annotations.NotNull()
        java.lang.String documento) {
        }
        
        public final void addCuenta(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta cuenta) {
        }
        
        public final void addAdministrador(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Administrador admin) {
        }
        
        public final void addChofer(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Chofer chofer) {
        }
        
        public final void addPublicoGeneral(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral publico) {
        }
        
        public final void addRuta(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Ruta ruta) {
        }
        
        public final void addParada(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Parada parada) {
        }
        
        public final void addUnidad(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Unidad unidad) {
        }
        
        public final void addTarifa(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa tarifa) {
        }
        
        public final void addHorario(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Horario horario) {
        }
        
        public final void addCoordenada(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada coordenada) {
        }
        
        public final void addQuejaSugerencia(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia quejaSugerencia) {
        }
        
        public final void addCuentaAdministrador(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador cuentaAdmin) {
        }
        
        public final void addCuentaChofer(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaChofer cuentaChofer) {
        }
        
        public final void addCuentaPublico(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaPublico cuentaPublico) {
        }
        
        public final void addRutaCoordenada(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada rutaCoordenada) {
        }
        
        public final void addRutaParada(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.relaciones.RutaParada rutaParada) {
        }
        
        public final void addUnidadCoordenada(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.relaciones.UnidadCoordenada unidadCoor) {
        }
        
        public final void addHorarioCUR(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR horarioCUR) {
        }
        
        public final void addCodigoAdministrador(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbNube.Codigo codigo) {
        }
        
        public final void addCodigoChofer(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.model.dbNube.Codigo codigo) {
        }
    }
}