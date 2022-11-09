package com.gammasoft.busfinder.view.adapter

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.viewpager.widget.ViewPager
import com.gammasoft.busfinder.R

private const val DEFAULT_PERCENTAGE_PADDING = 8
private const val MIN_ALPHA = .5f

class DeckViewPager: ViewPager{
    private val pageTransformer = CoverFlowTransformer(MIN_ALPHA)

    constructor(context: Context): super(context){
        setPercentagePadding(context, DEFAULT_PERCENTAGE_PADDING)
    }

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet){
        val typedArray: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.DeckViewPager)

        val percentagePaddingXml = typedArray.getInt(R.styleable.DeckViewPager_padding_percentage, Integer.MAX_VALUE)
        if(percentagePaddingXml != Integer.MAX_VALUE) setPercentagePadding(context, percentagePaddingXml)

        val dipPaddingXmlInPixel = typedArray.getDimensionPixelSize(R.styleable.DeckViewPager_padding_dp, Integer.MAX_VALUE)
        if(dipPaddingXmlInPixel != Integer.MAX_VALUE) initProperties(context, dipPaddingXmlInPixel.toFloat())

        val minAlphaXml = typedArray.getFloat(R.styleable.DeckViewPager_min_alpha, MIN_ALPHA)
        if(minAlphaXml != MIN_ALPHA) setMinAlpha(minAlphaXml)

        typedArray.recycle()

        if(percentagePaddingXml == Integer.MAX_VALUE && dipPaddingXmlInPixel == Integer.MAX_VALUE) setPercentagePadding(context, DEFAULT_PERCENTAGE_PADDING)
    }

    init{
        initView()
    }

    private fun initView(){
        setPageTransformer(true, pageTransformer)
    }

    private fun setPercentagePadding(context: Context, percentage: Int){
        when{
            percentage == 0 -> initProperties(context, 0f)
            percentage < 0 -> throw IllegalArgumentException("El Porcentaje no puede ser menor que 0")
            percentage >= 50 -> throw IllegalArgumentException("Tu Layout no será visible si el porcentaje es igual o mayor que 50")
            else -> {
                val padding = screenWidth(context) * percentage / 100f
                initProperties(context, padding)
            }
        }
    }

    fun setDpPadding(context: Context, dp: Float){
        val padding = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        )
        initProperties(context, padding)
    }

    private fun setMinAlpha(minAlpha: Float){
        when{
            minAlpha < 0 || minAlpha > 1 -> throw IllegalArgumentException("El Alpha mínimo debería estar entre 0 y 1")
            else -> pageTransformer.minAlpha = minAlpha
        }
    }

    private fun initProperties(context: Context, padding: Float){
        val intPadding = padding.toInt()
        setPadding(intPadding, 0, intPadding, 0)
        clipToPadding = false
        pageMargin = 0

        pageTransformer.paddingFactor = padding / screenWidth(context)
    }

    private fun screenWidth(context: Context): Int{
        val metrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(metrics)
        return metrics.widthPixels
    }
}