package com.gammasoft.busfinder.view.fragment

import android.view.ViewGroup

interface TarjetaBaseContenedor{
    fun getRootView(): ViewGroup?

    fun moveToBackGround()

    fun moveToForeGround()

    fun parentActivity(): TarjetaBase
}