package com.gammasoft.busfinder.controller.longpress;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/gammasoft/busfinder/controller/longpress/RunnableMotionEvent;", "Ljava/lang/Runnable;", "()V", "lastMotionEvent", "Landroid/view/MotionEvent;", "getLastMotionEvent", "()Landroid/view/MotionEvent;", "setLastMotionEvent", "(Landroid/view/MotionEvent;)V", "startView", "Landroid/view/View;", "getStartView", "()Landroid/view/View;", "setStartView", "(Landroid/view/View;)V", "app_debug"})
public abstract class RunnableMotionEvent implements java.lang.Runnable {
    @org.jetbrains.annotations.Nullable()
    private android.view.MotionEvent lastMotionEvent;
    @org.jetbrains.annotations.Nullable()
    private android.view.View startView;
    
    public RunnableMotionEvent() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.MotionEvent getLastMotionEvent() {
        return null;
    }
    
    public final void setLastMotionEvent(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getStartView() {
        return null;
    }
    
    public final void setStartView(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
}