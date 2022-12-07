package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "Administrador")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\r\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000f\u001a\u00020\bH\u00c2\u0003J\t\u0010\u0010\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u0011\u001a\u00020\bH\u00c2\u0003JE\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010%\u001a\u00020\u0004H\u0016R\u0012\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/Administrador;", "", "()V", "usuario", "", "rfc", "nombre", "numCelular", "", "linea", "codigo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "getCodigo", "getLinea", "getNombre", "getNumCelular", "getRfc", "getUsuario", "hashCode", "", "setCodigo", "", "setLinea", "setNombre", "setNumCelular", "setRfc", "setUsuario", "toString", "app_debug"})
public final class Administrador {
    @androidx.room.ColumnInfo(name = "usuario")
    @androidx.room.PrimaryKey()
    private java.lang.String usuario;
    @androidx.room.ColumnInfo(name = "rfc")
    private java.lang.String rfc;
    @androidx.room.ColumnInfo(name = "nombre")
    private java.lang.String nombre;
    @androidx.room.ColumnInfo(name = "numero_Celular")
    private long numCelular;
    @androidx.room.ColumnInfo(name = "linea_Transporte")
    private java.lang.String linea;
    @androidx.room.ColumnInfo(name = "codigo")
    private long codigo;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.Administrador copy(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario, @org.jetbrains.annotations.NotNull()
    java.lang.String rfc, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, long numCelular, @org.jetbrains.annotations.NotNull()
    java.lang.String linea, long codigo) {
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
    
    public Administrador(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario, @org.jetbrains.annotations.NotNull()
    java.lang.String rfc, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, long numCelular, @org.jetbrains.annotations.NotNull()
    java.lang.String linea, long codigo) {
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
    
    private final long component4() {
        return 0L;
    }
    
    private final java.lang.String component5() {
        return null;
    }
    
    private final long component6() {
        return 0L;
    }
    
    public Administrador() {
        super();
    }
    
    public final void setUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsuario() {
        return null;
    }
    
    public final void setRfc(@org.jetbrains.annotations.NotNull()
    java.lang.String rfc) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRfc() {
        return null;
    }
    
    public final void setNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNombre() {
        return null;
    }
    
    public final void setNumCelular(long numCelular) {
    }
    
    public final long getNumCelular() {
        return 0L;
    }
    
    public final void setLinea(@org.jetbrains.annotations.NotNull()
    java.lang.String linea) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLinea() {
        return null;
    }
    
    public final void setCodigo(long codigo) {
    }
    
    public final long getCodigo() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}