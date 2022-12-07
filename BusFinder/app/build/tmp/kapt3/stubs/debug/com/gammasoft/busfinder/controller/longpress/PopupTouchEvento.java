package com.gammasoft.busfinder.controller.longpress;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001eJ\u001a\u0010\"\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010&\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\'\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010)\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/gammasoft/busfinder/controller/longpress/PopupTouchEvento;", "Landroid/view/View$OnTouchListener;", "mPressPopupInterface", "Lcom/gammasoft/busfinder/controller/longpress/PopupInterface;", "mLongPressDuration", "", "(Lcom/gammasoft/busfinder/controller/longpress/PopupInterface;I)V", "isVibrationEnabled", "", "mCurrentPressStatus", "getMCurrentPressStatus$annotations", "()V", "mLongPressHandler", "Landroid/os/Handler;", "mLongPressRunnable", "Lcom/gammasoft/busfinder/controller/longpress/RunnableMotionEvent;", "mStartPressTimestamp", "", "vibrationDurationMillis", "continueLongPress", "", "motionEvent", "Landroid/view/MotionEvent;", "longPressDuration", "continuePress", "pressStatus", "getLongPressDuration", "getPressStatusPercentage", "onTouch", "view", "Landroid/view/View;", "resetPressVariables", "setOn", "targetView", "startLongPress", "startPress", "touchedView", "stopLongPress", "stopPress", "updateLastMotionEventRunnable", "updateRunnableView", "withVibration", "durationMillis", "Companion", "PressStatus", "app_debug"})
public final class PopupTouchEvento implements android.view.View.OnTouchListener {
    private final com.gammasoft.busfinder.controller.longpress.PopupInterface mPressPopupInterface = null;
    private final int mLongPressDuration = 0;
    private boolean isVibrationEnabled = false;
    private long vibrationDurationMillis = 50L;
    private int mCurrentPressStatus = 0;
    private long mStartPressTimestamp = 0L;
    private final android.os.Handler mLongPressHandler = null;
    private final com.gammasoft.busfinder.controller.longpress.RunnableMotionEvent mLongPressRunnable = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.controller.longpress.PopupTouchEvento.Companion Companion = null;
    private static final long DEFAULT_VIBRATION_DURATION = 50L;
    public static final int DEFAULT_LONG_PRESS_DURATION = 350;
    
    public PopupTouchEvento(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.controller.longpress.PopupInterface mPressPopupInterface, int mLongPressDuration) {
        super();
    }
    
    @com.gammasoft.busfinder.controller.longpress.PopupTouchEvento.PressStatus()
    @java.lang.Deprecated()
    private static void getMCurrentPressStatus$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.controller.longpress.PopupTouchEvento withVibration(long durationMillis) {
        return null;
    }
    
    public final void setOn(@org.jetbrains.annotations.NotNull()
    android.view.View targetView) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override()
    public boolean onTouch(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent) {
        return false;
    }
    
    private final void startPress(android.view.View touchedView, android.view.MotionEvent motionEvent) {
    }
    
    private final void continuePress(android.view.MotionEvent motionEvent, int pressStatus) {
    }
    
    public final void stopPress(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent motionEvent) {
    }
    
    private final void startLongPress(android.view.View view, android.view.MotionEvent motionEvent) {
    }
    
    private final void continueLongPress(android.view.MotionEvent motionEvent, int longPressDuration) {
    }
    
    private final void stopLongPress(android.view.MotionEvent motionEvent) {
    }
    
    private final void updateLastMotionEventRunnable(android.view.MotionEvent motionEvent) {
    }
    
    private final void updateRunnableView(android.view.View view) {
    }
    
    private final void resetPressVariables() {
    }
    
    private final int getLongPressDuration() {
        return 0;
    }
    
    private final int getPressStatusPercentage() {
        return 0;
    }
    
    @androidx.annotation.IntDef(value = {0, 1, 2})
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0083\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/gammasoft/busfinder/controller/longpress/PopupTouchEvento$PressStatus;", "", "Companion", "app_debug"})
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention()
    static abstract @interface PressStatus {
        @org.jetbrains.annotations.NotNull()
        public static final com.gammasoft.busfinder.controller.longpress.PopupTouchEvento.PressStatus.Companion Companion = null;
        public static final int STATUS_NOT_PRESSED = 0;
        public static final int STATUS_PRESSING = 1;
        public static final int STATUS_LONG_PRESSING = 2;
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/gammasoft/busfinder/controller/longpress/PopupTouchEvento$PressStatus$Companion;", "", "()V", "STATUS_LONG_PRESSING", "", "STATUS_NOT_PRESSED", "STATUS_PRESSING", "app_debug"})
        public static final class Companion {
            public static final int STATUS_NOT_PRESSED = 0;
            public static final int STATUS_PRESSING = 1;
            public static final int STATUS_LONG_PRESSING = 2;
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/gammasoft/busfinder/controller/longpress/PopupTouchEvento$Companion;", "", "()V", "DEFAULT_LONG_PRESS_DURATION", "", "DEFAULT_VIBRATION_DURATION", "", "inside", "Lcom/gammasoft/busfinder/controller/longpress/PopupTouchEvento;", "popupInterface", "Lcom/gammasoft/busfinder/controller/longpress/PopupInterface;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.controller.longpress.PopupTouchEvento inside(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.controller.longpress.PopupInterface popupInterface) {
            return null;
        }
    }
}