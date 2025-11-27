package com.example.trial

import android.app.Application
import com.example.trial.data.UserDatabase
import com.example.trial.data.UserRepository

class UserApplication : Application() {
    lateinit var repository: UserRepository
        private set

    override fun onCreate() {
        super.onCreate()
        val db = UserDatabase.getInstance(this)
        repository = UserRepository(db.userDao())
    }
}
