package com.example.dagger2_example

import com.example.dagger2_example.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        /**
         * need to build project first inorder to see DaggerAppComponent
         * */
        return DaggerAppComponent.builder().application(this).build()
    }
}