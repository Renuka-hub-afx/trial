package com.example.Swasthyamitra

import android.app.Application
import com.example.Swasthyamitra.data.UserDatabase
import com.example.Swasthyamitra.data.UserRepository

class UserApplication : Application() {
    lateinit var repository: UserRepository
        private set

    override fun onCreate() {
        super.onCreate()
        val db = UserDatabase.getInstance(this)
        repository = UserRepository(db.userDao())
    }
}
