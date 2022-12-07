package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "PublicoGeneral")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004H\u00c2\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u000b\u001a\u00020\u0004J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/PublicoGeneral;", "", "()V", "usuario", "", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", "other", "getUsuario", "hashCode", "", "setUsuario", "", "toString", "app_debug"})
public final class PublicoGeneral {
    @androidx.room.ColumnInfo(name = "usuario")
    @androidx.room.PrimaryKey()
    private java.lang.String usuario;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.PublicoGeneral copy(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario) {
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
    
    public PublicoGeneral(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario) {
        super();
    }
    
    private final java.lang.String component1() {
        return null;
    }
    
    public PublicoGeneral() {
        super();
    }
    
    public final void setUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsuario() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}