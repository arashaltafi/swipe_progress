package com.arash.altafi.swipebutton.sample0

import android.view.MotionEvent
import android.view.View
import com.arash.altafi.swipebutton.logE

internal object TouchUtils {
    fun isTouchOutsideInitialPosition(event: MotionEvent, view: View,isRtl: Boolean): Boolean {
        "event.x = ${event.x} view.x = ${view.x} view.width = ${view.width} view.x + view.width = ${view.x + view.width}".logE("isTouchOutsideInitialPosition")
        return if (isRtl) event.x < view.x else event.x > view.x + view.width
    }
}