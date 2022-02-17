package com.example.backgroundservices

import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyBackgroundService : LifecycleService() {

    var number = 0

    val numberLiveData = MutableLiveData(0)

    // will be called when startService(intent) is called
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // make sure run this in non-main scope
//        lifecycleScope.launch {
//            while (true) {
//                delay(1000)
//                Log.d("hello", "onStartCommand: ${number++}")
//            }
//        }

        return super.onStartCommand(intent, flags, startId)
    }

    // trigger by bindService(...)
    override fun onBind(intent: Intent): IBinder {
        super.onBind(intent)

        // start a new service job outside UI/Main scope
        lifecycleScope.launch {
            while (true) {
                delay(500)
                numberLiveData.value = numberLiveData.value?.plus(1)
            }
        }

        return MyBinder()
    }

    // used for clients to access fields in this server
    inner class MyBinder : Binder() {
        val myService = this@MyBackgroundService
    }
}