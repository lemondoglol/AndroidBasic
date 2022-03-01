package com.example.roomdbexample

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 *  for some old version room/Windows issue. all methods defined with suspend will cause bug
 *  define suspend in repository
 * */
@Dao
interface UserDao {

    @Insert
    fun insertUser(user: UserEntity)

    @Insert
    fun insertAllUsers(vararg users: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    /**
     * Flow produces values one at a time (instead of all at once) that can generate values
     * from async operations like network requests, database calls, or other async code.
     * It supports coroutines throughout its API, so you can transform a flow
     * using coroutines as well!
     * Flow is good for Database. Flow is not lifecycle aware.
     * Flow is sort of reactive stream.
     * */
    @Query("SELECT * FROM users ORDER BY first_name ASC")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM users WHERE last_name LIKE :lastName")
    fun getUsersWithLastName(lastName: String): Flow<List<UserEntity>>

    @Query("SELECT * FROM users WHERE last_name IN (:lastNames)")
    fun getUsersWithLastNames(lastNames: List<String>): List<UserEntity>
}