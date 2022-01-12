package com.example.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var likedNumberTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.likedNumber.observe(
            this,
            { likedNumberTextView.text = viewModel.likedNumber.value.toString() }
        )

        // viewBinding and add actions
        likedNumberTextView = findViewById(R.id.likedNumberView)
        findViewById<ImageButton>(R.id.thumb_up_imageButton).setOnClickListener {
            viewModel.likeButtonClicked()
        }
        findViewById<ImageButton>(R.id.thumb_down_imageButton).setOnClickListener {
            viewModel.disLikeButtonClicked()
        }
    }
}