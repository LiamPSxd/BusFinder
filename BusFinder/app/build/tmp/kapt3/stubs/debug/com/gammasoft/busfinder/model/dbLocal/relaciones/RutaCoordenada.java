package com.gammasoft.busfinder.model.dbLocal.relaciones;

import java.lang.System;

@androidx.room.Entity(tableName = "RutaCoordenada", primaryKeys = {"ruta_ID", "coordenada_ID"}, indices = {@androidx.room.Index(value = {"ruta_ID"}), @androidx.room.Index(value = {"coordenada_ID"})}, foreignKeys = {@androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Ruta.class, childColumns = {"ruta_ID"}, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada.class, childColumns = {"coordenada_ID"}, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\b\u001a\u00020\u0004H\u00c2\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/relaciones/RutaCoordenada;", "", "()V", "rutaID", "", "coordenadaID", "(II)V", "component1", "component2", "copy", "equals", "", "other", "getCoordenadaID", "getRutaID", "hashCode", "setCoordenadaID", "", "setRutaID", "toString", "", "app_debug"})
public final class RutaCoordenada {
    @androidx.room.ColumnInfo(name = "ruta_ID")
    private int rutaID;
    @androidx.room.ColumnInfo(name = "coordenada_ID")
    private int coordenadaID;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.relaciones.RutaCoordenada copy(int rutaID, int coordenadaID) {
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
    
    public RutaCoordenada(int rutaID, int coordenadaID) {
        super();
    }
    
    private final int component1() {
        return 0;
    }
    
    private final int component2() {
        return 0;
    }
    
    public RutaCoordenada() {
        super();
    }
    
    public final void setRutaID(int rutaID) {
    }
    
    public final int getRutaID() {
        return 0;
    }
    
    public final void setCoordenadaID(int coordenadaID) {
    }
    
    public final int getCoordenadaID() {
        return 0;
    }
}