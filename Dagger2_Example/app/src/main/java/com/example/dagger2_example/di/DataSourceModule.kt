package com.example.dagger2_example.di

import com.example.dagger2_example.network.CustomerServiceRepository
import com.example.dagger2_example.network.CustomerServiceRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * for all repositories
 * */
@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindCustomerServiceRepository(
        repositoryImpl: CustomerServiceRepositoryImpl
    ) : CustomerServiceRepository

}