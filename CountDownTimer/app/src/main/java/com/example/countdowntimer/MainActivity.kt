package com.example.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModel: MyViewModel
    private lateinit var timerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerTextView = findViewById(R.id.timer_textView)


        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.currentTimeStr.observe(this, {
            timerTextView.text = it.toString()
        })

        findViewById<Button>(R.id.start_button).setOnClickListener {
            myViewModel.startTimer()
        }
    }

}