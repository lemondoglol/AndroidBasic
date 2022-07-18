package com.example.wikiapp.clinician_saver

import androidx.lifecycle.ViewModel
import com.example.clinician_saver.ClinicianSaverHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClinicianSaverFragmentViewModel @Inject constructor(

) : ViewModel(), ClinicianSaverHandler {
}