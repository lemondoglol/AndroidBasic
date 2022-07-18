package com.example.medium_compose_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.medium_compose_example.ui.theme.Medium_compose_exampleTheme
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Medium_compose_exampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
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
    CoilImage(
        imageModel = "https://medium.com/mobile-app-development-publication/loading-image-in-android-jetpack-compose-made-easy-8cb593b26260",
//        modifier = modifier,
        // shows a shimmering effect when loading an image.
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = Color.Cyan,
            durationMillis = 350,
            dropOff = 0.65f,
            tilt = 20f
        ),
        // shows an error text message when request failed.
        failure = {
            Text(text = "image request failed.")
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Medium_compose_exampleTheme {
        Greeting("Android")
    }
}