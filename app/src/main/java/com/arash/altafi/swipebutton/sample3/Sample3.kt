package com.arash.altafi.swipebutton.sample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.arash.altafi.swipebutton.R
import kotlinx.android.synthetic.main.activity_sample3.*

class Sample3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample3)

        init()
    }

    private fun init() {

        customSwipeButton1.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }

        customSwipeButton1.isChecked = true
//        customSwipeButton1.isEnable = true
        customSwipeButton1.checkedText = "Checked text"
        customSwipeButton1.uncheckedText = "Unchecked text"
        customSwipeButton1.textSize = resources.getDimensionPixelSize(R.dimen.default_text_size).toFloat()
        customSwipeButton1.swipeProgressToFinish = 0.1
        customSwipeButton1.swipeProgressToStart = 0.3
        customSwipeButton1.checkedTextColor = ContextCompat.getColor(this,R.color.checkedTextColor)
        customSwipeButton1.uncheckedTextColor = ContextCompat.getColor(this,R.color.uncheckedTextColor)
        customSwipeButton1.checkedBackground = ContextCompat.getDrawable(this, R.drawable.shape_sample_scrolling_view_checked)
        customSwipeButton1.uncheckedBackground = ContextCompat.getDrawable(this, R.drawable.shape_sample_scrolling_view_unchecked)
        customSwipeButton1.checkedToggleBackground = ContextCompat.getDrawable(this, R.drawable.shape_sample_checked_toggle)
        customSwipeButton1.uncheckedToggleBackground = ContextCompat.getDrawable(this, R.drawable.shape_sample_unchecked_toggle)
        customSwipeButton1.checkedIcon = ContextCompat.getDrawable(this, R.drawable.ic_done_black)
        customSwipeButton1.uncheckedIcon = ContextCompat.getDrawable(this, R.drawable.ic_pause_black)

    }

}