package com.gammasoft.busfinder.controller.longpress;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u0010"}, d2 = {"Lcom/gammasoft/busfinder/controller/longpress/PopupInterface;", "", "onLongPressContinue", "", "longPressTime", "", "motionEvent", "Landroid/view/MotionEvent;", "onLongPressEnd", "onLongPressStart", "onPressContinue", "progress", "onPressStart", "pressedView", "Landroid/view/View;", "onPressStop", "app_debug"})
public abstract interface PopupInterface {
    
    public abstract void onPressStart(@org.jetbrains.annotations.NotNull()
    android.view.View pressedView, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent);
    
    public abstract void onPressContinue(int progress, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent);
    
    public abstract void onPressStop(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent motionEvent);
    
    public abstract void onLongPressStart(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent);
    
    public abstract void onLongPressContinue(int longPressTime, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent);
    
    public abstract void onLongPressEnd(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent);
}