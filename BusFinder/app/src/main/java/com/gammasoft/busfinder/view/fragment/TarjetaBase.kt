package com.gammasoft.busfinder.view.fragment

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.gammasoft.busfinder.view.dialog.BaseDialogFragment
import com.gammasoft.busfinder.view.util.*

abstract class TarjetaBase: Fragment(){
    var index: Int = 0

    fun pushPopup(popupDialog: BaseDialogFragment){
        index++
        parentFragmentManager.pushPopup(getFragmentContainer(), popupDialog, popupDialog.javaClass.simpleName + index)
    }

    fun pushFragment(fragment: Base, isAddToBackStack: Boolean = true){
        if(index >= 0) parentFragmentManager.moveCurrentCardToBackground()

        if(isAddToBackStack) index++

        parentFragmentManager.pushFragment(getFragmentContainer(), fragment, fragment.javaClass.simpleName + index, index, isAddToBackStack)
    }

    fun popBackStack(){
        if(index <= 0) return

        index--
        parentFragmentManager.popBackStackImmediate()
        parentFragmentManager.movePreviousCardToForeground()
    }

    private fun startPoppingFragment(){
        parentFragmentManager.findLastFragment()?.run{
            if(this.onBackPressed()){
                if(index > 0) popBackStack() else activity?.onBackPressedDispatcher?.onBackPressed()
            }
        } ?: activity?.onBackPressedDispatcher?.onBackPressed()
    }

    @IdRes
    abstract fun getFragmentContainer(): Int

    private fun removeActivePopupsIfAny(): Boolean{
        for(popup in parentFragmentManager.fragments.reversed()){
            if(popup is BaseDialogFragment && popup.isAdded){
                if(popup.onBackPressed()){
                    popup.smartDismiss{
                        index--
                        parentFragmentManager.popBackStackImmediate()
                    }
                }

                return false
            }
        }

        return true
    }

    fun onBackPressed(){
        try{
            if(removeActivePopupsIfAny())
                if(index > 0) startPoppingFragment() else activity?.onBackPressedDispatcher?.onBackPressed()
        }catch(e: Exception){
            Log.e("onBackPressed()", "ERROR: ", e)
            startPoppingFragment()
        }
    }
}