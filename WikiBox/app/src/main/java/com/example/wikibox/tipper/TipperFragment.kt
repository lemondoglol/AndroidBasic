package com.example.wikibox.tipper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.wikibox.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TipperFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                TipperFragmentScreen()

                Text(text = "TipperFragmentScreen")
                Button(onClick = {
                    findNavController().navigate(R.id.testingFragment)
                }) {
                    Text(text = "TO Testing FRAGMENT")
                }
            }
        }
    }

}

@Composable
fun TipperFragmentScreen() {
//    Text(text = "TipperFragmentScreen")
//    Button(onClick = {
//        findNavController().navigate(R.id.testingFragment)
//    }) {
//        Text(text = "TO Testing FRAGMENT")
//    }
}