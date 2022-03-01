package com.example.roomdbexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * 1. define as abstract class
 * 2. exportSchema has been set to false here, in order to avoid a build warning.
 *      In a real app, consider setting a directory for Room to use to export the schema
 *      so you can check the current schema into your version control system.
 * */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    // singleton. one instance for one DB
    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}