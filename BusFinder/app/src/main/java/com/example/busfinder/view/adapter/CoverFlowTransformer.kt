package com.example.busfinder.view.adapter

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

private const val SCALE_MIN = .3f
private const val SCALE_MAX = 1f
private const val SCALE = .05f

class CoverFlowTransformer(var minAlpha: Float): ViewPager.PageTransformer{
    var paddingFactor: Float = 0.08f

    override fun transformPage(page: View, position: Float){
        val realPosition = position - paddingFactor
        val realScale = getFloat(1 - abs(realPosition * SCALE))

        page.scaleX = realScale
        page.scaleY = realScale

        if(realPosition != 0f){
            val scaleFactor = max(SCALE_MIN, 1 - abs(realPosition))
            page.alpha = minAlpha + (scaleFactor - SCALE_MIN) / (1 - SCALE_MIN) * (1 - minAlpha)
        }
    }

    private fun getFloat(value: Float): Float{
        return min(SCALE_MAX, max(SCALE_MIN, value))
    }
}