package com.arash.altafi.swipebutton.sample5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arash.altafi.swipebutton.R
import co.mobiwise.library.ProgressLayout.ProgressLayoutListener
import kotlinx.android.synthetic.main.activity_basic_usage.*


class BasicUsageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_usage)

        init()

    }

    private fun init() {
        progressLayout.setProgressLayoutListener(object : ProgressLayoutListener {
            override fun onProgressCompleted() {
                Toast.makeText(this@BasicUsageActivity, "complete", Toast.LENGTH_SHORT).show()
            }

            override fun onProgressChanged(seconds: Int) {
                Toast.makeText(this@BasicUsageActivity, "seconds : $seconds", Toast.LENGTH_SHORT).show()
            }
        })
        progressLayout.start()
    }

}