package com.example.dagger2_example.network

import com.example.dagger2_example.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface CustomerServiceClient {

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Flowable<User>

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

}