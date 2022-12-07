package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "SugerenciaQueja")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0007H\u00c2\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c2\u0003J\'\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00d6\u0001J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/QuejaSugerencia;", "", "descripcion", "", "usuario", "(Ljava/lang/String;Ljava/lang/String;)V", "id", "", "(ILjava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "getDescripcion", "getId", "getUsuario", "hashCode", "setDescripcion", "", "setId", "setUsuario", "toString", "app_debug"})
public final class QuejaSugerencia {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @androidx.room.ColumnInfo(name = "descripcion")
    private java.lang.String descripcion;
    @androidx.room.ColumnInfo(name = "usuario")
    private java.lang.String usuario;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.QuejaSugerencia copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String descripcion, @org.jetbrains.annotations.NotNull()
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
    
    public QuejaSugerencia(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String descripcion, @org.jetbrains.annotations.NotNull()
    java.lang.String usuario) {
        super();
    }
    
    private final int component1() {
        return 0;
    }
    
    private final java.lang.String component2() {
        return null;
    }
    
    private final java.lang.String component3() {
        return null;
    }
    
    public QuejaSugerencia(@org.jetbrains.annotations.NotNull()
    java.lang.String descripcion, @org.jetbrains.annotations.NotNull()
    java.lang.String usuario) {
        super();
    }
    
    public final void setId(int id) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setDescripcion(@org.jetbrains.annotations.NotNull()
    java.lang.String descripcion) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescripcion() {
        return null;
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