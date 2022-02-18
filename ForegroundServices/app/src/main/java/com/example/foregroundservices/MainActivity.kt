package com.example.foregroundservices

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var bindButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        bindButton = findViewById(R.id.button)

        val serviceConnection = object : ServiceConnection {
            override fun onServiceConnected(p0: ComponentName?, binder: IBinder?) {
                (binder as MyService.MyBinder).myService.myNumber.observe(this@MainActivity) {
                    textView.text = "$it"
                }
            }

            override fun onServiceDisconnected(p0: ComponentName?) {}

        }

        bindButton.setOnClickListener {
            Intent(this, MyService::class.java).also {
                // to make the service keeps running
                startService(it)
                bindService(it, serviceConnection, Context.BIND_AUTO_CREATE)
            }
        }
    }
}