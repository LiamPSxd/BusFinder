package com.example.busfinder.controller.longpress

interface PopupStateEvento{
    fun onPopupShow(popupTag: String?)

    fun onPopupDismiss(popupTag: String?)
}