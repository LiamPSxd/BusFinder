package com.example.busfinder.view.dialog

import androidx.annotation.IntDef
import com.example.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_BOTTOM
import com.example.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_CENTER
import com.example.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_LEFT
import com.example.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_RIGHT
import com.example.busfinder.view.dialog.AnimType.Companion.ANIM_FROM_TOP

@Retention
@IntDef(ANIM_FROM_LEFT, ANIM_FROM_RIGHT, ANIM_FROM_TOP, ANIM_FROM_BOTTOM, ANIM_FROM_CENTER)
annotation class AnimType {
    companion object {
        const val ANIM_FROM_LEFT = 0
        const val ANIM_FROM_RIGHT = 1
        const val ANIM_FROM_TOP = 2
        const val ANIM_FROM_BOTTOM = 3
        const val ANIM_FROM_CENTER = 4
    }
}