package com.gammasoft.busfinder.view.fragment.modificar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u001a\u0010&\u001a\u00020\u00012\b\b\u0003\u0010\'\u001a\u00020(2\b\b\u0003\u0010)\u001a\u00020(J$\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010 2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u001bH\u0016J0\u00101\u001a\u00020\u001b2\f\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u0001032\b\u00104\u001a\u0004\u0018\u00010$2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u0013H\u0016J\u0016\u0010:\u001a\u00020\u001b2\f\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u000103H\u0016J\u001a\u0010;\u001a\u00020\u001b2\u0006\u00104\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/modificar/TarjetaParada;", "Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "bin", "Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;", "parada", "Lcom/gammasoft/busfinder/model/dbLocal/entidades/Parada;", "(Lcom/gammasoft/busfinder/model/dbLocal/Crud;Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;Lcom/gammasoft/busfinder/model/dbLocal/entidades/Parada;)V", "_binding", "Lcom/gammasoft/busfinder/databinding/TarjetaModificarParadaBinding;", "binding", "getBinding", "()Lcom/gammasoft/busfinder/databinding/TarjetaModificarParadaBinding;", "evento", "Lcom/gammasoft/busfinder/controller/MapaEvento;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "markers", "Ljava/util/ArrayList;", "Lcom/google/android/gms/maps/model/Marker;", "paradas", "ruta", "", "cambiarParada", "", "coordenadas", "Lcom/google/android/gms/maps/model/LatLng;", "finalizar", "getBackgroundLayout", "Landroid/view/ViewGroup;", "getBlurLayout", "Lio/alterac/blurkit/BlurLayout;", "getDragHandle", "Landroid/view/View;", "getRootView", "mostrar", "enterAnim", "", "exitAnim", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemSelected", "parent", "Landroid/widget/AdapterView;", "view", "position", "id", "", "onMapReady", "googleMap", "onNothingSelected", "onViewCreated", "app_debug"})
public final class TarjetaParada extends com.gammasoft.busfinder.view.dialog.BaseBlurPopup implements com.google.android.gms.maps.OnMapReadyCallback, android.widget.AdapterView.OnItemSelectedListener {
    private final com.gammasoft.busfinder.model.dbLocal.Crud localDB = null;
    private final com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin = null;
    private final com.gammasoft.busfinder.model.dbLocal.entidades.Parada parada = null;
    private com.gammasoft.busfinder.databinding.TarjetaModificarParadaBinding _binding;
    private java.lang.String ruta = "";
    private com.gammasoft.busfinder.controller.MapaEvento evento;
    private com.google.android.gms.maps.GoogleMap map;
    private final java.util.ArrayList<com.google.android.gms.maps.model.Marker> markers = null;
    private final java.util.ArrayList<com.gammasoft.busfinder.model.dbLocal.entidades.Parada> paradas = null;
    
    public TarjetaParada(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.Crud localDB, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.entidades.Parada parada) {
        super();
    }
    
    private final com.gammasoft.busfinder.databinding.TarjetaModificarParadaBinding getBinding() {
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
    
    private final void cambiarParada(com.google.android.gms.maps.model.LatLng coordenadas) {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @java.lang.Override()
    public void onItemSelected(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> parent, @org.jetbrains.annotations.Nullable()
    android.view.View view, int position, long id) {
    }
    
    @java.lang.Override()
    public void onNothingSelected(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> parent) {
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