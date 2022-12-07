package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "Tarifa")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c2\u0003J\t\u0010\u000b\u001a\u00020\u0004H\u00c2\u0003J\'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0006J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0012\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/Tarifa;", "", "()V", "nombre", "", "precio", "", "administrador", "(Ljava/lang/String;DLjava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "getAdministrador", "getNombre", "getPrecio", "hashCode", "", "setAdministrador", "", "setNombre", "setPrecio", "toString", "app_debug"})
public final class Tarifa {
    @androidx.room.ColumnInfo(name = "nombre")
    @androidx.room.PrimaryKey()
    private java.lang.String nombre;
    @androidx.room.ColumnInfo(name = "precio")
    private double precio;
    @androidx.room.ColumnInfo(name = "administrador")
    private java.lang.String administrador;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.Tarifa copy(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, double precio, @org.jetbrains.annotations.NotNull()
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
    
    public Tarifa(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, double precio, @org.jetbrains.annotations.NotNull()
    java.lang.String administrador) {
        super();
    }
    
    private final java.lang.String component1() {
        return null;
    }
    
    private final double component2() {
        return 0.0;
    }
    
    private final java.lang.String component3() {
        return null;
    }
    
    public Tarifa() {
        super();
    }
    
    public final void setNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNombre() {
        return null;
    }
    
    public final void setPrecio(double precio) {
    }
    
    public final double getPrecio() {
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