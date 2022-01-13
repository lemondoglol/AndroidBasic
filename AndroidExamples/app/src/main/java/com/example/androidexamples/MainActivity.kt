package com.example.androidexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidexamples.foractivityresult.ForActivityResult

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.activity_result_button).setOnClickListener {
            startActivity(Intent(this, ForActivityResult::class.java))
        }
    }
}