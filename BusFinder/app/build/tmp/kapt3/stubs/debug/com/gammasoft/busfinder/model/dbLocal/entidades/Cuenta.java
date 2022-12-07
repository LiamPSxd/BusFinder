package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "Cuenta")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000f\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u0010\u001a\u00020\bH\u00c2\u0003J\t\u0010\u0011\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u0012\u001a\u00020\u000bH\u00c2\u0003JE\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\bJ\t\u0010\u001c\u001a\u00020\bH\u00d6\u0001J\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010%\u001a\u00020\u0004H\u0016R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/Cuenta;", "", "()V", "correo", "", "contrasenia", "foto", "tipo", "", "metodo", "estado", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "getContrasenia", "getCorreo", "getEstado", "getFoto", "getMetodo", "getTipo", "hashCode", "mostrarTipo", "setContrasenia", "", "setCorreo", "setEstado", "setFoto", "setMetodo", "setTipo", "toString", "app_debug"})
public final class Cuenta {
    @androidx.room.ColumnInfo(name = "correo")
    @androidx.room.PrimaryKey()
    private java.lang.String correo;
    @androidx.room.ColumnInfo(name = "contrasenia")
    private java.lang.String contrasenia;
    @androidx.room.ColumnInfo(name = "foto")
    private java.lang.String foto;
    @androidx.room.ColumnInfo(name = "tipo")
    private int tipo;
    @androidx.room.ColumnInfo(name = "metodo")
    private java.lang.String metodo;
    @androidx.room.ColumnInfo(name = "estado")
    private boolean estado;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.Cuenta copy(@org.jetbrains.annotations.NotNull()
    java.lang.String correo, @org.jetbrains.annotations.NotNull()
    java.lang.String contrasenia, @org.jetbrains.annotations.NotNull()
    java.lang.String foto, int tipo, @org.jetbrains.annotations.NotNull()
    java.lang.String metodo, boolean estado) {
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
    
    public Cuenta(@org.jetbrains.annotations.NotNull()
    java.lang.String correo, @org.jetbrains.annotations.NotNull()
    java.lang.String contrasenia, @org.jetbrains.annotations.NotNull()
    java.lang.String foto, int tipo, @org.jetbrains.annotations.NotNull()
    java.lang.String metodo, boolean estado) {
        super();
    }
    
    private final java.lang.String component1() {
        return null;
    }
    
    private final java.lang.String component2() {
        return null;
    }
    
    private final java.lang.String component3() {
        return null;
    }
    
    private final int component4() {
        return 0;
    }
    
    private final java.lang.String component5() {
        return null;
    }
    
    private final boolean component6() {
        return false;
    }
    
    public Cuenta() {
        super();
    }
    
    public final void setCorreo(@org.jetbrains.annotations.NotNull()
    java.lang.String correo) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCorreo() {
        return null;
    }
    
    public final void setContrasenia(@org.jetbrains.annotations.NotNull()
    java.lang.String contrasenia) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContrasenia() {
        return null;
    }
    
    public final void setFoto(@org.jetbrains.annotations.NotNull()
    java.lang.String foto) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFoto() {
        return null;
    }
    
    public final void setTipo(int tipo) {
    }
    
    public final int getTipo() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String mostrarTipo() {
        return null;
    }
    
    public final void setMetodo(@org.jetbrains.annotations.NotNull()
    java.lang.String metodo) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMetodo() {
        return null;
    }
    
    public final void setEstado(boolean estado) {
    }
    
    public final boolean getEstado() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}