package com.example.countdowntimer

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    companion object {
        // Time when the game is over
        private const val DONE = 0L
        // Countdown time interval
        private const val ONE_SECOND = 1000L
        // Total time for the game
        private const val COUNTDOWN_TIME = 60000L
    }

    private val _currentTime = MutableLiveData<Long>()
    val currentTimeStr: LiveData<String> = Transformations.switchMap(_currentTime) {
        val result = MutableLiveData<String>()
        result.value = "current Time is " + DateUtils.formatElapsedTime(it)
        result
    }

    private val timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
        override fun onTick(totalTime: Long) {
            _currentTime.value = totalTime / ONE_SECOND
        }

        override fun onFinish() {
            _currentTime.value = DONE
        }
    }

    // will be called when the viewModel gets destroyed
    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    fun startTimer() {
        timer.start()
    }

}