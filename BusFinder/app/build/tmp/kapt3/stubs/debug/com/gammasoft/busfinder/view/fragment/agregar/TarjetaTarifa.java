package com.gammasoft.busfinder.view.fragment.agregar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010\u0018\u001a\u00020\u00012\b\b\u0003\u0010\u0019\u001a\u00020\u001a2\b\b\u0003\u0010\u001b\u001a\u00020\u001aJ$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J0\u0010$\u001a\u00020#2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010\u00162\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u0016\u0010+\u001a\u00020#2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0016J\u001a\u0010,\u001a\u00020#2\u0006\u0010\'\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/agregar/TarjetaTarifa;", "Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "bin", "Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;", "(Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;)V", "_binding", "Lcom/gammasoft/busfinder/databinding/TarjetaAgregarTarifaBinding;", "binding", "getBinding", "()Lcom/gammasoft/busfinder/databinding/TarjetaAgregarTarifaBinding;", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "prefs", "Landroid/content/SharedPreferences;", "tarifa", "", "getBackgroundLayout", "Landroid/view/ViewGroup;", "getBlurLayout", "Lio/alterac/blurkit/BlurLayout;", "getDragHandle", "Landroid/view/View;", "getRootView", "mostrar", "enterAnim", "", "exitAnim", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onItemSelected", "parent", "Landroid/widget/AdapterView;", "view", "position", "id", "", "onNothingSelected", "onViewCreated", "app_debug"})
public final class TarjetaTarifa extends com.gammasoft.busfinder.view.dialog.BaseBlurPopup implements android.widget.AdapterView.OnItemSelectedListener {
    private final com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin = null;
    private com.gammasoft.busfinder.databinding.TarjetaAgregarTarifaBinding _binding;
    private android.content.SharedPreferences prefs;
    private com.gammasoft.busfinder.model.dbLocal.Crud localDB;
    private java.lang.String tarifa = "";
    
    public TarjetaTarifa(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin) {
        super();
    }
    
    private final com.gammasoft.busfinder.databinding.TarjetaAgregarTarifaBinding getBinding() {
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