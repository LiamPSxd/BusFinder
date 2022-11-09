package com.gammasoft.busfinder.view.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import com.gammasoft.busfinder.view.activity.TarjetaBase
import com.gammasoft.busfinder.view.dialog.BaseDialogFragment
import com.gammasoft.busfinder.view.util.*
import io.alterac.blurkit.BlurLayout

abstract class BaseTarjeta: Base(), TarjetaContenedor{
    protected var isBlurEnabled = true
    var isInForeGround: Boolean = false

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        view.isClickable = true

        getRootView()?.run{
            setMargin(top = context.getDp(if(parentActivity().index > 0) 20f else 0f).toInt())
            isClickable = true
        }

        activity?.let{ setupSwipeDownGesture(it) }

        if(isBlurEnabled){
            getBackgroundBlurLayout()?.isClickable = true
            (getBackgroundBlurLayout() as BlurLayout?)?.beginBlur()
        }else getBackgroundBlurLayout()?.makeGone()

        isInForeGround = true
    }

    private fun setupSwipeDownGesture(activity: Activity) = getDragView()?.setSwipeDownListener(activity, getRootView(), getBackgroundBlurLayout())

    @CallSuper
    override fun moveToBackGround(){
        getRootView()?.moveToBackGround(parentActivity().index)
        parentActivity().getFragmentContainer()
        //find(dragHandleId()).fadeOut()
        isInForeGround = false
    }

    @CallSuper
    override fun moveToForeGround(){
        getRootView()?.moveToForeGround()
        //find(dragHandleId()).fadeIn()
        isInForeGround = true
    }

    @CallSuper
    open fun dispose(){
        getDragView()?.setOnTouchListener(null)
    }

    open fun pushFragment(base: Base, isAddToBackStack: Boolean = true) = parentActivity().pushFragment(base, isAddToBackStack)

    open fun pushPopup(dialogFragment: BaseDialogFragment) = parentActivity().pushPopup(dialogFragment)

    abstract fun getBackgroundBlurLayout(): ViewGroup?

    abstract fun getDragView(): View?

    @IdRes
    abstract fun dragHandleId(): Int

    override fun parentActivity(): TarjetaBase = (activity as? TarjetaBase) ?: throw IllegalStateException("El Fragmento debe ser proveido por una BaseTarjeta")

    override fun onDestroyView(){
        getRootView()?.hideSoftKeyboard()
        (getBackgroundBlurLayout() as? BlurLayout)?.pauseBlur()
        dispose()
        super.onDestroyView()
    }
}