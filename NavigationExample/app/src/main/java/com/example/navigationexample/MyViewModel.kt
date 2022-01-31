package com.example.navigationexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val _currentCount = MutableLiveData(0)
    val currentCount: LiveData<Int>
        get() = _currentCount

    fun increaseCount() {
        _currentCount.value = _currentCount.value?.plus(1)
    }

}