package com.example.dagger2_example.network

import com.example.dagger2_example.models.User
import io.reactivex.Flowable

interface CustomerServiceRepository {
    fun getUser(id: Int): Flowable<User>
}