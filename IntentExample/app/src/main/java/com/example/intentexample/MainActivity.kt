package com.example.intentexample

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // dial a call
        val number = Uri.parse("tel:5714220137")
        val dialIntent = Intent(Intent.ACTION_DIAL, number)
        findViewById<Button>(R.id.dial_button).setOnClickListener {
            try {
                startActivity(dialIntent)
            } catch (e: ActivityNotFoundException) {
                // do something if couldn't find any app to start this intent
            }
        }

        // view a web
        val webSite = Uri.parse("https://www.google.com")
        val webIntent = Intent(Intent.ACTION_VIEW, webSite)
        findViewById<Button>(R.id.viewWeb_button).setOnClickListener { startActivity(webIntent) }

        // send email with an attachment
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("ryanchen2525@gmail.com")) // recipients
            putExtra(Intent.EXTRA_SUBJECT, "Email subject")
            putExtra(Intent.EXTRA_TEXT, "Email message text")
            putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment")) // attachment
            // You can also attach multiple items by passing an ArrayList of Uris
        }
        findViewById<Button>(R.id.sendEmail_button).setOnClickListener { startActivity(emailIntent) }

        // calender event
        val calendarIntent = Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI).apply {
            val beginTime = Calendar.getInstance().time
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
            putExtra(CalendarContract.Events.TITLE, "Ninja Class")
            putExtra(CalendarContract.Events.EVENT_LOCATION, "Maryland")
        }
        findViewById<Button>(R.id.calendarEvent_button).setOnClickListener { startActivity(calendarIntent) }

    }
}