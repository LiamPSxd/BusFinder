package com.gammasoft.busfinder.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u0000 52\u00020\u0001:\u0003567B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J \u0010&\u001a\u00020\u000e2\u0006\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0011H\u0002J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020\u000eH\u0016J\b\u0010-\u001a\u00020\u001eH&J\b\u0010.\u001a\u00020\u001eH\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\u0018\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0017J\b\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020\u001eH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/gammasoft/busfinder/controller/SwipeEvento;", "Landroid/view/View$OnTouchListener;", "activity", "Landroid/app/Activity;", "dragView", "Landroid/view/View;", "rootView", "backgroundLayout", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/view/View;Landroid/view/View;Landroid/view/ViewGroup;)V", "backgroundView", "gestureDetector", "Landroid/view/GestureDetector;", "isDragging", "", "isFlingInProgress", "motionOriginX", "", "motionOriginY", "percentX", "getPercentX", "()F", "percentY", "getPercentY", "screenHeight", "", "screenWidth", "viewOriginX", "viewOriginY", "discard", "", "eventUpY", "handleActionDown", "event", "Landroid/view/MotionEvent;", "handleActionMove", "translationY", "handleActionUp", "handleFling", "e1", "e2", "velocityY", "moveToOrigin", "view", "onSingleTap", "onSwipeDown", "onSwipeLeft", "onSwipeRight", "onSwipeUp", "onTouch", "v", "reset", "resetBackgroundView", "Companion", "Quadrant", "SwipeDirection", "app_debug"})
public abstract class SwipeEvento implements android.view.View.OnTouchListener {
    private final android.view.View dragView = null;
    private final android.view.View rootView = null;
    private final android.view.GestureDetector gestureDetector = null;
    private final int screenHeight = 0;
    private final float screenWidth = 0.0F;
    private android.view.View backgroundLayout;
    private android.view.View backgroundView;
    private float motionOriginX = 0.0F;
    private float motionOriginY = 0.0F;
    private boolean isDragging = false;
    private final float viewOriginX = 0.0F;
    private float viewOriginY = 0.0F;
    private boolean isFlingInProgress = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.controller.SwipeEvento.Companion Companion = null;
    private static final java.util.List<com.gammasoft.busfinder.controller.SwipeEvento.SwipeDirection> FREEDOM_NO_TOP = null;
    private static final java.util.List<com.gammasoft.busfinder.controller.SwipeEvento.SwipeDirection> HORIZONTAL = null;
    private static final java.util.List<com.gammasoft.busfinder.controller.SwipeEvento.SwipeDirection> VERTICAL = null;
    
    public SwipeEvento(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.view.View dragView, @org.jetbrains.annotations.NotNull()
    android.view.View rootView, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup backgroundLayout) {
        super();
    }
    
    private final float getPercentX() {
        return 0.0F;
    }
    
    private final float getPercentY() {
        return 0.0F;
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override()
    public boolean onTouch(@org.jetbrains.annotations.NotNull()
    android.view.View v, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    private final boolean handleFling(android.view.MotionEvent e1, android.view.MotionEvent e2, float velocityY) {
        return false;
    }
    
    private final void handleActionDown(android.view.MotionEvent event) {
    }
    
    private final void handleActionUp(android.view.MotionEvent event) {
    }
    
    private final void handleActionMove(float translationY) {
    }
    
    private final void reset() {
    }
    
    private final void moveToOrigin(android.view.View view) {
    }
    
    private final void resetBackgroundView() {
    }
    
    private final void discard(float eventUpY) {
    }
    
    public void onSwipeLeft() {
    }
    
    public void onSwipeRight() {
    }
    
    public void onSwipeUp() {
    }
    
    public abstract void onSwipeDown();
    
    public boolean onSingleTap() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/gammasoft/busfinder/controller/SwipeEvento$SwipeDirection;", "", "(Ljava/lang/String;I)V", "Left", "Right", "Up", "Down", "app_debug"})
    public static enum SwipeDirection {
        /*public static final*/ Left /* = new Left() */,
        /*public static final*/ Right /* = new Right() */,
        /*public static final*/ Up /* = new Up() */,
        /*public static final*/ Down /* = new Down() */;
        
        SwipeDirection() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/gammasoft/busfinder/controller/SwipeEvento$Quadrant;", "", "(Ljava/lang/String;I)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "app_debug"})
    public static enum Quadrant {
        /*public static final*/ TOP_LEFT /* = new TOP_LEFT() */,
        /*public static final*/ TOP_RIGHT /* = new TOP_RIGHT() */,
        /*public static final*/ BOTTOM_LEFT /* = new BOTTOM_LEFT() */,
        /*public static final*/ BOTTOM_RIGHT /* = new BOTTOM_RIGHT() */;
        
        Quadrant() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/gammasoft/busfinder/controller/SwipeEvento$Companion;", "", "()V", "FREEDOM_NO_TOP", "", "Lcom/gammasoft/busfinder/controller/SwipeEvento$SwipeDirection;", "HORIZONTAL", "VERTICAL", "from", "value", "", "getQuadrant", "Lcom/gammasoft/busfinder/controller/SwipeEvento$Quadrant;", "x1", "", "y1", "x2", "y2", "getRadian", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.gammasoft.busfinder.controller.SwipeEvento.SwipeDirection> from(int value) {
            return null;
        }
        
        private final double getRadian(float x1, float y1, float x2, float y2) {
            return 0.0;
        }
        
        private final com.gammasoft.busfinder.controller.SwipeEvento.Quadrant getQuadrant(float x1, float y1, float x2, float y2) {
            return null;
        }
    }
}