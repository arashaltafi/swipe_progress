package com.arash.altafi.swipebutton.sample0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arash.altafi.swipebutton.databinding.ActivitySample0Binding

class Sample0 : AppCompatActivity() {

    private lateinit var binding: ActivitySample0Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySample0Binding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        binding.apply {
            swipeBtnLogout.setOnActiveListener(object: OnActiveListener {
                override fun onActive() {
                    Toast.makeText(this@Sample0, "Active Logout", Toast.LENGTH_SHORT).show()
                }
            })
            swipeBtnLogin.setOnActiveListener(object: OnActiveListener {
                override fun onActive() {
                    Toast.makeText(this@Sample0, "Active Login", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

}