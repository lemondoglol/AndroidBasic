package com.example.wikiapp.clinician_saver

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clinician_saver.ClinicianSaverHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ClinicianSaverFragmentViewModel @Inject constructor(

) : ViewModel(), ClinicianSaverHandler {

    var datePick by mutableStateOf("")
        private set

    fun updateDatePick(newDate: Long?) {
        newDate?.let {
            val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.US)
            val calendar = Calendar.getInstance(Locale.US)
            calendar.timeInMillis = it
            datePick = formatter.format(calendar.time)
        }
    }

}