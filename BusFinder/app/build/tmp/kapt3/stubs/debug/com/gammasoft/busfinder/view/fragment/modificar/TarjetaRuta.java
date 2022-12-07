package com.gammasoft.busfinder.view.fragment.modificar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0002J\u001c\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020.H\u0016J\u001a\u00102\u001a\u00020\u00012\b\b\u0003\u00103\u001a\u0002042\b\b\u0003\u00105\u001a\u000204J$\u00106\u001a\u00020.2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010*2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u001dH\u0016J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u0017H\u0016J\u001a\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/modificar/TarjetaRuta;", "Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "bin", "Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;", "ruta", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Ruta;", "(Lcom/gammasoft/busfinder/model/dbLocal/Crud;Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;Lcom/gammasoft/busfinder/model/dbLocal/entidades/Ruta;)V", "_binding", "Lcom/gammasoft/busfinder/databinding/TarjetaModificarRutaBinding;", "binding", "getBinding", "()Lcom/gammasoft/busfinder/databinding/TarjetaModificarRutaBinding;", "coordenadas", "Ljava/util/ArrayList;", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Coordenada;", "end", "", "evento", "Lcom/gammasoft/busfinder/controller/MapaEvento;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "oldStarts", "polylines", "Lcom/google/android/gms/maps/model/Polyline;", "start", "addPolyline", "", "newPolyline", "crearRuta", "crearRutas", "inicio", "fin", "drawRoute", "routeResponse", "Lcom/gammasoft/busfinder/model/mapa/RutaResponse;", "timeResponse", "Lcom/gammasoft/busfinder/model/mapa/RutaTiempo;", "finalizar", "getBackgroundLayout", "Landroid/view/ViewGroup;", "getBlurLayout", "Lio/alterac/blurkit/BlurLayout;", "getDragHandle", "Landroid/view/View;", "getRetrofit", "Lretrofit2/Retrofit;", "getRootView", "mostrar", "enterAnim", "", "exitAnim", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMapReady", "googleMap", "onViewCreated", "view", "app_debug"})
public final class TarjetaRuta extends com.gammasoft.busfinder.view.dialog.BaseBlurPopup implements com.google.android.gms.maps.OnMapReadyCallback {
    private final com.gammasoft.busfinder.model.dbLocal.Crud localDB = null;
    private final com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin = null;
    private final com.gammasoft.busfinder.model.dbLocal.entidades.Ruta ruta = null;
    private com.gammasoft.busfinder.databinding.TarjetaModificarRutaBinding _binding;
    private com.gammasoft.busfinder.controller.MapaEvento evento;
    private com.google.android.gms.maps.GoogleMap map;
    private java.lang.String start = "";
    private java.lang.String end = "";
    private final java.util.ArrayList<com.google.android.gms.maps.model.Polyline> polylines = null;
    private final java.util.ArrayList<java.lang.String> oldStarts = null;
    private final java.util.ArrayList<com.gammasoft.busfinder.model.dbLocal.entidades.Coordenada> coordenadas = null;
    
    public TarjetaRuta(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.Crud localDB, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Ruta ruta) {
        super();
    }
    
    private final com.gammasoft.busfinder.databinding.TarjetaModificarRutaBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.view.dialog.BaseBlurPopup mostrar(@androidx.annotation.AnimRes()
    int enterAnim, @androidx.annotation.AnimRes()
    int exitAnim) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void finalizar() {
    }
    
    private final void addPolyline(com.google.android.gms.maps.model.Polyline newPolyline) {
    }
    
    private final void drawRoute(com.gammasoft.busfinder.model.mapa.RutaResponse routeResponse, com.gammasoft.busfinder.model.mapa.RutaTiempo timeResponse) {
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
    }
    
    private final void crearRuta() {
    }
    
    private final void crearRutas(java.lang.String inicio, java.lang.String fin) {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.alterac.blurkit.BlurLayout getBlurLayout() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getDragHandle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getRootView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.ViewGroup getBackgroundLayout() {
        return null;
    }
}