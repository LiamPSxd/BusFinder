package com.example.busfinder.controller.longpress

import android.view.MotionEvent
import android.view.View

abstract class RunnableMotionEvento: Runnable{
    var lastMotionEvent: MotionEvent? = null
    var startView: View? = null
}