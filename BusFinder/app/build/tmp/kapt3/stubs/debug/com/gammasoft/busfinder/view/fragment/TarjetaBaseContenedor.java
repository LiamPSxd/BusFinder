package com.gammasoft.busfinder.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/TarjetaBaseContenedor;", "", "getRootView", "Landroid/view/ViewGroup;", "moveToBackGround", "", "moveToForeGround", "parentActivity", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "app_debug"})
public abstract interface TarjetaBaseContenedor {
    
    @org.jetbrains.annotations.Nullable()
    public abstract android.view.ViewGroup getRootView();
    
    public abstract void moveToBackGround();
    
    public abstract void moveToForeGround();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gammasoft.busfinder.view.fragment.TarjetaBase parentActivity();
}