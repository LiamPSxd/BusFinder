package com.gammasoft.busfinder.controller.longpress

import android.annotation.SuppressLint
import android.os.Handler
import android.view.MotionEvent
import android.view.MotionEvent.*
import android.view.View
import androidx.annotation.IntDef
import com.gammasoft.busfinder.controller.longpress.PopupTouchEvento.PressStatus.Companion.STATUS_LONG_PRESSING
import com.gammasoft.busfinder.controller.longpress.PopupTouchEvento.PressStatus.Companion.STATUS_NOT_PRESSED
import com.gammasoft.busfinder.controller.longpress.PopupTouchEvento.PressStatus.Companion.STATUS_PRESSING
import com.gammasoft.busfinder.view.util.vibrate

class PopupTouchEvento internal constructor(private val mPressPopupInterface: PopupInterface,
                                            private val mLongPressDuration: Int = DEFAULT_LONG_PRESS_DURATION): View.OnTouchListener{
    private var isVibrationEnabled: Boolean = false
    private var vibrationDurationMillis: Long = DEFAULT_VIBRATION_DURATION

    @PressStatus
    private var mCurrentPressStatus = STATUS_NOT_PRESSED
    private var mStartPressTimestamp: Long = 0

    private val mLongPressHandler: Handler = Handler()
    private val mLongPressRunnable = object : RunnableMotionEvento(){
        override fun run(){
            if(mCurrentPressStatus == STATUS_PRESSING && System.currentTimeMillis() - mStartPressTimestamp >= mLongPressDuration){
                startLongPress(startView, lastMotionEvent!!)
            }
        }
    }

    companion object{
        private const val DEFAULT_VIBRATION_DURATION = 50L
        internal const val DEFAULT_LONG_PRESS_DURATION = 350
        fun inside(popupInterface: PopupInterface): PopupTouchEvento = PopupTouchEvento(popupInterface)
    }

    fun withVibration(durationMillis: Long = DEFAULT_VIBRATION_DURATION): PopupTouchEvento = apply{
        isVibrationEnabled = true
        vibrationDurationMillis = durationMillis
    }

    fun setOn(targetView: View){
        targetView.setOnTouchListener(this)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean{
        when(motionEvent.action){
            ACTION_DOWN, ACTION_MOVE -> {
                when(mCurrentPressStatus){
                    STATUS_NOT_PRESSED -> startPress(view, motionEvent)
                    STATUS_PRESSING -> if(System.currentTimeMillis() - mStartPressTimestamp > mLongPressDuration) startLongPress(view, motionEvent) else continuePress(motionEvent, getPressStatusPercentage())
                    STATUS_LONG_PRESSING -> continueLongPress(motionEvent, getLongPressDuration())
                }
            }

            ACTION_UP, ACTION_CANCEL -> {
                when(mCurrentPressStatus){
                    STATUS_NOT_PRESSED -> {}
                    STATUS_PRESSING -> stopPress(motionEvent)
                    STATUS_LONG_PRESSING -> stopLongPress(motionEvent)
                }

                if(mCurrentPressStatus == STATUS_LONG_PRESSING) view.parent.requestDisallowInterceptTouchEvent(true)
            }
        }

        return mCurrentPressStatus == STATUS_LONG_PRESSING
    }

    private fun startPress(touchedView: View, motionEvent: MotionEvent){
        mLongPressHandler.postDelayed(mLongPressRunnable, (mLongPressDuration + 10).toLong())

        updateLastMotionEventRunnable(motionEvent)
        updateRunnableView(touchedView)

        mStartPressTimestamp = System.currentTimeMillis()
        mCurrentPressStatus = STATUS_PRESSING

        mPressPopupInterface.onPressStart(touchedView, motionEvent)
    }

    private fun continuePress(motionEvent: MotionEvent, pressStatus: Int){
        mPressPopupInterface.onPressContinue(pressStatus, motionEvent)
        updateLastMotionEventRunnable(motionEvent)
    }

    fun stopPress(motionEvent: MotionEvent?){
        mPressPopupInterface.onPressStop(motionEvent)
        resetPressVariables()
    }

    private fun startLongPress(view: View?, motionEvent: MotionEvent){
        mCurrentPressStatus = STATUS_LONG_PRESSING
        mPressPopupInterface.onLongPressStart(motionEvent)

        if(isVibrationEnabled) view?.context?.vibrate(vibrationDurationMillis)

        if(view != null && view.parent != null) view.parent.requestDisallowInterceptTouchEvent(true)
    }

    private fun continueLongPress(motionEvent: MotionEvent, longPressDuration: Int){
        mPressPopupInterface.onLongPressContinue(longPressDuration, motionEvent)
    }

    private fun stopLongPress(motionEvent: MotionEvent){
        mPressPopupInterface.onLongPressEnd(motionEvent)
        resetPressVariables()
    }

    private fun updateLastMotionEventRunnable(motionEvent: MotionEvent){
        mLongPressRunnable.lastMotionEvent = motionEvent
    }

    private fun updateRunnableView(view: View) {
        mLongPressRunnable.startView = view
    }

    private fun resetPressVariables(){
        mStartPressTimestamp = -1
        mCurrentPressStatus = STATUS_NOT_PRESSED

        mLongPressHandler.removeCallbacks(mLongPressRunnable)
    }

    private fun getLongPressDuration(): Int = (System.currentTimeMillis() - mStartPressTimestamp - mLongPressDuration.toLong()).toInt()

    private fun getPressStatusPercentage(): Int = ((System.currentTimeMillis() - mStartPressTimestamp) / mLongPressDuration * 100).toInt()

    @Retention
    @IntDef(STATUS_NOT_PRESSED, STATUS_PRESSING, STATUS_LONG_PRESSING)
    private annotation class PressStatus{
        companion object{
            const val STATUS_NOT_PRESSED = 0
            const val STATUS_PRESSING = 1
            const val STATUS_LONG_PRESSING = 2
        }
    }
}