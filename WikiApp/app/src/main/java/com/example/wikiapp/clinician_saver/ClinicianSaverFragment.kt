package com.example.wikiapp.clinician_saver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.clinician_saver.ClinicianSaverFragmentScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClinicianSaverFragment : Fragment() {

    private val viewModel: ClinicianSaverFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ClinicianSaverFragmentScreen(
                        modifier = Modifier.fillMaxSize(),
                        handler = viewModel
                    )
                }
            }
        }
    }
}
