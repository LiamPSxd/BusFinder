package com.example.busfinder.view.activity

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.busfinder.view.dialog.BaseDialogFragment
import com.example.busfinder.view.fragment.Base
import com.example.busfinder.view.util.*

abstract class TarjetaBase: Fragment(){
    var index: Int = 0

    fun pushPopup(popupDialog: BaseDialogFragment){
        index++
        activity?.supportFragmentManager!!.pushPopup(getFragmentContainer(), popupDialog, popupDialog.javaClass.simpleName + index)
    }

    fun pushFragment(fragment: Base, isAddToBackStack: Boolean = true){
        if(index >= 0) activity?.supportFragmentManager!!.moveCurrentCardToBackground()

        if(isAddToBackStack) index++
        activity?.supportFragmentManager!!.pushFragment(getFragmentContainer(), fragment, fragment.javaClass.simpleName + index, index, isAddToBackStack)
    }

    fun popBackStack(){
        if(index <= 0) return

        index--
        activity?.supportFragmentManager!!.popBackStackImmediate()
        activity?.supportFragmentManager!!.movePreviousCardToForeground()
    }

    private fun startPoppingFragment(){
        activity?.supportFragmentManager!!.findLastFragment()?.run{
            if(this.onBackPressed()){
                if(index > 0) popBackStack() else activity?.onBackPressed()
            }
        } ?: activity?.onBackPressed()
    }

    @IdRes
    abstract fun getFragmentContainer(): Int

    private fun removeActivePopupsIfAny(): Boolean{
        for(popup in activity?.supportFragmentManager!!.fragments.reversed()){
            if(popup is BaseDialogFragment && popup.isAdded){
                if(popup.onBackPressed()){
                    popup.smartDismiss{
                        index--
                        activity?.supportFragmentManager!!.popBackStackImmediate()
                    }
                }

                return false
            }
        }

        return true
    }

    @Deprecated("Deprecated in Java")
    fun onBackPressed(){
        try{
            if(removeActivePopupsIfAny()){
                if(index > 0) startPoppingFragment() else activity?.onBackPressed()
            }
        }catch(e: Exception){
            Log.e("onBackPressed()", "ERROR: ", e)
            startPoppingFragment()
        }
    }
}