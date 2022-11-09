package com.gammasoft.busfinder.controller.longpress

import android.view.MotionEvent
import android.view.View

interface PopupInterface{
    fun onPressStart(pressedView: View, motionEvent: MotionEvent)

    fun onPressContinue(progress: Int, motionEvent: MotionEvent)

    fun onPressStop(motionEvent: MotionEvent?)

    fun onLongPressStart(motionEvent: MotionEvent)

    fun onLongPressContinue(longPressTime: Int, motionEvent: MotionEvent)

    fun onLongPressEnd(motionEvent: MotionEvent)
}