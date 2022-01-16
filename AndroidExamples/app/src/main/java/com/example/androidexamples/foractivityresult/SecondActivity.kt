package com.example.androidexamples.foractivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidexamples.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.calculate_button).setOnClickListener {
            val bundle = intent?.extras?.getBundle("data")
            val number1 = bundle?.getString("Number1")?.toInt() ?: 0
            val number2 = bundle?.getString("Number2")?.toInt() ?: 0
            val answer = number1 + number2
            val resultIntent = Intent()
            resultIntent.putExtra("Answer", answer)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}