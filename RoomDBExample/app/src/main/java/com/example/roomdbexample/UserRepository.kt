package com.example.roomdbexample

/**
 * Repositories are meant to mediate between different data sources.
 * In this simple example, you only have one data source, so the Repository doesn't do much
 * */
class UserRepository(private val dao: UserDao) {

    val allUsers = dao.getAllUsers()

    fun insertUser(user: UserEntity) {
        dao.insertUser(user)
    }

    fun getUsersWithLastName(lastName: String) = dao.getUsersWithLastName(lastName)
}