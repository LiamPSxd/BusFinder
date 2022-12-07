package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "Parada")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\tB-\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000bH\u00c2\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c2\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c2\u0003J\t\u0010\u0011\u001a\u00020\u0004H\u00c2\u0003J;\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0004J\t\u0010\u001b\u001a\u00020\u000bH\u00d6\u0001J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0012\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/Parada;", "", "()V", "nombre", "", "longitud", "", "latitud", "administrador", "(Ljava/lang/String;DDLjava/lang/String;)V", "id", "", "(ILjava/lang/String;DDLjava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "getAdministrador", "getId", "getLatitud", "getLongitud", "getNombre", "hashCode", "setAdministrador", "", "setId", "setLatitud", "setLongitud", "setNombre", "toString", "app_debug"})
public final class Parada {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @androidx.room.ColumnInfo(name = "nombre")
    private java.lang.String nombre;
    @androidx.room.ColumnInfo(name = "longitud")
    private double longitud;
    @androidx.room.ColumnInfo(name = "latitud")
    private double latitud;
    @androidx.room.ColumnInfo(name = "administrador")
    private java.lang.String administrador;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.Parada copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, double longitud, double latitud, @org.jetbrains.annotations.NotNull()
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
    
    public Parada(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String nombre, double longitud, double latitud, @org.jetbrains.annotations.NotNull()
    java.lang.String administrador) {
        super();
    }
    
    private final int component1() {
        return 0;
    }
    
    private final java.lang.String component2() {
        return null;
    }
    
    private final double component3() {
        return 0.0;
    }
    
    private final double component4() {
        return 0.0;
    }
    
    private final java.lang.String component5() {
        return null;
    }
    
    public Parada() {
        super();
    }
    
    public Parada(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, double longitud, double latitud, @org.jetbrains.annotations.NotNull()
    java.lang.String administrador) {
        super();
    }
    
    public final void setId(int id) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setNombre(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNombre() {
        return null;
    }
    
    public final void setLongitud(double longitud) {
    }
    
    public final double getLongitud() {
        return 0.0;
    }
    
    public final void setLatitud(double latitud) {
    }
    
    public final double getLatitud() {
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