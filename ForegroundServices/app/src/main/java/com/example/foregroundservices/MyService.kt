package com.example.foregroundservices

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val CHANNEL_ID = "CHANNEL ID"
class MyService : LifecycleService() {

    val myNumber = MutableLiveData(0)

    override fun onCreate() {
        super.onCreate()

        lifecycleScope.launch {
            while (true) {
                delay(1000)
                myNumber.value = myNumber.value?.plus(1)
            }
        }

        createNotificationChannel()
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Title")
            .setContentText("Content Text")
            .setContentIntent(pendingIntent) // actions when the notification is clicked
            .build()

        // id can't be 0 here
        startForeground(1, notification)
    }

    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)

        return MyBinder()
    }

    // code from Google Doc
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    inner class MyBinder : Binder() {
        val myService = this@MyService
    }
}