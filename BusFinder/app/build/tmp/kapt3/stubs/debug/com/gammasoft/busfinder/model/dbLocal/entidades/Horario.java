package com.gammasoft.busfinder.model.dbLocal.entidades;

import java.lang.System;

@androidx.room.Entity(tableName = "Horario")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0007B%\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\tH\u00c2\u0003J\t\u0010\f\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\r\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00c2\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\tJ\t\u0010\u0017\u001a\u00020\tH\u00d6\u0001J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0012\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/entidades/Horario;", "", "()V", "horaEntrada", "", "horaSalida", "fecha", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "id", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getFecha", "getHoraEntrada", "getHoraSalida", "getId", "hashCode", "setFecha", "", "setHoraEntrada", "setHoraSalida", "setId", "toString", "app_debug"})
public final class Horario {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @androidx.room.ColumnInfo(name = "hora_Entrada")
    private java.lang.String horaEntrada;
    @androidx.room.ColumnInfo(name = "hora_Salida")
    private java.lang.String horaSalida;
    @androidx.room.ColumnInfo(name = "fecha")
    private java.lang.String fecha;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.entidades.Horario copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String horaEntrada, @org.jetbrains.annotations.NotNull()
    java.lang.String horaSalida, @org.jetbrains.annotations.NotNull()
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
    
    public Horario(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String horaEntrada, @org.jetbrains.annotations.NotNull()
    java.lang.String horaSalida, @org.jetbrains.annotations.NotNull()
    java.lang.String fecha) {
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
    
    private final java.lang.String component4() {
        return null;
    }
    
    public Horario() {
        super();
    }
    
    public Horario(@org.jetbrains.annotations.NotNull()
    java.lang.String horaEntrada, @org.jetbrains.annotations.NotNull()
    java.lang.String horaSalida, @org.jetbrains.annotations.NotNull()
    java.lang.String fecha) {
        super();
    }
    
    public final void setId(int id) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setHoraEntrada(@org.jetbrains.annotations.NotNull()
    java.lang.String horaEntrada) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHoraEntrada() {
        return null;
    }
    
    public final void setHoraSalida(@org.jetbrains.annotations.NotNull()
    java.lang.String horaSalida) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHoraSalida() {
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