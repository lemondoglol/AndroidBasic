package com.example.roomdbexample

import android.app.Application

/**
 * You want to have only one instance of the database and of the repository in your app.
 * An easy way to achieve this is by creating them as members of the Application class.
 * Then they will just be retrieved from the Application whenever they're needed,
 * rather than constructed every time.
 *
 * Because these objects should only be created when they're first needed,
 * rather than at app startup, you're using Kotlin's property delegation: by lazy.
 *
 * this is also the way to handle the DI
 * */
class UserApplication : Application() {
    private val database by lazy { UserDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}