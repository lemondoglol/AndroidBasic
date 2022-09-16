package com.example.wikiapp.tipcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.tip_calculator.TipCalculatorScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TipperFragment : Fragment() {

    private val viewModel: TipperFragmentViewModel by viewModels()

    private val args by navArgs<TipperFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Toast.makeText(context, "Percentage: ${args.tipPercentage}", Toast.LENGTH_SHORT).show()
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TipCalculatorScreen(
                        modifier = Modifier.fillMaxSize(),
                        eventHandler = viewModel
                    )
                }
            }
        }
    }

}