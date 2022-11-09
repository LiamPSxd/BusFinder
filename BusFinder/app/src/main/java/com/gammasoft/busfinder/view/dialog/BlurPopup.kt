package com.gammasoft.busfinder.view.dialog

import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import com.gammasoft.busfinder.controller.longpress.*
import com.gammasoft.busfinder.controller.longpress.PopupTouchEvento.Companion.DEFAULT_LONG_PRESS_DURATION
import com.gammasoft.busfinder.view.activity.TarjetaBase
import com.gammasoft.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_BOTTOM
import com.gammasoft.busfinder.view.util.isTouchInsideView
import com.gammasoft.busfinder.view.util.setDismissOnTouchOutside
import com.gammasoft.busfinder.view.util.withAnimType

@Suppress("MemberVisibilityCanBePrivate", "unused")
open class BlurPopup private constructor(builder: Builder): PopupInterface{
    internal val baseBlurPopup: BaseBlurPopup = builder.baseBlurPopup
    internal val parentActivity: TarjetaBase = builder.parentActivity
    internal val popupTag: String = builder.tag
    internal val targetView: View = builder.targetView
    internal val rootPopupView: ViewGroup? = builder.rootPopupView
    internal var initialPressedView: View? = null

    internal val popupInflaterEvento: PopupInflaterEvento? = builder.popupInflaterEvento
    internal val longPressReleaseClickListener: View.OnClickListener? = builder.longPressReleaseClickListener
    internal val popupHoverEvento: PopupHoverEvento? = builder.hoverListener
    internal val popupStateEvento: PopupStateEvento? = builder.baseBlurPopup.popupStateEvento
    internal var popupTouchEvento: PopupTouchEvento? = null

    private val longPressDuration: Int = builder.longPressDuration
    private val isDismissOnLongPressStop: Boolean = builder.dismissOnLongPressStop
    private val isDismissOnTouchOutside: Boolean = builder.dismissOnTouchOutside
    private val isDispatchTouchEventOnRelease: Boolean = builder.dispatchTouchEventOnRelease
    private val isCancelTouchOnDragOutsideView: Boolean = builder.cancelTouchOnDragOutsideView
    var isRegistered: Boolean = false

    @AnimType
    private val animationType: Int = builder.animationType

    fun showNow(){
        if(!isRegistered) register()
        showBlurPopup()
    }

    fun dismissNow(){
        if(!isRegistered) register()
        dismissBlurPopup()
    }

    @CallSuper
    open fun register(){
        baseBlurPopup.popupTouchEvento = PopupTouchEvento(this, longPressDuration)
        popupTouchEvento = baseBlurPopup.popupTouchEvento
        targetView.setOnTouchListener(popupTouchEvento)
        isRegistered = true
    }

    @CallSuper
    open fun unregister(){
        popupTouchEvento?.stopPress(null)
        dismissBlurPopup()
        targetView.setOnTouchListener(null)
        isRegistered = false
    }

    private fun showBlurPopup(){
        if(baseBlurPopup.isVisible) baseBlurPopup.dismiss()

        parentActivity.pushPopup(baseBlurPopup.withAnimType(animationType).setDismissOnTouchOutside(isDismissOnTouchOutside))
        popupInflaterEvento?.onViewInflated(popupTag, rootPopupView)
        popupStateEvento?.onPopupShow(popupTag)
        popupTouchEvento?.withVibration()
    }

    private fun dismissBlurPopup(){
        if(baseBlurPopup.isVisible) baseBlurPopup.getParentActivity().onBackPressed()
        popupStateEvento?.onPopupDismiss(popupTag)
    }

    override fun onPressStart(pressedView: View, motionEvent: MotionEvent){
        initialPressedView = pressedView
        popupTouchEvento?.withVibration()
    }

    override fun onPressContinue(progress: Int, motionEvent: MotionEvent){
        if(isCancelTouchOnDragOutsideView && initialPressedView != null && !motionEvent.isTouchInsideView(initialPressedView!!)) popupTouchEvento?.stopPress(motionEvent)
    }

    override fun onPressStop(motionEvent: MotionEvent?){
        initialPressedView = null
    }

    override fun onLongPressStart(motionEvent: MotionEvent) = showBlurPopup()

    override fun onLongPressContinue(longPressTime: Int, motionEvent: MotionEvent){
        if(isDispatchTouchEventOnRelease || popupHoverEvento != null) rootPopupView.dispatchActiveFocusToLeavesOnly(motionEvent)
    }

    override fun onLongPressEnd(motionEvent: MotionEvent){
        if(isDispatchTouchEventOnRelease && rootPopupView != null) rootPopupView.dispatchClickToLeavesOnly(motionEvent)
        if(isDismissOnLongPressStop) dismissBlurPopup()
        initialPressedView = null
    }

    private fun ViewGroup?.dispatchActiveFocusToLeavesOnly(motionEvent: MotionEvent){
        if(this == null || childCount == 0) return

        for(i in 0..childCount){
            val child = getChildAt(i)

            if(child is ViewGroup) child.dispatchActiveFocusToLeavesOnly(motionEvent)
            else{
                if(motionEvent.isTouchInsideView(child)) child.setFocus()
                else child.removeFocus()
            }
        }
    }

    private fun ViewGroup?.dispatchClickToLeavesOnly(motionEvent: MotionEvent){
        if(this == null || childCount == 0) return

        for(i in 0..childCount){
            val child = getChildAt(i)

            if(child is ViewGroup) child.dispatchClickToLeavesOnly(motionEvent)
            else
                if(motionEvent.isTouchInsideView(child)) longPressReleaseClickListener?.onClick(child) ?: child.performClick()
        }
    }

    private fun View.isInFocus(): Boolean = isPressed

    private fun View.setFocus(){
        if(!isInFocus()){
            isPressed = true
            popupHoverEvento?.onHoverChanged(this, true)
        }
    }

    private fun View.removeFocus(){
        if(isInFocus()){
            isPressed = false
            popupHoverEvento?.onHoverChanged(this, false)
        }
    }

    class Builder private constructor(){
        internal lateinit var baseBlurPopup: BaseBlurPopup
        internal lateinit var parentActivity: TarjetaBase
        internal lateinit var tag: String
        internal lateinit var targetView: View
        internal var rootPopupView: ViewGroup? = null
        internal var popupInflaterEvento: PopupInflaterEvento? = null
        internal var longPressReleaseClickListener: View.OnClickListener? = null
        internal var hoverListener: PopupHoverEvento? = null
        internal var longPressDuration: Int = DEFAULT_LONG_PRESS_DURATION
        internal var dismissOnLongPressStop: Boolean = true
        internal var dismissOnTouchOutside: Boolean = true
        internal var dispatchTouchEventOnRelease: Boolean = true
        internal var cancelTouchOnDragOutsideView: Boolean = true
        @AnimType
        internal var animationType: Int = ANIM_FROM_BOTTOM

        companion object{
            fun with(parentActivity: TarjetaBase) = Builder().apply{ this.parentActivity = parentActivity }
        }

        fun baseBlurPopup(baseBlurPopup: BaseBlurPopup) = apply{
            this.baseBlurPopup = baseBlurPopup.apply{ isLongPressPopup = true }
            rootPopupView = baseBlurPopup.container
            tag = baseBlurPopup.popupTag ?: "${baseBlurPopup::class.java.simpleName}${System.currentTimeMillis()}"
        }

        fun targetView(targetView: View) = apply{ this.targetView = targetView }

        fun popupInflaterListener(popupInflaterEvento: PopupInflaterEvento) = apply{ this.popupInflaterEvento = popupInflaterEvento }

        fun longPressReleaseClickListener(longPressReleaseClickListener: View.OnClickListener) = apply{ this.longPressReleaseClickListener = longPressReleaseClickListener }

        fun hoverListener(hoverListener: PopupHoverEvento) = apply{ this.hoverListener = hoverListener }

        fun popupStateListener(popupStateEvento: PopupStateEvento) = apply{ baseBlurPopup.popupStateEvento = popupStateEvento }

        fun longPressDuration(longPressDuration: Int) = apply{ this.longPressDuration = longPressDuration }

        fun dismissOnLongPressStop(dismissOnLongPressStop: Boolean) = apply{ this.dismissOnLongPressStop = dismissOnLongPressStop }

        fun dismissOnTouchOutside(dismissOnTouchOutside: Boolean) = apply{ this.dismissOnTouchOutside = dismissOnTouchOutside }

        fun dispatchTouchEventOnRelease(dispatchTouchEventOnRelease: Boolean) = apply{ this.dispatchTouchEventOnRelease = dispatchTouchEventOnRelease }

        fun cancelTouchOnDragOutsideView(cancelTouchOnDragOutsideView: Boolean) = apply{ this.cancelTouchOnDragOutsideView = cancelTouchOnDragOutsideView }

        fun animationType(@AnimType animationType: Int) = apply{ this.animationType = animationType }

        fun build() = BlurPopup(this)
    }
}