package com.example.coroutineexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

private const val API_RESULT_1 = "API_RESULT #1"
private const val API_RESULT_2 = "API_RESULT #2"
private const val TIMEOUT_LIMIT = 1900L

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var timeOutButton: Button
    private lateinit var asyncButton: Button
    private lateinit var sequentialButton: Button
    private lateinit var startCancellableButton: Button
    private lateinit var stopCancellableButton: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()

        button.setOnClickListener { makeSimpleAPICall() }
        timeOutButton.setOnClickListener { makeAPICallWithTimeOut() }
        asyncButton.setOnClickListener { asyncCall() }
        sequentialButton.setOnClickListener { sequentialCall() }
        startCancellableButton.setOnClickListener { startCancellableJob() }
        stopCancellableButton.setOnClickListener { cancelJob() }
    }

    // Simple API Call
    private fun makeSimpleAPICall() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiCallProcess1()
            updateTextView(response)
        }
    }

    // withTimeoutOrNull
    private fun makeAPICallWithTimeOut() {
        CoroutineScope(Dispatchers.IO).launch {
            val job = withTimeoutOrNull(TIMEOUT_LIMIT) {
                val response1 = apiCallProcess1()
                updateTextView(response1)

                val response2 = apiCallProcess1()
                updateTextView(response2)
                // response2 will run after response1 done
            }

            if (job == null) {
                updateTextView("Time Out!!!")
            }
        }
    }

    // make async call
    private fun asyncCall() {
        CoroutineScope(Dispatchers.IO).launch { // parent job
            val executionTime = measureTimeMillis {
                val job1 = async { // child job
                    apiCallProcess1()
                }
                val job2 = async { // child job
                    apiCallProcess2()
                }

                // job1 and job2 async run without blocking
                // but job1 will still be update before job2
                updateTextView(job1.await())
                updateTextView(job2.await())
            }
            updateTextView("Total run time is: ${executionTime}")
        }
    }

    // make sequential call
    private fun sequentialCall() {
        CoroutineScope(Dispatchers.IO).launch { // parent job
            val executionTime = measureTimeMillis {
                val job1 = async { // child job
                    apiCallProcess1()
                }.await()

                val job2 = async { // child job
                    apiCallProcess2()
                }.await()

                updateTextView(job1)
                updateTextView(job2)
            }
            updateTextView("Total run time is: ${executionTime}")
        }
    }

    // cancellable job
    private lateinit var cancellableJob: CompletableJob

    private fun startCancellableJob() {
        // init cancellable job
        cancellableJob = Job()
        cancellableJob.invokeOnCompletion {
            it?.message.let {
                CoroutineScope(Dispatchers.Main).launch {
                    updateTextView(it ?: "Job Got Cancelled")
                }
            }
        }
        // make api call, if we cancel this job, it will only cancel this specific job
        // note: cancellableJob is being used here
        CoroutineScope(Dispatchers.IO + cancellableJob).launch {
            val result = apiCallProcess2()
            updateTextView(result)
        }
    }

    private fun cancelJob() {
        if (!::cancellableJob.isInitialized) {
            startCancellableJob()
        } else if (cancellableJob.isActive || cancellableJob.isCompleted) {
            cancellableJob.cancel(CancellationException("Job Cancelled"))
        }
    }

    // Exception Handler
    private val myExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Toast.makeText(this, "Exception: $throwable", Toast.LENGTH_SHORT).show()
    }

    // if one of the sub child task failed, it will not fail the whole parent job
    private fun mySuperVisorScope() {
        CoroutineScope(Dispatchers.IO).launch(myExceptionHandler) { // parent job
            supervisorScope {
                launch { //child job
                    apiCallProcess1()
                }
                launch { // child job
                    apiCallProcess2()
                }
            }
        }
    }

    /**
     * Shared Part
     * */
    // pretending API Call (from Coroutine)
    private suspend fun apiCallProcess1(): String {
        delay(2500L)
        return API_RESULT_1
    }

    // pretending API Call (from Coroutine)
    private suspend fun apiCallProcess2(): String {
        delay(1000L)
        return API_RESULT_2
    }

    // update UI in Main Scope
    private suspend fun updateTextView(text: String) {
        withContext(Dispatchers.Main) {
            textView.text = textView.text.toString() + "\n$text"
        }
    }

    private fun setUpView() {
        button = findViewById(R.id.button)
        timeOutButton = findViewById(R.id.timeOut_button)
        textView = findViewById(R.id.textView)
        asyncButton = findViewById(R.id.async_button)
        sequentialButton = findViewById(R.id.seq_button)
        startCancellableButton = findViewById(R.id.startCancelJob_button)
        stopCancellableButton = findViewById(R.id.cancel_job_button)
    }
}