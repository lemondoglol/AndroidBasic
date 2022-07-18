package com.example.wikibox

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.findNavController
import com.example.wikibox.ui.theme.WikiBoxTheme
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
////        setContent {
////            WikiBoxTheme {
////                Surface(
////                    modifier = Modifier.fillMaxSize(),
////                    color = MaterialTheme.colors.background
////                ) {
////                    Content(
////                        modifier = Modifier.fillMaxSize()
////                    )
////                }
////            }
////        }
//    }

//    @SuppressLint("ResourceType")
//    @Composable
//    private fun Content(modifier: Modifier) {
//        Column(
//            modifier = modifier,
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Button(onClick = {
//                findNavController(R.navigation.home_nav_graph).navigate(R.id.tipperFragment)
//            }) {
//                Text(text = "Tip Calculator")
//            }
//        }
//    }
}


