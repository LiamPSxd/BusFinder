package com.gammasoft.busfinder.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u00012\b\b\u0003\u0010\u0018\u001a\u00020\u00192\b\b\u0003\u0010\u001a\u001a\u00020\u0019J$\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J,\u0010%\u001a\u00020\"2\"\u0010&\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070(0\'j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070(`)H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/ListaTarjeta;", "Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "fragment", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "bin", "Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;", "titulo", "", "localDB", "Lcom/gammasoft/busfinder/model/dbLocal/Crud;", "(Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;Lcom/gammasoft/busfinder/databinding/FragmentAdministradorBinding;Ljava/lang/String;Lcom/gammasoft/busfinder/model/dbLocal/Crud;)V", "_binding", "Lcom/gammasoft/busfinder/databinding/FragmentListaTarjetaBinding;", "binding", "getBinding", "()Lcom/gammasoft/busfinder/databinding/FragmentListaTarjetaBinding;", "getBackgroundLayout", "Landroid/view/ViewGroup;", "getBlurLayout", "Lio/alterac/blurkit/BlurLayout;", "getDragHandle", "Landroid/view/View;", "getRootView", "mostrar", "enterAnim", "", "exitAnim", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "reformatear", "ides", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "app_debug"})
public final class ListaTarjeta extends com.gammasoft.busfinder.view.dialog.BaseBlurPopup {
    private final com.gammasoft.busfinder.view.fragment.TarjetaBase fragment = null;
    private final com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin = null;
    private final java.lang.String titulo = null;
    private final com.gammasoft.busfinder.model.dbLocal.Crud localDB = null;
    private com.gammasoft.busfinder.databinding.FragmentListaTarjetaBinding _binding;
    
    public ListaTarjeta(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.fragment.TarjetaBase fragment, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.databinding.FragmentAdministradorBinding bin, @org.jetbrains.annotations.NotNull()
    java.lang.String titulo, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.model.dbLocal.Crud localDB) {
        super();
    }
    
    private final com.gammasoft.busfinder.databinding.FragmentListaTarjetaBinding getBinding() {
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
    
    private final void reformatear(java.util.ArrayList<java.util.List<java.lang.String>> ides) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
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
    public android.view.ViewGroup getRootView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.ViewGroup getBackgroundLayout() {
        return null;
    }
}