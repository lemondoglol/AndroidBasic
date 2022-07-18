package com.example.hiltexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.hiltexample.ui.theme.HiltExampleTheme
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var doSomethingObj: DoSomething

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(doSomethingObj.doSomething())
                }
            }
        }
    }
}

class DoSomething @Inject constructor(
    private val someInterface: SomeInterface
) {
    fun doSomething() = someInterface.getAThing()
}

class SomeInterfaceImpl @Inject constructor(
    private val gson: Gson
) : SomeInterface {
    override fun getAThing(): String {
        return "Ryan is the best!"
    }
}

interface SomeInterface {
    fun getAThing(): String
}

@InstallIn(SingletonComponent::class) // this will survive through the app
@Module
class MyModule {

//    @Singleton
//    @Provides
//    fun providesSomeInterface(gson: Gson): SomeInterface = SomeInterfaceImpl(gson = gson)

    /**
     * Use provides for 3rd party object creation
     * */
    @Singleton
    @Provides
    fun provideGSon(): Gson = Gson()

}

@InstallIn(SingletonComponent::class)
@Module
abstract class MyInterfaceModule {

    /**
     * Use @Binds for your own interface creation
     * */
    @Singleton
    @Binds
    abstract fun bindSomeInterface(someInterfaceImpl: SomeInterfaceImpl): SomeInterface

}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}