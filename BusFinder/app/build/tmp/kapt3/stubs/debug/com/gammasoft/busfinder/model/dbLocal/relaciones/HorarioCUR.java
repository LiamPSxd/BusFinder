package com.gammasoft.busfinder.model.dbLocal.relaciones;

import java.lang.System;

@androidx.room.Entity(tableName = "HorarioChoferUnidadRuta", primaryKeys = {"horario_ID", "chofer_Usuario", "unidad_Placa", "ruta_Ida_ID", "ruta_Venida_ID"}, indices = {@androidx.room.Index(value = {"horario_ID"}), @androidx.room.Index(value = {"chofer_Usuario"}), @androidx.room.Index(value = {"unidad_Placa"}), @androidx.room.Index(value = {"ruta_Ida_ID"}), @androidx.room.Index(value = {"ruta_Venida_ID"})}, foreignKeys = {@androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Horario.class, childColumns = {"horario_ID"}, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Chofer.class, childColumns = {"chofer_Usuario"}, parentColumns = {"usuario"}), @androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Unidad.class, childColumns = {"unidad_Placa"}, parentColumns = {"placa"}), @androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Ruta.class, childColumns = {"ruta_Ida_ID"}, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.gammasoft.busfinder.model.dbLocal.entidades.Ruta.class, childColumns = {"ruta_Venida_ID"}, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c2\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c2\u0003J\t\u0010\u000e\u001a\u00020\u0004H\u00c2\u0003J\t\u0010\u000f\u001a\u00020\u0004H\u00c2\u0003J;\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0006J\t\u0010\u0019\u001a\u00020\u0004H\u00d6\u0001J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u0006J\t\u0010 \u001a\u00020\u0006H\u00d6\u0001R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/gammasoft/busfinder/model/dbLocal/relaciones/HorarioCUR;", "", "()V", "horarioId", "", "choferUsuario", "", "unidadPlaca", "rutaIdaId", "rutaVenidaId", "(ILjava/lang/String;Ljava/lang/String;II)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "getChoferUsuario", "getHorarioId", "getRutaIdaId", "getRutaVenidaId", "getUnidadPlaca", "hashCode", "setChoferUsuario", "", "setHorarioId", "setRutaIdaId", "setRutaVenidaId", "setUnidadPlaca", "toString", "app_debug"})
public final class HorarioCUR {
    @androidx.room.ColumnInfo(name = "horario_ID")
    private int horarioId;
    @androidx.room.ColumnInfo(name = "chofer_Usuario")
    private java.lang.String choferUsuario;
    @androidx.room.ColumnInfo(name = "unidad_Placa")
    private java.lang.String unidadPlaca;
    @androidx.room.ColumnInfo(name = "ruta_Ida_ID")
    private int rutaIdaId;
    @androidx.room.ColumnInfo(name = "ruta_Venida_ID")
    private int rutaVenidaId;
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.model.dbLocal.relaciones.HorarioCUR copy(int horarioId, @org.jetbrains.annotations.NotNull()
    java.lang.String choferUsuario, @org.jetbrains.annotations.NotNull()
    java.lang.String unidadPlaca, int rutaIdaId, int rutaVenidaId) {
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
    
    public HorarioCUR(int horarioId, @org.jetbrains.annotations.NotNull()
    java.lang.String choferUsuario, @org.jetbrains.annotations.NotNull()
    java.lang.String unidadPlaca, int rutaIdaId, int rutaVenidaId) {
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
    
    private final int component4() {
        return 0;
    }
    
    private final int component5() {
        return 0;
    }
    
    public HorarioCUR() {
        super();
    }
    
    public final void setHorarioId(int horarioId) {
    }
    
    public final int getHorarioId() {
        return 0;
    }
    
    public final void setChoferUsuario(@org.jetbrains.annotations.NotNull()
    java.lang.String choferUsuario) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChoferUsuario() {
        return null;
    }
    
    public final void setUnidadPlaca(@org.jetbrains.annotations.NotNull()
    java.lang.String unidadPlaca) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnidadPlaca() {
        return null;
    }
    
    public final void setRutaIdaId(int rutaIdaId) {
    }
    
    public final int getRutaIdaId() {
        return 0;
    }
    
    public final void setRutaVenidaId(int rutaVenidaId) {
    }
    
    public final int getRutaVenidaId() {
        return 0;
    }
}