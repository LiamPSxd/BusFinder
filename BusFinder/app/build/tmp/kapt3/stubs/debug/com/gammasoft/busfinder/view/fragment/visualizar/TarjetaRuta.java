package com.gammasoft.busfinder.view.fragment.visualizar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u001c\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020$H\u0016J\u001a\u0010(\u001a\u00020\u00012\b\b\u0003\u0010)\u001a\u00020*2\b\b\u0003\u0010+\u001a\u00020*J$\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010 2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u0017H\u0016J\u0010\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0015H\u0016J\u001a\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/visualizar/TarjetaRuta;", "Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "fragment", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "bin", "Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;", "titulo", "", "id", "(Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;Ljava/lang/String;Ljava/lang/String;)V", "_binding", "Lcom/gammasoft/busfinder/databinding/TarjetaVisualizarRutaBinding;", "binding", "getBinding", "()Lcom/gammasoft/busfinder/databinding/TarjetaVisualizarRutaBinding;", "evento", "Lcom/gammasoft/busfinder/controller/MapaEvento;", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "crearRutas", "", "inicio", "fin", "drawRoute", "routeResponse", "Lcom/gammasoft/busfinder/model/mapa/RutaResponse;", "timeResponse", "Lcom/gammasoft/busfinder/model/mapa/RutaTiempo;", "getBackgroundLayout", "Landroid/view/ViewGroup;", "getBlurLayout", "Lio/alterac/blurkit/BlurLayout;", "getDragHandle", "Landroid/view/View;", "getRetrofit", "Lretrofit2/Retrofit;", "getRootView", "mostrar", "enterAnim", "", "exitAnim", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMapReady", "googleMap", "onViewCreated", "view", "app_debug"})
public final class TarjetaRuta extends com.gammasoft.busfinder.view.dialog.BaseBlurPopup implements com.google.android.gms.maps.OnMapReadyCallback {
    private final com.gammasoft.busfinder.view.fragment.TarjetaBase fragment = null;
    private final com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin = null;
    private final java.lang.String titulo = null;
    private final java.lang.String id = null;
    private com.gammasoft.busfinder.databinding.TarjetaVisualizarRutaBinding _binding;
    private com.gammasoft.busfinder.model.dbLocal.Crud localDB;
    private com.gammasoft.busfinder.controller.MapaEvento evento;
    private com.google.android.gms.maps.GoogleMap map;
    
    public TarjetaRuta(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.fragment.TarjetaBase fragment, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin, @org.jetbrains.annotations.NotNull()
    java.lang.String titulo, @org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        super();
    }
    
    private final com.gammasoft.busfinder.databinding.TarjetaVisualizarRutaBinding getBinding() {
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
    
    private final void drawRoute(com.gammasoft.busfinder.model.mapa.RutaResponse routeResponse, com.gammasoft.busfinder.model.mapa.RutaTiempo timeResponse) {
    }
    
    private final retrofit2.Retrofit getRetrofit() {
        return null;
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