package com.arash.altafi.swipebutton.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arash.altafi.swipebutton.R
import kotlinx.android.synthetic.main.activity_sample1.*

class Sample1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample1)

        init()
    }

    private fun init() {

        slidingButton.setOnStateChangeListener {
            if (it) {
                Toast.makeText(this, "true", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this , "false" , Toast.LENGTH_SHORT).show()
            }
        }

    }

}