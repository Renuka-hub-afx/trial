package com.example.trial.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    fun getUserByEmail(email: String): LiveData<User> {
        return userDao.getUserByEmail(email)
    }

    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}