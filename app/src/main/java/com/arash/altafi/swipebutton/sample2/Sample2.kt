package com.arash.altafi.swipebutton.sample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.swipebutton.R
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sample2.*

class Sample2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample2)

        init()
    }

    private fun init() {

        swipe_btn.setOnStateChangeListener { active ->
            Toast.makeText(this, "State: $active", Toast.LENGTH_SHORT).show()
        }

        swipe_btn.setOnActiveListener {
            Toast.makeText(this, "Active!", Toast.LENGTH_SHORT).show()
        }

        //////////////////////////

        swipeBtnEnabled.background = ContextCompat.getDrawable(this, R.drawable.shape_button2)
        swipeBtnEnabled.setSlidingButtonBackground(ContextCompat.getDrawable(this, R.drawable.shape_rounded2))

        swipeBtnEnabled.setOnStateChangeListener { active ->
            Toast.makeText(this, "State: $active", Toast.LENGTH_SHORT).show()
            if (active) {
                swipeBtnEnabled.setButtonBackground(ContextCompat.getDrawable(this, R.drawable.shape_button))
            } else {
                swipeBtnEnabled.setButtonBackground(ContextCompat.getDrawable(this, R.drawable.shape_button3))
            }
        }

        swipeNoState.setOnActiveListener {
            Toast.makeText(this, "Active!", Toast.LENGTH_SHORT).show()
        }

    }

}