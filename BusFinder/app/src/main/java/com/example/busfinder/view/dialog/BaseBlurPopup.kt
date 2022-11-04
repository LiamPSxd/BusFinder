package com.example.busfinder.view.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AnimRes
import androidx.annotation.CallSuper
import com.example.busfinder.R
import com.example.busfinder.controller.longpress.PopupStateEvento
import com.example.busfinder.controller.longpress.PopupTouchEvento
import com.example.busfinder.view.activity.TarjetaBase
import com.example.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_BOTTOM
import com.example.busfinder.view.fragment.Base
import com.example.busfinder.view.util.*
import io.alterac.blurkit.BlurLayout

@Suppress("DeferredResultUnused")
abstract class BaseBlurPopup: BaseDialogFragment(){
    internal var container: ViewGroup? = null
    var popupTag: String? = null
    internal var isLongPressPopup: Boolean = false
    internal var popupStateEvento: PopupStateEvento? = null
    internal var popupTouchEvento: PopupTouchEvento? = null
    var overrideWindowAnimations: Boolean = false
    internal var dismissOnTouchOutside: Boolean = true
    @AnimRes
    internal var enterAnimRes: Int = R.anim.float_up
    @AnimRes
    internal var exitAnimRes: Int = R.anim.sink_down
    @AnimType
    internal var animationType: Int = ANIM_FROM_BOTTOM

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        resolveEnterExitAnim(animationType)
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        this.container = container
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart(){
        super.onStart()
        getRootView()?.visibility = View.INVISIBLE

        doAfterDelay(10){
            activity?.runOnUiThread{
                getBlurLayout()?.beginBlur()

                getRootView()?.run{
                    animate(enterAnimRes).then{
                        visibility = View.VISIBLE
                        isClickable = true
                    }
                }

                setupSwipeDownToCloseGesture()
                doOnStart()
            }
        }

        getBlurLayout()?.setOnClickListener{ if(dismissOnTouchOutside) activity?.onBackPressed() }
    }

    override fun onStop(){
        getBlurLayout()?.pauseBlur()
        doOnStop()
        super.onStop()
    }

    private fun setupSwipeDownToCloseGesture() = getDragHandle()?.setSwipeDownListener(requireActivity(), getRootView()!!, getBlurLayout())

    fun pushFragment(base: Base, isAddToBackStack: Boolean = true){
        getParentActivity().pushFragment(base, isAddToBackStack)
    }

    internal fun getParentActivity(): TarjetaBase = activity as? TarjetaBase
        ?: throw IllegalStateException("Activity Padre de este popup debe ser un BaseCard")

    @CallSuper
    override fun dismiss(){
        getRootView()?.hideSoftKeyboard()
        getBlurLayout()?.fadeOut()

        getRootView()?.animation?.run{}
            ?: getRootView()?.animate(exitAnimRes)?.then{ super.dismiss() }
            ?: super.dismiss()
    }

    override fun onDismiss(dialog: DialogInterface){
        popupStateEvento?.onPopupDismiss(popupTag)
        popupTouchEvento?.stopPress(null)
        super.onDismiss(dialog)
    }

    open fun doOnStart(){}

    open fun doOnStop(){}

    abstract fun getBlurLayout(): BlurLayout?

    abstract fun getDragHandle(): View?

    abstract fun getRootView(): View?

    abstract fun getBackgroundLayout(): ViewGroup?
}