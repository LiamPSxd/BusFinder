package com.gammasoft.busfinder.view.dialog

import androidx.fragment.app.DialogFragment
import com.example.busfinder.view.util.doAfterDelay

abstract class BaseDialogFragment: DialogFragment(){
    @Suppress("DeferredResultUnused")
    fun smartDismiss(afterDismissAction: () -> Unit){
        dismiss()
        doAfterDelay(280){ afterDismissAction() }
    }

    open fun onBackPressed(): Boolean{
        return true
    }
}