package com.gammasoft.busfinder.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/gammasoft/busfinder/controller/MapaEvento;", "Lcom/google/android/gms/maps/GoogleMap$OnMyLocationButtonClickListener;", "Lcom/google/android/gms/maps/GoogleMap$OnMyLocationClickListener;", "fragment", "Landroidx/fragment/app/Fragment;", "mapa", "Lcom/google/android/gms/maps/GoogleMap;", "(Landroidx/fragment/app/Fragment;Lcom/google/android/gms/maps/GoogleMap;)V", "onMyLocationButtonClick", "", "onMyLocationClick", "", "coordenadas", "Landroid/location/Location;", "app_debug"})
public final class MapaEvento implements com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener, com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener {
    private final androidx.fragment.app.Fragment fragment = null;
    private final com.google.android.gms.maps.GoogleMap mapa = null;
    
    public MapaEvento(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap mapa) {
        super();
    }
    
    @java.lang.Override()
    public boolean onMyLocationButtonClick() {
        return false;
    }
    
    @java.lang.Override()
    public void onMyLocationClick(@org.jetbrains.annotations.NotNull()
    android.location.Location coordenadas) {
    }
}