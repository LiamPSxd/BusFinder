package com.gammasoft.busfinder.view.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0004\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0004\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\b2\b\b\u0001\u0010\u0006\u001a\u00020\u0004\u001a\"\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r\u001a\'\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r\u00a2\u0006\u0002\u0010\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010\u001a \u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0007*\u00020\u0014H\u0086\b\u00a2\u0006\u0002\u0010\u0015\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0018\u001a\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u0007\u00a2\u0006\u0002\u0010\u001b\u001a\u0012\u0010\u001c\u001a\u00020\u001a*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007\u001a\u0018\u0010\u001f\u001a\u00020\u0001*\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r\u001a\n\u0010 \u001a\u00020\u0001*\u00020\u0007\u001a\u001f\u0010 \u001a\u00020\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00130!\u00a2\u0006\u0002\u0010\"\u001a\n\u0010#\u001a\u00020\u0001*\u00020\u0007\u001a\u001f\u0010#\u001a\u00020\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00130!\u00a2\u0006\u0002\u0010\"\u001a\n\u0010$\u001a\u00020\u0001*\u00020\u0007\u001a\u001f\u0010$\u001a\u00020\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00130!\u00a2\u0006\u0002\u0010\"\u001aL\u0010%\u001a\u00020\u0001\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00130!2#\b\u0004\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00010&H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)\u001a2\u0010*\u001a\u00020\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0007*\u0002H\u00132\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00010&\u00a2\u0006\u0002\b+\u00a2\u0006\u0002\u0010,\u001a!\u0010*\u001a\u00020\u0001\"\b\b\u0000\u0010\u0013*\u00020\u0007*\u0002H\u00132\u0006\u0010-\u001a\u00020.\u00a2\u0006\u0002\u0010/\u001aH\u00100\u001a\u00020\u0001*\u00020\u00072\u0006\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00142\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\r\u001a\u0014\u00107\u001a\u00020\u0001*\u0002082\b\b\u0001\u00109\u001a\u00020\u0004\u001a\u0012\u0010:\u001a\u000208*\u0002082\u0006\u0010;\u001a\u00020\u001a\u001a?\u0010<\u001a\u00020\u0001*\u00020\u00072\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010A\u001a(\u0010B\u001a\u00020\u0001*\u00020\u00072\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0014\u001ap\u0010C\u001a\u00020\u0001*\u00020\u00072\u0006\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00142\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010\r\u001a\u0011\u0010G\u001a\u0004\u0018\u00010\u001a*\u00020\u0007\u00a2\u0006\u0002\u0010\u001b\u001a\u0012\u0010H\u001a\u00020\u0001*\u00020\u00072\u0006\u0010I\u001a\u00020\u001a\u001a\u0012\u0010J\u001a\u00020\u0001*\u00020\u00052\u0006\u0010K\u001a\u00020\u000b\u001a\u0012\u0010J\u001a\u00020\u0001*\u00020\u00072\u0006\u0010K\u001a\u00020\u000b\u001a\u0014\u0010L\u001a\u000208*\u0002082\b\b\u0001\u00109\u001a\u00020\u0004\u001a\u0014\u0010M\u001a\u000208*\u0002082\b\b\u0001\u0010N\u001a\u00020\u0004\u001a\u0014\u0010O\u001a\u000208*\u0002082\b\b\u0001\u0010P\u001a\u00020\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006Q"}, d2 = {"checkAndUnregister", "", "Lcom/gammasoft/busfinder/view/dialog/BlurPopup;", "colorOf", "", "Landroid/content/Context;", "color", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "doAfterDelay", "delayMillis", "", "action", "Lkotlin/Function0;", "(Landroidx/fragment/app/Fragment;JLkotlin/jvm/functions/Function0;)Lkotlin/Unit;", "getDp", "", "dp", "getIfPresent", "T", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)Landroid/view/View;", "getScreenSize", "", "Landroid/view/Display;", "hideSoftKeyboard", "", "(Landroid/view/View;)Ljava/lang/Boolean;", "isTouchInsideView", "Landroid/view/MotionEvent;", "view", "longClickWithVibrate", "makeGone", "", "([Landroid/view/View;)V", "makeInvisible", "makeVisible", "onClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "([Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "onDebouncingClick", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "listener", "Lcom/gammasoft/busfinder/view/util/DebouncingClickListener;", "(Landroid/view/View;Lcom/gammasoft/busfinder/view/util/DebouncingClickListener;)V", "onSwipeDown", "activity", "Landroid/app/Activity;", "rootView", "backgroundLayout", "swipeDownAction", "singleTapAction", "resolveEnterExitAnim", "Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "animType", "setDismissOnTouchOutside", "dismissOnTouchingOutside", "setMargin", "left", "top", "right", "bottom", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setSwipeDownListener", "setSwipeListener", "swipeUpAction", "swipeLeftAction", "swipeRightAction", "showSoftKeyboard", "toggleInteraction", "isEnabled", "vibrate", "millis", "withAnimType", "withEnterAnim", "enterAnim", "withExitAnim", "exitAnim", "app_debug"})
public final class ViewUtilKt {
    
    public static final float getDp(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getDp, float dp) {
        return 0.0F;
    }
    
    public static final float getDp(@org.jetbrains.annotations.NotNull()
    android.view.View $this$getDp, float dp) {
        return 0.0F;
    }
    
    @kotlin.Suppress(names = {"DEPRECATION"})
    public static final int colorOf(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$colorOf, @androidx.annotation.ColorRes()
    int color) {
        return 0;
    }
    
    public static final int colorOf(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$colorOf, @androidx.annotation.ColorRes()
    int color) {
        return 0;
    }
    
    public static final int colorOf(@org.jetbrains.annotations.NotNull()
    android.view.View $this$colorOf, @androidx.annotation.ColorRes()
    int color) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final int[] getScreenSize(@org.jetbrains.annotations.NotNull()
    android.view.Display $this$getScreenSize) {
        return null;
    }
    
    public static final void makeVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$makeVisible) {
    }
    
    public static final void makeInvisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$makeInvisible) {
    }
    
    public static final void makeGone(@org.jetbrains.annotations.NotNull()
    android.view.View $this$makeGone) {
    }
    
    public static final <T extends android.view.View>void makeVisible(@org.jetbrains.annotations.NotNull()
    T[] $this$makeVisible) {
    }
    
    public static final <T extends android.view.View>void makeInvisible(@org.jetbrains.annotations.NotNull()
    T[] $this$makeInvisible) {
    }
    
    public static final <T extends android.view.View>void makeGone(@org.jetbrains.annotations.NotNull()
    T[] $this$makeGone) {
    }
    
    public static final void toggleInteraction(@org.jetbrains.annotations.NotNull()
    android.view.View $this$toggleInteraction, boolean isEnabled) {
    }
    
    public static final void setSwipeDownListener(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setSwipeDownListener, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    android.view.View rootView, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup backgroundLayout) {
    }
    
    public static final void onSwipeDown(@org.jetbrains.annotations.NotNull()
    android.view.View $this$onSwipeDown, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    android.view.View rootView, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup backgroundLayout, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> swipeDownAction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> singleTapAction) {
    }
    
    public static final void setSwipeListener(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setSwipeListener, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    android.view.View rootView, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup backgroundLayout, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> swipeDownAction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> singleTapAction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> swipeUpAction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> swipeLeftAction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> swipeRightAction) {
    }
    
    public static final void setMargin(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setMargin, @org.jetbrains.annotations.Nullable()
    java.lang.Integer left, @org.jetbrains.annotations.Nullable()
    java.lang.Integer top, @org.jetbrains.annotations.Nullable()
    java.lang.Integer right, @org.jetbrains.annotations.Nullable()
    java.lang.Integer bottom) {
    }
    
    public static final void vibrate(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$vibrate, long millis) {
    }
    
    public static final void vibrate(@org.jetbrains.annotations.NotNull()
    android.view.View $this$vibrate, long millis) {
    }
    
    public static final void longClickWithVibrate(@org.jetbrains.annotations.NotNull()
    android.view.View $this$longClickWithVibrate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
    }
    
    public static final <T extends android.view.View>void onDebouncingClick(@org.jetbrains.annotations.NotNull()
    T $this$onDebouncingClick, @org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.util.DebouncingClickListener listener) {
    }
    
    public static final <T extends android.view.View>void onDebouncingClick(@org.jetbrains.annotations.NotNull()
    T $this$onDebouncingClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> action) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final kotlin.Unit doAfterDelay(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$doAfterDelay, long delayMillis, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
        return null;
    }
    
    @kotlin.Suppress(names = {"DeferredResultUnused"})
    public static final void doAfterDelay(@org.jetbrains.annotations.Nullable()
    android.content.Context $this$doAfterDelay, long delayMillis, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Boolean hideSoftKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View $this$hideSoftKeyboard) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Boolean showSoftKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View $this$showSoftKeyboard) {
        return null;
    }
    
    public static final boolean isTouchInsideView(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent $this$isTouchInsideView, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
        return false;
    }
    
    public static final void resolveEnterExitAnim(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.dialog.BaseBlurPopup $this$resolveEnterExitAnim, @com.gammasoft.busfinder.view.dialog.AnimType()
    int animType) {
    }
    
    public static final void checkAndUnregister(@org.jetbrains.annotations.Nullable()
    com.gammasoft.busfinder.view.dialog.BlurPopup $this$checkAndUnregister) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.view.dialog.BaseBlurPopup withEnterAnim(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.dialog.BaseBlurPopup $this$withEnterAnim, @androidx.annotation.AnimRes()
    int enterAnim) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.view.dialog.BaseBlurPopup withExitAnim(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.dialog.BaseBlurPopup $this$withExitAnim, @androidx.annotation.AnimRes()
    int exitAnim) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.view.dialog.BaseBlurPopup withAnimType(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.dialog.BaseBlurPopup $this$withAnimType, @com.gammasoft.busfinder.view.dialog.AnimType()
    int animType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.gammasoft.busfinder.view.dialog.BaseBlurPopup setDismissOnTouchOutside(@org.jetbrains.annotations.NotNull()
    com.gammasoft.busfinder.view.dialog.BaseBlurPopup $this$setDismissOnTouchOutside, boolean dismissOnTouchingOutside) {
        return null;
    }
}