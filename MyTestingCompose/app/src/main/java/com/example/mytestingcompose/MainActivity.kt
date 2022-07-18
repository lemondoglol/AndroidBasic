package com.example.mytestingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytestingcompose.ui.theme.MyTestingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTestingComposeTheme {
                Surface(
                    // make it to cover the whole screen
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // use Modifier.align to override
        Column(modifier = Modifier.align(Alignment.End)) {
            Text(text = "Hello $name!")
        }

        Column(modifier = Modifier.align(Alignment.Start)) {
            Text(text = "Hello www $name!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTestingComposeTheme {
        Greeting("Android")
    }
}