package com.gammasoft.busfinder.model.dbLocal.relaciones;

import java.lang.System;

@androidx.room.Entity(tableName = "CuentaAdministrador", primaryKeys = {"cuenta_Correo", "administrador_Usuario"}, indices = {@androidx.room.Index(value = {"cuenta_Correo"}), @androidx.room.Index(value = {"administrador_Usuario"})}, foreignKeys = {@androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta.class, childColumns = {"cuenta_Correo"}, parentColumns = {"correo"}), @androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Administrador.class, childColumns = {"administrador_Usuario"}, parentColumns = {"usuario"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\b\u001a\u00020\u0004H\u00c2\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/relaciones/CuentaAdministrador;", "", "()V", "cuentaCorreo", "", "adminUsuario", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "getAdminUsuario", "getCuentaCorreo", "hashCode", "", "setAdminUsuario", "", "setCuentaCorreo", "toString", "app_debug"})
public final class CuentaAdministrador {
    @androidx.room.ColumnInfo(name = "cuenta_Correo")
    private java.lang.String cuentaCorreo;
    @androidx.room.ColumnInfo(name = "administrador_Usuario")
    private java.lang.String adminUsuario;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.relaciones.CuentaAdministrador copy(@org.jetbrains.annotations.NotNull()
    java.lang.String cuentaCorreo, @org.jetbrains.annotations.NotNull()
    java.lang.String adminUsuario) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public CuentaAdministrador(@org.jetbrains.annotations.NotNull()
    java.lang.String cuentaCorreo, @org.jetbrains.annotations.NotNull()
    java.lang.String adminUsuario) {
        super();
    }
    
    private final java.lang.String component1() {
        return null;
    }
    
    private final java.lang.String component2() {
        return null;
    }
    
    public CuentaAdministrador() {
        super();
    }
    
    public final void setCuentaCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String cuentaCorreo) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCuentaCorreo() {
        return null;
    }
    
    public final void setAdminUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String adminUsuario) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAdminUsuario() {
        return null;
    }
}