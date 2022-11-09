package com.gammasoft.busfinder.view.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.busfinder.view.activity.TarjetaBase
import com.example.busfinder.view.util.floatUp
import com.example.busfinder.view.util.moveToBackGround
import com.example.busfinder.view.util.moveToForeGround
import java.lang.ref.WeakReference

abstract class BaseTarjetaContenedor: Base(), TarjetaContenedor{
    private lateinit var pagerAdapter: BaseCardContainerPagerAdapter
    private var isInForeGround: Boolean = false

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        pagerAdapter = BaseCardContainerPagerAdapter(childFragmentManager, this)

        viewPager().adapter = pagerAdapter
        viewPager().currentItem = initialPosition()

        (activity as? TarjetaBase)?.run{ if(index > 0) viewPager().floatUp() }
        isInForeGround = true
    }

    open fun initialPosition(): Int = 0

    abstract fun baseCardCount(): Int

    abstract fun backgroundBlurLayout(): ViewGroup?

    abstract fun viewPager(): ViewPager

    override fun getRootView(): ViewGroup? = viewPager()

    abstract fun baseCardToInflate(position: Int): com.example.busfinder.view.fragment.BaseTarjeta

    override fun moveToBackGround(){
        viewPager().moveToBackGround(parentActivity().index)

        pagerAdapter.currentCard?.run{
            //find<View>(dragHandleId()).fadeOut()
        }

        isInForeGround = false
    }

    override fun moveToForeGround(){
        viewPager().moveToForeGround()

        pagerAdapter.currentCard?.run{
            //find<View>(dragHandleId()).fadeIn()
        }

        isInForeGround = true
    }

    override fun parentActivity(): TarjetaBase = (activity as? TarjetaBase) ?: throw IllegalStateException("El Fragmento debe ser proveido por un BaseCard")

    internal class BaseCardContainerPagerAdapter(fm: FragmentManager, baseCardContainerFragment: BaseTarjetaContenedor): FragmentStatePagerAdapter(fm){
        private val ref: WeakReference<BaseTarjetaContenedor> = WeakReference(baseCardContainerFragment)
        var currentCard: com.example.busfinder.view.fragment.BaseTarjeta? = null

        override fun getItem(position: Int): Fragment = ref.get()?.baseCardToInflate(position)!!

        override fun getCount(): Int = ref.get()?.baseCardCount() ?: 0

        override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any){
            if(currentCard !== `object`) currentCard = `object` as? com.example.busfinder.view.fragment.BaseTarjeta
            super.setPrimaryItem(container, position, `object`)
        }
    }
}