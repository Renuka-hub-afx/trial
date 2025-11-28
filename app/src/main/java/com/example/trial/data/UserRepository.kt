package com.example.trial.data

import androidx.lifecycle.LiveData
import com.example.trial.data.User
import com.example.trial.data.Goal

class UserRepository(private val dao: UserDao) {

    // --- User Auth ---
    suspend fun insertUser(user: User): Long {
        return dao.insertUser(user)
    }

    fun getUserByEmail(email: String): LiveData<User?> {
        return dao.getUserByEmail(email)
    }

    // --- NEW: User Physical Stats (Height/Weight/Gender/BMI) ---
    suspend fun updateUserPhysicalStats(uid: Long, h: Float, w: Float, g: String, b: Float) {
        dao.updateUserPhysicalStats(uid, h, w, g, b)
    }

    // --- NEW: Goals ---
    suspend fun insertGoal(goal: Goal) {
        // FIX: Changed from InsertGoalActivity to insertGoal
        dao.insertGoal(goal)
    }
}
