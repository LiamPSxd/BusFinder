package com.gammasoft.busfinder.view.util

import android.util.Log
import androidx.annotation.AnimRes
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.busfinder.R
import com.example.busfinder.view.dialog.BaseBlurPopup
import com.example.busfinder.view.dialog.BaseDialogFragment
import com.example.busfinder.view.fragment.Base
import com.example.busfinder.view.fragment.BaseTarjeta
import com.example.busfinder.view.fragment.TarjetaContenedor

fun FragmentManager.findCard(tag: String): BaseTarjeta? = this.findFragmentByTag(tag) as? BaseTarjeta

fun FragmentManager.findLastCard(): BaseTarjeta? = fragments[fragments.size - 1] as? BaseTarjeta

inline fun <reified T: Any> FragmentManager.findFragment(): Base?{
    for(fragment in fragments.reversed()){
        if(fragment is T && fragment is Base) return fragment
    }

    return null
}

fun FragmentManager.findLastFragment(): Base?{
    for(fragment in fragments.reversed()){
        if(fragment is Base) return fragment
    }

    return null
}

fun FragmentManager.findLastFragment(tag: String?): Base?{
    return findFragmentByTag(tag) as? Base
}

fun FragmentManager.findPopupDialog(tag: String): BaseBlurPopup?{
    return findFragmentByTag(tag) as? BaseBlurPopup
}

inline fun <reified T: Base> com.example.busfinder.view.activity.TarjetaBase.removeFragmentIfExists(){
    for(fragment in activity?.supportFragmentManager?.fragments!!.reversed()){
        if(fragment is T) popBackStack()
    }
}

fun FragmentManager.removeActivePopupsIfAny(): Boolean{
    for(popup in fragments.reversed()){
        if(popup is BaseDialogFragment && popup.isAdded){
            if(popup.onBackPressed()) popup.smartDismiss { popBackStack() }
            return false
        }
    }

    return true
}

fun FragmentManager.removeActiveCardsIfAny(): Boolean{
    for(card in fragments.reversed()){
        if(card is BaseTarjeta && card.isAdded){
            return if(card.onBackPressed()){
                popBackStack()
                false
            } else true
        }
    }

    return true
}

@Suppress("DEPRECATION")
fun FragmentManager.moveCurrentCardToBackground(){
    val lastFragment = findLastFragment()

    lastFragment?.run{
        (this as? TarjetaContenedor)?.moveToBackGround()
        onPause()
    }
}

fun FragmentManager.movePreviousCardToForeground(){
    val lastFragment = findLastFragment()

    lastFragment?.run{
        (this as? TarjetaContenedor)?.moveToForeGround()
        onResume()
    }
}

fun FragmentManager.pushFragment(resId: Int, card: Base, tag: String, index: Int, isAddToBackStack: Boolean = true){
    if(index < 0) return

    this.beginTransaction()
        .addCustomAnimations(R.anim.float_up, R.anim.sink_up, R.anim.float_down, R.anim.sink_down, index)
        .add(resId, card, tag)
        .addToBackStack(isAddToBackStack, tag)
        .commit()
    Log.i("pushFragment", "Added index: $index")
}

fun FragmentManager.pushPopup(resId: Int, popup: BaseDialogFragment, tag: String){
    this.beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        .add(resId, popup, popup.tag ?: tag)
        .addToBackStack(tag)
        .commit()
}

fun FragmentTransaction.addCustomAnimations(@AnimRes enter: Int, @AnimRes exit: Int, @AnimRes popEnter: Int, @AnimRes popExit: Int, index: Int = 0): FragmentTransaction{
    if(index > 0) this.setCustomAnimations(enter, exit, popEnter, popExit)
    return this
}

fun FragmentTransaction.addToBackStack(addFlag: Boolean = true, tag: String): FragmentTransaction{
    return if(addFlag) this.addToBackStack(tag) else this
}