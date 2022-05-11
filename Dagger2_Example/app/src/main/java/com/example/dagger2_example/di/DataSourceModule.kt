package com.example.dagger2_example.di

import com.example.dagger2_example.network.CustomerServiceClient
import com.example.dagger2_example.network.CustomerServiceRepository
import com.example.dagger2_example.network.CustomerServiceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * for all repositories
 * */
@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindCustomerServiceRepository(repositoryImpl: CustomerServiceRepositoryImpl) : CustomerServiceRepository

//    companion object {
//        @Singleton
//        @Provides
//        fun provideCustomerServiceClient(retrofit: Retrofit): CustomerServiceClient {
//            return retrofit.create(CustomerServiceClient::class.java)
//        }
//    }

}