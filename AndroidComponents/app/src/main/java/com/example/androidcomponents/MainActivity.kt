package com.example.androidcomponents

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var dialogButton: Button
    private lateinit var webViewButton: Button
    private lateinit var datePickerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpView()
    }

    private fun setUpView() {
        dialogButton = findViewById(R.id.dialog_button)
        dialogButton.setOnClickListener { customDialog() }

        webViewButton = findViewById(R.id.webView_button)
        webViewButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        datePickerButton = findViewById(R.id.date_picker_button)
        datePickerButton.setOnClickListener { myDatePickerDialog() }
    }

    /**
     * Date Picker Dialog
     * */
    private fun myDatePickerDialog() {
        DatePickerDialog(this).apply {
            setTheme(R.style.Animation_AppCompat_Dialog)
            setOnDateSetListener { datePicker, year, month, day ->
                Toast.makeText(context, "year: $year month: ${month + 1} day: $day", LENGTH_SHORT).show()
            }
        }.show()
    }

    /**
     * Dialog Box
     * */
    private fun customDialog() {
        AlertDialog.Builder(this).apply {
            setIcon(R.drawable.ic_dialog_24)
            setTitle("My Dialog")
            setMessage("This is dialog content")
            setPositiveButton("OK") { dialog, p1 ->
                Toast.makeText(this.context, "Ok button clicked", LENGTH_SHORT).show()
            }
            setNegativeButton("Cancel") { dialog, p1 ->
                Toast.makeText(this.context, "cancel button clicked", LENGTH_SHORT).show()
            }
        }.show()
    }

    /**
     * Swipe Menu ListView
     * https://github.com/baoyongzhang/SwipeMenuListView
     * */
}