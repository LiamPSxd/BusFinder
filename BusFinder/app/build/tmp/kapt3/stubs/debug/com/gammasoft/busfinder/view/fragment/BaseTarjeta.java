package com.gammasoft.busfinder.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\u000eH\'J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\fH\u0017J\b\u0010\u0014\u001a\u00020\fH\u0017J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0016J\u0017\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020$H\u0002\u00a2\u0006\u0002\u0010%R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006&"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/BaseTarjeta;", "Lcom/gammasoft/busfinder/view/fragment/Base;", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBaseContenedor;", "()V", "isBlurEnabled", "", "()Z", "setBlurEnabled", "(Z)V", "isInForeGround", "setInForeGround", "dispose", "", "dragHandleId", "", "getBackgroundBlurLayout", "Landroid/view/ViewGroup;", "getDragView", "Landroid/view/View;", "moveToBackGround", "moveToForeGround", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "parentActivity", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "pushFragment", "base", "isAddToBackStack", "pushPopup", "dialogFragment", "Lcom/gammasoft/busfinder/view/dialog/BaseDialogFragment;", "setupSwipeDownGesture", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)Lkotlin/Unit;", "app_debug"})
public abstract class BaseTarjeta extends com.gammasoft.busfinder.view.fragment.Base implements com.gammasoft.busfinder.view.fragment.TarjetaBaseContenedor {
    private boolean isBlurEnabled = true;
    private boolean isInForeGround = false;
    
    public BaseTarjeta() {
        super();
    }
    
    protected final boolean isBlurEnabled() {
        return false;
    }
    
    protected final void setBlurEnabled(boolean p0) {
    }
    
    public final boolean isInForeGround() {
        return false;
    }
    
    public final void setInForeGround(boolean p0) {
    }
    
    @androidx.annotation.CallSuper()
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final kotlin.Unit setupSwipeDownGesture(android.app.Activity activity) {
        return null;
    }
    
    @androidx.annotation.CallSuper()
    @java.lang.Override()
    public void moveToBackGround() {
    }
    
    @androidx.annotation.CallSuper()
    @java.lang.Override()
    public void moveToForeGround() {
    }
    
    @androidx.annotation.CallSuper()
    public void dispose() {
    }
    
    public void pushFragment(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.fragment.Base base, boolean isAddToBackStack) {
    }
    
    public void pushPopup(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.dialog.BaseDialogFragment dialogFragment) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.view.ViewGroup getBackgroundBlurLayout();
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.view.View getDragView();
    
    @androidx.annotation.IdRes()
    public abstract int dragHandleId();
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.gammasoft.busfinder.view.fragment.TarjetaBase parentActivity() {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}