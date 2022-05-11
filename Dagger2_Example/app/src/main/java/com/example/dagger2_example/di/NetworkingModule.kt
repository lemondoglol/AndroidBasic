package com.example.dagger2_example.di

import com.example.dagger2_example.network.CustomerServiceClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * for all Clients
 * */
@Module
class NetworkingModule {

    @Singleton
    @Provides
    fun provideCustomerServiceClient(retrofit: Retrofit) = retrofit.create(CustomerServiceClient::class.java)

}