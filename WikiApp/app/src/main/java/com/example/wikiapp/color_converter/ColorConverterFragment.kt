package com.example.wikiapp.color_converter

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
import com.example.color_converter.ColorConverterScreen
import com.example.tip_calculator.TipCalculatorScreen
import com.example.wikiapp.tipcalculator.TipperFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ColorConverterFragment : Fragment() {

    private val viewModel: ColorConverterFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ColorConverterScreen(
                        modifier = Modifier.fillMaxSize(),
                        handler = viewModel
                    )
                }
            }
        }
    }

}