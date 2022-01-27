package com.example.workmanagerexample

import android.content.Context
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val OUTPUT_DATA_KEY = "output data key"
const val OUTPUT_DATA_VALUE = "output data value"

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        // the work will automatically be executed in non-Main thread
        CoroutineScope(Dispatchers.Main).launch {
            Toast.makeText(applicationContext, "started: ${inputData.getString(INPUT_DATA_KEY)}", Toast.LENGTH_SHORT).show()
        }

        Thread.sleep(5000)

        // workDataOf is optional. used if you want to return some data back
        return Result.success(workDataOf(Pair(OUTPUT_DATA_KEY, OUTPUT_DATA_VALUE)))
    }

}