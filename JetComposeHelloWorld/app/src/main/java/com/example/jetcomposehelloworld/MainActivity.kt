package com.example.jetcomposehelloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetcomposehelloworld.ui.theme.JetComposeHelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeHelloWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Greeting("Android")
                        CustomTextView(text = "Hello World")
                        SelectableText()
                    }
                }
            }
        }
    }
}

@Composable
fun SelectableText() {
    SelectionContainer {
        Text(text = stringResource(id = R.string.app_name))
    }
}

@Composable
fun Greeting(name: String) {
//    Text(text = "Hello $name!")
    Text(text = stringResource(id = R.string.app_name))
}

@Composable
fun CustomTextView(text: String) {
    Text(
        text = "My Custom View $text",
        style = MaterialTheme.typography.h5
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetComposeHelloWorldTheme {
        Greeting("Android")
    }
}