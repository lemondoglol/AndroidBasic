package com.example.wikiapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.getString(getString(R.string.user_name))?.let {
            Toast.makeText(context, "hello $it", Toast.LENGTH_SHORT).show()
        }

        return ComposeView(requireContext()).apply {
            setContent {
                ContentScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
    }

    @Composable
    private fun ContentScreen(
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Testing()

            Button(onClick = {
                val action = HomeFragmentDirections.actionHomeFragmentToTipperFragment(tipPercentage = 20)
                findNavController().navigate(action)
            }) {
                Text(text = stringResource(R.string.tip_calculator))
            }

            Button(onClick = {
                findNavController().navigate(R.id.clinicianSaverFragment)
            }) {
                Text(text = stringResource(R.string.clinician_close_time_picker))
            }

            Button(onClick = {
                findNavController().navigate(R.id.colorConverterFragment)
            }) {
                Text(text = stringResource(R.string.color_converter))
            }
        }
    }

    @Composable
    fun Testing(
        modifier: Modifier = Modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(size = 25.dp))
                .border(width = 10.dp, color = Color.Cyan, shape = RoundedCornerShape(25.dp)),
            painter = painterResource(id = R.drawable.hunter),
            contentDescription = "image contentDescription",
        )
    }
}