package com.example.loadingmockktesting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    var currentState = MutableStateFlow<MyState>(MyState.Idle)

    fun testState() {
        viewModelScope.launch {
            currentState.value = MyState.IsLoading
            currentState.value = MyState.Success
        }
    }

}

sealed class MyState {
    object Idle : MyState()
    object IsLoading : MyState()
    object Success : MyState()
}