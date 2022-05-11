package com.example.dagger2_example.di

import com.example.dagger2_example.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    /**
     * you can do @ContributesAndroidInjector(modules = [MainActivity::class])
     * to include more injections only available for MainActivity
     * */
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

}