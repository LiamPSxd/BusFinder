package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "Unidad")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\r\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000f\u001a\u00020\bH\u00c2\u0003J\t\u0010\u0010\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u0011\u001a\u00020\u0004H\u00c2\u0003JE\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u0004J\t\u0010\u001c\u001a\u00020\bH\u00d6\u0001J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010$\u001a\u00020\u0004H\u0016R\u0012\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/Unidad;", "", "()V", "placa", "", "marca", "modelo", "numero", "", "hora", "fecha", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "getFecha", "getHora", "getMarca", "getModelo", "getNumero", "getPlaca", "hashCode", "setFecha", "", "setHora", "setMarca", "setModelo", "setNumero", "setPlaca", "toString", "app_debug"})
public final class Unidad {
    @androidx.room.ColumnInfo(name = "placa")
    @androidx.room.PrimaryKey()
    private java.lang.String placa;
    @androidx.room.ColumnInfo(name = "marca")
    private java.lang.String marca;
    @androidx.room.ColumnInfo(name = "modelo")
    private java.lang.String modelo;
    @androidx.room.ColumnInfo(name = "numero")
    private int numero;
    @androidx.room.ColumnInfo(name = "hora")
    private java.lang.String hora;
    @androidx.room.ColumnInfo(name = "fecha")
    private java.lang.String fecha;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.Unidad copy(@org.jetbrains.annotations.NotNull()
    java.lang.String placa, @org.jetbrains.annotations.NotNull()
    java.lang.String marca, @org.jetbrains.annotations.NotNull()
    java.lang.String modelo, int numero, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, @org.jetbrains.annotations.NotNull()
    java.lang.String fecha) {
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
    
    public Unidad(@org.jetbrains.annotations.NotNull()
    java.lang.String placa, @org.jetbrains.annotations.NotNull()
    java.lang.String marca, @org.jetbrains.annotations.NotNull()
    java.lang.String modelo, int numero, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, @org.jetbrains.annotations.NotNull()
    java.lang.String fecha) {
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
    
    private final java.lang.String component6() {
        return null;
    }
    
    public Unidad() {
        super();
    }
    
    public final void setPlaca(@org.jetbrains.annotations.NotNull()
    java.lang.String placa) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlaca() {
        return null;
    }
    
    public final void setMarca(@org.jetbrains.annotations.NotNull()
    java.lang.String marca) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMarca() {
        return null;
    }
    
    public final void setModelo(@org.jetbrains.annotations.NotNull()
    java.lang.String modelo) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModelo() {
        return null;
    }
    
    public final void setNumero(int numero) {
    }
    
    public final int getNumero() {
        return 0;
    }
    
    public final void setHora(@org.jetbrains.annotations.NotNull()
    java.lang.String hora) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHora() {
        return null;
    }
    
    public final void setFecha(@org.jetbrains.annotations.NotNull()
    java.lang.String fecha) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFecha() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}