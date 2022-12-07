package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "Chofer")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u0012\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u0013\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c2\u0003J\t\u0010\u0015\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c2\u0003J\t\u0010\u0017\u001a\u00020\fH\u00c2\u0003J\t\u0010\u0018\u001a\u00020\u000eH\u00c2\u0003J\t\u0010\u0019\u001a\u00020\u0004H\u00c2\u0003Jc\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\u0004J\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\t\u0010\'\u001a\u00020\fH\u00d6\u0001J\u000e\u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020)2\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010-\u001a\u00020)2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020)2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010/\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u00100\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u00101\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u00102\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u00103\u001a\u00020\u0004H\u0016R\u0012\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/Chofer;", "", "()V", "usuario", "", "rfc", "nombre", "numCelular", "", "linea", "codigo", "noUsuarios", "", "calificacion", "", "administrador", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JIDLjava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getAdministrador", "getCalificacion", "getCodigo", "getLinea", "getNoUsuarios", "getNombre", "getNumCelular", "getRfc", "getUsuario", "hashCode", "setAdministrador", "", "setCalificacion", "valor", "setCodigo", "setLinea", "setNoUsuarios", "setNombre", "setNumCelular", "setRfc", "setUsuario", "toString", "app_debug"})
public final class Chofer {
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
    @androidx.room.ColumnInfo(name = "noUsuarios")
    private int noUsuarios;
    @androidx.room.ColumnInfo(name = "calificacion")
    private double calificacion;
    @androidx.room.ColumnInfo(name = "administrador")
    private java.lang.String administrador;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.Chofer copy(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario, @org.jetbrains.annotations.NotNull()
    java.lang.String rfc, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, long numCelular, @org.jetbrains.annotations.NotNull()
    java.lang.String linea, long codigo, int noUsuarios, double calificacion, @org.jetbrains.annotations.NotNull()
    java.lang.String administrador) {
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
    
    public Chofer(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario, @org.jetbrains.annotations.NotNull()
    java.lang.String rfc, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, long numCelular, @org.jetbrains.annotations.NotNull()
    java.lang.String linea, long codigo, int noUsuarios, double calificacion, @org.jetbrains.annotations.NotNull()
    java.lang.String administrador) {
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
    
    private final int component7() {
        return 0;
    }
    
    private final double component8() {
        return 0.0;
    }
    
    private final java.lang.String component9() {
        return null;
    }
    
    public Chofer() {
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
    
    public final void setNoUsuarios(int noUsuarios) {
    }
    
    public final int getNoUsuarios() {
        return 0;
    }
    
    public final void setCalificacion(double valor) {
    }
    
    public final double getCalificacion() {
        return 0.0;
    }
    
    public final void setAdministrador(@org.jetbrains.annotations.NotNull()
    java.lang.String administrador) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAdministrador() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}