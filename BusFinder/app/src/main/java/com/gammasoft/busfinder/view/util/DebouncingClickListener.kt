package com.gammasoft.busfinder.view.util

import android.view.View

interface DebouncingClickListener: View.OnClickListener{
    companion object{
        internal var enabled = true
        private val ENABLE_AGAIN = { enabled = true }
    }

    override fun onClick(v: View){
        if(enabled){
            enabled = false
            v.post(ENABLE_AGAIN)
            onDebouncingClick(v)
        }
    }

    fun onDebouncingClick(view: View)
}