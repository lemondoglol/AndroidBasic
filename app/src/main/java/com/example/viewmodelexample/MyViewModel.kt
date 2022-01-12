package com.example.viewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    // init LiveData
    val likedNumber: MutableLiveData<Int> by lazy {
        MutableLiveData(0)
    }

    // define LiveData operations
    fun likeButtonClicked() {
        likedNumber.value = likedNumber.value?.plus(1)
    }

    fun disLikeButtonClicked() {
        likedNumber.value = likedNumber.value?.minus(1)
    }

}