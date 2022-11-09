package com.gammasoft.busfinder.view.fragment

import android.view.ViewGroup
import com.example.busfinder.view.activity.TarjetaBase

interface TarjetaContenedor{
    fun getRootView(): ViewGroup?

    fun moveToBackGround()

    fun moveToForeGround()

    fun parentActivity(): TarjetaBase
}