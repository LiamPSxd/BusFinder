package com.gammasoft.busfinder.view.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/gammasoft/busfinder/view/util/DebouncingClickListener;", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "onDebouncingClick", "view", "Companion", "app_debug"})
public abstract interface DebouncingClickListener extends android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.view.util.DebouncingClickListener.Companion Companion = null;
    
    @java.lang.Override()
    public abstract void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v);
    
    public abstract void onDebouncingClick(@org.jetbrains.annotations.NotNull()
    android.view.View view);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
        
        @java.lang.Override()
        public static void onClick(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.view.util.DebouncingClickListener $this, @org.jetbrains.annotations.NotNull()
        android.view.View v) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/gammasoft/busfinder/view/util/DebouncingClickListener$Companion;", "", "()V", "ENABLE_AGAIN", "Lkotlin/Function0;", "", "enabled", "", "getEnabled$app_debug", "()Z", "setEnabled$app_debug", "(Z)V", "app_debug"})
    public static final class Companion {
        private static boolean enabled = true;
        private static final kotlin.jvm.functions.Function0<kotlin.Unit> ENABLE_AGAIN = null;
        
        private Companion() {
            super();
        }
        
        public final boolean getEnabled$app_debug() {
            return false;
        }
        
        public final void setEnabled$app_debug(boolean p0) {
        }
    }
}