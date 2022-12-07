package com.gammasoft.busfinder.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u001a\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010#\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/Mapa;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "_binding", "Lcom/gammasoft/busfinder/databinding/FragmentMapaBinding;", "binding", "getBinding", "()Lcom/gammasoft/busfinder/databinding/FragmentMapaBinding;", "evento", "Lcom/gammasoft/busfinder/controller/MapaEvento;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "requestPermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "activarLocalizacion", "", "isLocationPermissionGranted", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMapReady", "googleMap", "onResume", "onViewCreated", "view", "requestLocationPermission", "app_debug"})
public final class Mapa extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.OnMapReadyCallback {
    private com.gammasoft.busfinder.databinding.FragmentMapaBinding _binding;
    private com.gammasoft.busfinder.controller.MapaEvento evento;
    private com.google.android.gms.maps.GoogleMap map;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermission = null;
    
    public Mapa() {
        super();
    }
    
    private final com.gammasoft.busfinder.databinding.FragmentMapaBinding getBinding() {
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
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    private final boolean isLocationPermissionGranted() {
        return false;
    }
    
    private final void requestLocationPermission() {
    }
    
    private final void activarLocalizacion() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}