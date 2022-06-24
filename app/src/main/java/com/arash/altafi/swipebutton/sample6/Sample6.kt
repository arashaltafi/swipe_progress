package com.arash.altafi.swipebutton.sample6

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.swipebutton.R
import kotlinx.android.synthetic.main.activity_sample6.*
import java.lang.Math.abs

class Sample6 : AppCompatActivity() {

    private var x1 = 0f
    private var x2 = 0f
    private val minDistance = 200 //300.toPx()
    private var onRightSwipe: (() -> Unit)? = null
    private var onLeftSwipe: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample6)

        init()
    }

    private fun init() {
        onRightSwipe = {
            Log.i("test123321", "Right To Left")
            tvSwipe.text = "Right To Left"
        }
        onLeftSwipe = {
            Log.i("test123321", "Left To Right")
            tvSwipe.text = "Left To Right"
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> x1 = event.x
            MotionEvent.ACTION_UP -> {
                x2 = event.x
                val deltaX: Float = x2 - x1
                if (abs(deltaX) > minDistance) {
                    if (deltaX < 0) {
                        onRightSwipe?.invoke()
                    } else {
                        onLeftSwipe?.invoke()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

//    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        when (ev!!.action) {
//            MotionEvent.ACTION_DOWN -> x1 = ev.x
//            MotionEvent.ACTION_UP -> {
//                x2 = ev.x
//                val deltaX: Float = x2 - x1
//                if (kotlin.math.abs(deltaX) > minDistance) {
//                    if (deltaX < 0) {
//                        onRightSwipe?.invoke()
//                    } else {
//                        onLeftSwipe?.invoke()
//                    }
//                }
//            }
//        }
//        return super.dispatchTouchEvent(ev)
//    }

}