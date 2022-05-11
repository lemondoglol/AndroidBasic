package com.example.dagger2_example.network

import android.util.Log
import com.example.dagger2_example.models.User
import io.reactivex.Flowable
import io.reactivex.Observer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CustomerServiceRepositoryImpl @Inject constructor(
    private val customerServiceClient: CustomerServiceClient
) : CustomerServiceRepository {

    override fun getUser(id: Int): Flowable<User> {
        // setup request, and the call
        return customerServiceClient.getUser(id)
    }

}