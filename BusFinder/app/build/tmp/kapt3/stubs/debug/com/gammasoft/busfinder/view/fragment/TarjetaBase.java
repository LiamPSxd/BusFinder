package com.gammasoft.busfinder.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\'J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "Landroidx/fragment/app/Fragment;", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "getFragmentContainer", "onBackPressed", "", "popBackStack", "pushFragment", "fragment", "Lcom/gammasoft/busfinder/view/fragment/Base;", "isAddToBackStack", "", "pushPopup", "popupDialog", "Lcom/gammasoft/busfinder/view/dialog/BaseDialogFragment;", "removeActivePopupsIfAny", "startPoppingFragment", "app_debug"})
public abstract class TarjetaBase extends androidx.fragment.app.Fragment {
    private int index = 0;
    
    public TarjetaBase() {
        super();
    }
    
    public final int getIndex() {
        return 0;
    }
    
    public final void setIndex(int p0) {
    }
    
    public final void pushPopup(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.dialog.BaseDialogFragment popupDialog) {
    }
    
    public final void pushFragment(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.fragment.Base fragment, boolean isAddToBackStack) {
    }
    
    public final void popBackStack() {
    }
    
    private final void startPoppingFragment() {
    }
    
    @androidx.annotation.IdRes()
    public abstract int getFragmentContainer();
    
    private final boolean removeActivePopupsIfAny() {
        return false;
    }
    
    public final void onBackPressed() {
    }
}