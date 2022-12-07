package com.gammasoft.busfinder.view.dialog;

import java.lang.System;

@kotlin.Suppress(names = {"MemberVisibilityCanBePrivate", "unused"})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001:\u0001XB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010A\u001a\u00020BH\u0002J\u0006\u0010C\u001a\u00020BJ\u0018\u0010D\u001a\u00020B2\u0006\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020B2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010I\u001a\u00020B2\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020\u00062\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020GH\u0016J\u0012\u0010N\u001a\u00020B2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010O\u001a\u00020BH\u0017J\b\u0010P\u001a\u00020BH\u0002J\u0006\u0010Q\u001a\u00020BJ\b\u0010R\u001a\u00020BH\u0017J\u0016\u0010S\u001a\u00020B*\u0004\u0018\u00010<2\u0006\u0010F\u001a\u00020GH\u0002J\u0016\u0010T\u001a\u00020B*\u0004\u0018\u00010<2\u0006\u0010F\u001a\u00020GH\u0002J\f\u0010U\u001a\u00020\u0014*\u00020\u000eH\u0002J\f\u0010V\u001a\u00020B*\u00020\u000eH\u0002J\f\u0010W\u001a\u00020B*\u00020\u000eH\u0002R\u0016\u0010\u0005\u001a\u00020\u00068\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010%\u001a\u0004\u0018\u00010&X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010*X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010.X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u000202X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010;\u001a\u0004\u0018\u00010<X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u000eX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0010\u00a8\u0006Y"}, d2 = {"Lcom/gammasoft/busfinder/view/dialog/BlurPopup;", "Lcom/gammasoft/busfinder/controller/longpress/PopupInterface;", "builder", "Lcom/gammasoft/busfinder/view/dialog/BlurPopup$Builder;", "(Lcom/gammasoft/busfinder/view/dialog/BlurPopup$Builder;)V", "animationType", "", "getAnimationType$annotations", "()V", "baseBlurPopup", "Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "getBaseBlurPopup$app_debug", "()Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "initialPressedView", "Landroid/view/View;", "getInitialPressedView$app_debug", "()Landroid/view/View;", "setInitialPressedView$app_debug", "(Landroid/view/View;)V", "isCancelTouchOnDragOutsideView", "", "isDismissOnLongPressStop", "isDismissOnTouchOutside", "isDispatchTouchEventOnRelease", "isRegistered", "()Z", "setRegistered", "(Z)V", "longPressDuration", "longPressReleaseClickListener", "Landroid/view/View$OnClickListener;", "getLongPressReleaseClickListener$app_debug", "()Landroid/view/View$OnClickListener;", "parentActivity", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "getParentActivity$app_debug", "()Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "popupHoverEvento", "Lcom/gammasoft/busfinder/controller/longpress/PopupHoverEvento;", "getPopupHoverEvento$app_debug", "()Lcom/gammasoft/busfinder/controller/longpress/PopupHoverEvento;", "popupInflaterEvento", "Lcom/gammasoft/busfinder/controller/longpress/PopupInflaterEvento;", "getPopupInflaterEvento$app_debug", "()Lcom/gammasoft/busfinder/controller/longpress/PopupInflaterEvento;", "popupStateEvento", "Lcom/gammasoft/busfinder/controller/longpress/PopupStateEvento;", "getPopupStateEvento$app_debug", "()Lcom/gammasoft/busfinder/controller/longpress/PopupStateEvento;", "popupTag", "", "getPopupTag$app_debug", "()Ljava/lang/String;", "popupTouchEvento", "Lcom/gammasoft/busfinder/controller/longpress/PopupTouchEvento;", "getPopupTouchEvento$app_debug", "()Lcom/gammasoft/busfinder/controller/longpress/PopupTouchEvento;", "setPopupTouchEvento$app_debug", "(Lcom/gammasoft/busfinder/controller/longpress/PopupTouchEvento;)V", "rootPopupView", "Landroid/view/ViewGroup;", "getRootPopupView$app_debug", "()Landroid/view/ViewGroup;", "targetView", "getTargetView$app_debug", "dismissBlurPopup", "", "dismissNow", "onLongPressContinue", "longPressTime", "motionEvent", "Landroid/view/MotionEvent;", "onLongPressEnd", "onLongPressStart", "onPressContinue", "progress", "onPressStart", "pressedView", "onPressStop", "register", "showBlurPopup", "showNow", "unregister", "dispatchActiveFocusToLeavesOnly", "dispatchClickToLeavesOnly", "isInFocus", "removeFocus", "setFocus", "Builder", "app_debug"})
public class BlurPopup implements com.gammasoft.busfinder.controller.longpress.PopupInterface {
    @org.jetbrains.annotations.NotNull()
    private final com.gammasoft.busfinder.view.dialog.BaseBlurPopup baseBlurPopup = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gammasoft.busfinder.view.fragment.TarjetaBase parentActivity = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String popupTag = null;
    @org.jetbrains.annotations.NotNull()
    private final android.view.View targetView = null;
    @org.jetbrains.annotations.Nullable()
    private final android.view.ViewGroup rootPopupView = null;
    @org.jetbrains.annotations.Nullable()
    private android.view.View initialPressedView;
    @org.jetbrains.annotations.Nullable()
    private final com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento popupInflaterEvento = null;
    @org.jetbrains.annotations.Nullable()
    private final android.view.View.OnClickListener longPressReleaseClickListener = null;
    @org.jetbrains.annotations.Nullable()
    private final com.gammasoft.busfinder.controller.longpress.PopupHoverEvento popupHoverEvento = null;
    @org.jetbrains.annotations.Nullable()
    private final com.gammasoft.busfinder.controller.longpress.PopupStateEvento popupStateEvento = null;
    @org.jetbrains.annotations.Nullable()
    private com.gammasoft.busfinder.controller.longpress.PopupTouchEvento popupTouchEvento;
    private final int longPressDuration = 0;
    private final boolean isDismissOnLongPressStop = false;
    private final boolean isDismissOnTouchOutside = false;
    private final boolean isDispatchTouchEventOnRelease = false;
    private final boolean isCancelTouchOnDragOutsideView = false;
    private boolean isRegistered = false;
    private final int animationType = 0;
    
    private BlurPopup(com.gammasoft.busfinder.view.dialog.BlurPopup.Builder builder) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.view.dialog.BaseBlurPopup getBaseBlurPopup$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gammasoft.busfinder.view.fragment.TarjetaBase getParentActivity$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPopupTag$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getTargetView$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.ViewGroup getRootPopupView$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getInitialPressedView$app_debug() {
        return null;
    }
    
    public final void setInitialPressedView$app_debug(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento getPopupInflaterEvento$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View.OnClickListener getLongPressReleaseClickListener$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.gammasoft.busfinder.controller.longpress.PopupHoverEvento getPopupHoverEvento$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.gammasoft.busfinder.controller.longpress.PopupStateEvento getPopupStateEvento$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.gammasoft.busfinder.controller.longpress.PopupTouchEvento getPopupTouchEvento$app_debug() {
        return null;
    }
    
    public final void setPopupTouchEvento$app_debug(@org.jetbrains.annotations.Nullable()
    com.gammasoft.busfinder.controller.longpress.PopupTouchEvento p0) {
    }
    
    public final boolean isRegistered() {
        return false;
    }
    
    public final void setRegistered(boolean p0) {
    }
    
    @AnimType()
    @java.lang.Deprecated()
    private static void getAnimationType$annotations() {
    }
    
    public final void showNow() {
    }
    
    public final void dismissNow() {
    }
    
    @androidx.annotation.CallSuper()
    public void register() {
    }
    
    @androidx.annotation.CallSuper()
    public void unregister() {
    }
    
    private final void showBlurPopup() {
    }
    
    private final void dismissBlurPopup() {
    }
    
    @java.lang.Override()
    public void onPressStart(@org.jetbrains.annotations.NotNull()
    android.view.View pressedView, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent) {
    }
    
    @java.lang.Override()
    public void onPressContinue(int progress, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent) {
    }
    
    @java.lang.Override()
    public void onPressStop(@org.jetbrains.annotations.Nullable()
    android.view.MotionEvent motionEvent) {
    }
    
    @java.lang.Override()
    public void onLongPressStart(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent) {
    }
    
    @java.lang.Override()
    public void onLongPressContinue(int longPressTime, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent) {
    }
    
    @java.lang.Override()
    public void onLongPressEnd(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent motionEvent) {
    }
    
    private final void dispatchActiveFocusToLeavesOnly(android.view.ViewGroup $this$dispatchActiveFocusToLeavesOnly, android.view.MotionEvent motionEvent) {
    }
    
    private final void dispatchClickToLeavesOnly(android.view.ViewGroup $this$dispatchClickToLeavesOnly, android.view.MotionEvent motionEvent) {
    }
    
    private final boolean isInFocus(android.view.View $this$isInFocus) {
        return false;
    }
    
    private final void setFocus(android.view.View $this$setFocus) {
    }
    
    private final void removeFocus(android.view.View $this$removeFocus) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010L\u001a\u00020MJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)J\u000e\u0010N\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020QJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010F\u001a\u00020GR$\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\tR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K\u00a8\u0006S"}, d2 = {"Lcom/gammasoft/busfinder/view/dialog/BlurPopup$Builder;", "", "()V", "animationType", "", "getAnimationType$app_debug$annotations", "getAnimationType$app_debug", "()I", "setAnimationType$app_debug", "(I)V", "baseBlurPopup", "Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "getBaseBlurPopup$app_debug", "()Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;", "setBaseBlurPopup$app_debug", "(Lcom/gammasoft/busfinder/view/dialog/BaseBlurPopup;)V", "cancelTouchOnDragOutsideView", "", "getCancelTouchOnDragOutsideView$app_debug", "()Z", "setCancelTouchOnDragOutsideView$app_debug", "(Z)V", "dismissOnLongPressStop", "getDismissOnLongPressStop$app_debug", "setDismissOnLongPressStop$app_debug", "dismissOnTouchOutside", "getDismissOnTouchOutside$app_debug", "setDismissOnTouchOutside$app_debug", "dispatchTouchEventOnRelease", "getDispatchTouchEventOnRelease$app_debug", "setDispatchTouchEventOnRelease$app_debug", "hoverListener", "Lcom/gammasoft/busfinder/controller/longpress/PopupHoverEvento;", "getHoverListener$app_debug", "()Lcom/gammasoft/busfinder/controller/longpress/PopupHoverEvento;", "setHoverListener$app_debug", "(Lcom/gammasoft/busfinder/controller/longpress/PopupHoverEvento;)V", "longPressDuration", "getLongPressDuration$app_debug", "setLongPressDuration$app_debug", "longPressReleaseClickListener", "Landroid/view/View$OnClickListener;", "getLongPressReleaseClickListener$app_debug", "()Landroid/view/View$OnClickListener;", "setLongPressReleaseClickListener$app_debug", "(Landroid/view/View$OnClickListener;)V", "parentActivity", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "getParentActivity$app_debug", "()Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "setParentActivity$app_debug", "(Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;)V", "popupInflaterEvento", "Lcom/gammasoft/busfinder/controller/longpress/PopupInflaterEvento;", "getPopupInflaterEvento$app_debug", "()Lcom/gammasoft/busfinder/controller/longpress/PopupInflaterEvento;", "setPopupInflaterEvento$app_debug", "(Lcom/gammasoft/busfinder/controller/longpress/PopupInflaterEvento;)V", "rootPopupView", "Landroid/view/ViewGroup;", "getRootPopupView$app_debug", "()Landroid/view/ViewGroup;", "setRootPopupView$app_debug", "(Landroid/view/ViewGroup;)V", "tag", "", "getTag$app_debug", "()Ljava/lang/String;", "setTag$app_debug", "(Ljava/lang/String;)V", "targetView", "Landroid/view/View;", "getTargetView$app_debug", "()Landroid/view/View;", "setTargetView$app_debug", "(Landroid/view/View;)V", "build", "Lcom/gammasoft/busfinder/view/dialog/BlurPopup;", "popupInflaterListener", "popupStateListener", "popupStateEvento", "Lcom/gammasoft/busfinder/controller/longpress/PopupStateEvento;", "Companion", "app_debug"})
    public static final class Builder {
        public com.gammasoft.busfinder.view.dialog.BaseBlurPopup baseBlurPopup;
        public com.gammasoft.busfinder.view.fragment.TarjetaBase parentActivity;
        public java.lang.String tag;
        public android.view.View targetView;
        @org.jetbrains.annotations.Nullable()
        private android.view.ViewGroup rootPopupView;
        @org.jetbrains.annotations.Nullable()
        private com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento popupInflaterEvento;
        @org.jetbrains.annotations.Nullable()
        private android.view.View.OnClickListener longPressReleaseClickListener;
        @org.jetbrains.annotations.Nullable()
        private com.gammasoft.busfinder.controller.longpress.PopupHoverEvento hoverListener;
        private int longPressDuration = 350;
        private boolean dismissOnLongPressStop = true;
        private boolean dismissOnTouchOutside = true;
        private boolean dispatchTouchEventOnRelease = true;
        private boolean cancelTouchOnDragOutsideView = true;
        private int animationType = 3;
        @org.jetbrains.annotations.NotNull()
        public static final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder.Companion Companion = null;
        
        private Builder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BaseBlurPopup getBaseBlurPopup$app_debug() {
            return null;
        }
        
        public final void setBaseBlurPopup$app_debug(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.view.dialog.BaseBlurPopup p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.fragment.TarjetaBase getParentActivity$app_debug() {
            return null;
        }
        
        public final void setParentActivity$app_debug(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.view.fragment.TarjetaBase p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTag$app_debug() {
            return null;
        }
        
        public final void setTag$app_debug(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getTargetView$app_debug() {
            return null;
        }
        
        public final void setTargetView$app_debug(@org.jetbrains.annotations.NotNull()
        android.view.View p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.view.ViewGroup getRootPopupView$app_debug() {
            return null;
        }
        
        public final void setRootPopupView$app_debug(@org.jetbrains.annotations.Nullable()
        android.view.ViewGroup p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento getPopupInflaterEvento$app_debug() {
            return null;
        }
        
        public final void setPopupInflaterEvento$app_debug(@org.jetbrains.annotations.Nullable()
        com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.view.View.OnClickListener getLongPressReleaseClickListener$app_debug() {
            return null;
        }
        
        public final void setLongPressReleaseClickListener$app_debug(@org.jetbrains.annotations.Nullable()
        android.view.View.OnClickListener p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.gammasoft.busfinder.controller.longpress.PopupHoverEvento getHoverListener$app_debug() {
            return null;
        }
        
        public final void setHoverListener$app_debug(@org.jetbrains.annotations.Nullable()
        com.gammasoft.busfinder.controller.longpress.PopupHoverEvento p0) {
        }
        
        public final int getLongPressDuration$app_debug() {
            return 0;
        }
        
        public final void setLongPressDuration$app_debug(int p0) {
        }
        
        public final boolean getDismissOnLongPressStop$app_debug() {
            return false;
        }
        
        public final void setDismissOnLongPressStop$app_debug(boolean p0) {
        }
        
        public final boolean getDismissOnTouchOutside$app_debug() {
            return false;
        }
        
        public final void setDismissOnTouchOutside$app_debug(boolean p0) {
        }
        
        public final boolean getDispatchTouchEventOnRelease$app_debug() {
            return false;
        }
        
        public final void setDispatchTouchEventOnRelease$app_debug(boolean p0) {
        }
        
        public final boolean getCancelTouchOnDragOutsideView$app_debug() {
            return false;
        }
        
        public final void setCancelTouchOnDragOutsideView$app_debug(boolean p0) {
        }
        
        public final int getAnimationType$app_debug() {
            return 0;
        }
        
        @AnimType()
        @java.lang.Deprecated()
        public static void getAnimationType$app_debug$annotations() {
        }
        
        public final void setAnimationType$app_debug(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder baseBlurPopup(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.view.dialog.BaseBlurPopup baseBlurPopup) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder targetView(@org.jetbrains.annotations.NotNull()
        android.view.View targetView) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder popupInflaterListener(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.controller.longpress.PopupInflaterEvento popupInflaterEvento) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder longPressReleaseClickListener(@org.jetbrains.annotations.NotNull()
        android.view.View.OnClickListener longPressReleaseClickListener) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder hoverListener(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.controller.longpress.PopupHoverEvento hoverListener) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder popupStateListener(@org.jetbrains.annotations.NotNull()
        com.gammasoft.busfinder.controller.longpress.PopupStateEvento popupStateEvento) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder longPressDuration(int longPressDuration) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder dismissOnLongPressStop(boolean dismissOnLongPressStop) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder dismissOnTouchOutside(boolean dismissOnTouchOutside) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder dispatchTouchEventOnRelease(boolean dispatchTouchEventOnRelease) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder cancelTouchOnDragOutsideView(boolean cancelTouchOnDragOutsideView) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder animationType(@AnimType()
        int animationType) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.gammasoft.busfinder.view.dialog.BlurPopup build() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/gammasoft/busfinder/view/dialog/BlurPopup$Builder$Companion;", "", "()V", "with", "Lcom/gammasoft/busfinder/view/dialog/BlurPopup$Builder;", "parentActivity", "Lcom/gammasoft/busfinder/view/fragment/TarjetaBase;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.gammasoft.busfinder.view.dialog.BlurPopup.Builder with(@org.jetbrains.annotations.NotNull()
            com.gammasoft.busfinder.view.fragment.TarjetaBase parentActivity) {
                return null;
            }
        }
    }
}