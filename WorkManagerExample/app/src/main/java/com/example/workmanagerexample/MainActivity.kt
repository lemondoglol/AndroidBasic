package com.example.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.work.*

const val INPUT_DATA_KEY = "input data key"
const val INPUT_DATA_VALUE = "input data value"

class MainActivity : AppCompatActivity() {

    private val workManager = WorkManager.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.work_button).setOnClickListener {
            startWorkManagerJob()
        }
    }

    private fun startWorkManagerJob() {
        val workRequest1 = createWorkRequest()
        val workRequest2 = createWorkRequest()

        // single request
//        workManager.enqueue(workRequest1)
        // multiple request
        workManager.beginWith(workRequest1)
            .then(workRequest2)
            .enqueue()

        // observe workRequest
        workManager.getWorkInfoByIdLiveData(workRequest1.id).observe(this, {
            if (it.state == WorkInfo.State.SUCCEEDED) {
                Toast.makeText(this, "finished: ${it.outputData.getString(OUTPUT_DATA_KEY)}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun createWorkRequest(): OneTimeWorkRequest {
        val workConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        return OneTimeWorkRequestBuilder<MyWorker>()
            .setConstraints(workConstraints)
            .setInputData(workDataOf(Pair(INPUT_DATA_KEY, INPUT_DATA_VALUE)))
            .build()
    }
}