package com.example.busfinder.view.fragment

import androidx.fragment.app.Fragment

abstract class Base: Fragment(){
    open fun onBackPressed(): Boolean = true
}