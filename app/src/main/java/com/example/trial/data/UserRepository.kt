package com.example.trial.data

import androidx.lifecycle.LiveData
import com.example.trial.model.User

class UserRepository(private val dao: UserDao) {

    suspend fun insertUser(user: User): Long {
        return dao.insertUser(user)
    }

    fun getUserByEmail(email: String): LiveData<User?> {
        return dao.getUserByEmail(email)
    }
}
