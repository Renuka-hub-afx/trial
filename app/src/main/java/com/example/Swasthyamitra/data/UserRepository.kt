package com.example.Swasthyamitra.data

import androidx.lifecycle.LiveData
import com.example.Swasthyamitra.model.User

class UserRepository(private val dao: UserDao) {

    suspend fun insertUser(user: User): Long {
        return dao.insertUser(user)
    }

    fun getUserByEmail(email: String): LiveData<User?> {
        return dao.getUserByEmail(email)
    }
}
