package com.gammasoft.busfinder.view.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a8\u0006\t"}, d2 = {"Lcom/gammasoft/busfinder/view/dialog/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "onBackPressed", "", "smartDismiss", "", "afterDismissAction", "Lkotlin/Function0;", "app_debug"})
public abstract class BaseDialogFragment extends androidx.fragment.app.DialogFragment {
    
    public BaseDialogFragment() {
        super();
    }
    
    @kotlin.Suppress(names = {"DeferredResultUnused"})
    public final void smartDismiss(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> afterDismissAction) {
    }
    
    public boolean onBackPressed() {
        return false;
    }
}