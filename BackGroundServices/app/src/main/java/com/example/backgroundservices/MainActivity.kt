package com.example.backgroundservices

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)

        findViewById<Button>(R.id.startService_button).setOnClickListener {
            // launch a background service
            Intent(this, MyBackgroundService::class.java).also { serviceIntent ->
                startService(serviceIntent)
            }
        }

    }

    // services can be implemented in onCreate(...) as well
    override fun onStart() {
        super.onStart()

        findViewById<Button>(R.id.bind_service_button).setOnClickListener {
            // binding service
            val bindIntent = Intent(this, MyBackgroundService::class.java)
            val serviceConnection = object : ServiceConnection {
                override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
                    (service as MyBackgroundService.MyBinder).myService.numberLiveData.observe(this@MainActivity) {
                        textView.text = "$it"
                    }
                }

                override fun onServiceDisconnected(p0: ComponentName?) {}
            }
            /**
             * the service will be killed if there is no clients/activities is bind with it
             * in order to keep the service alive, we can start the service first, and then bind it
             *
             * however, if we kill the whole app, then service will also be killed
             * */
            startService(bindIntent)
            bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE)
        }
    }
}