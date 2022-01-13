package com.example.androidexamples.foractivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidexamples.R

class ForActivityResult : AppCompatActivity() {

    lateinit var number1TextView: EditText
    lateinit var number2TextView: EditText
    lateinit var answerTextView: TextView

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val intent = it.data
            val strData = intent?.extras?.get("Answer").toString()
            answerTextView.text = "Answer is: " + strData
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_result)
        setUpView()

        findViewById<Button>(R.id.goTo_button).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("Number1", number1TextView.text.toString())
            intent.putExtra("Number2", number2TextView.text.toString())
            startForResult.launch(intent)
        }
    }

    private fun setUpView() {
        number1TextView = findViewById(R.id.editText1)
        number2TextView = findViewById(R.id.editText2)
        answerTextView = findViewById(R.id.answer_textView)
    }
}