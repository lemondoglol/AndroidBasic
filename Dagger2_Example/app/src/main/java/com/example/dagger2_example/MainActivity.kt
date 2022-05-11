package com.example.dagger2_example

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.dagger2_example.models.User
import com.example.dagger2_example.network.CustomerServiceClient
import com.example.dagger2_example.network.CustomerServiceRepository
import com.example.dagger2_example.network.CustomerServiceRepositoryImpl
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * make it extends DaggerAppCompatActivity
 */
class MainActivity : DaggerAppCompatActivity() {

//    val viewModel: MainActivityViewModel by viewModels()
    /**
     * use lateinit to do field injection
//     * */
//    @Inject
//    lateinit var repository: CustomerServiceRepository

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        repository.getUser(3)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainActivityViewModel::class.java]
        viewModel.getUser(2)
    }
}
