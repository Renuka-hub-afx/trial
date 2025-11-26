package com.example.trial

import android.app.Application
import com.example.trial.data.UserDatabase
import com.example.trial.data.UserRepository

class UserApplication : Application() {

    // 1. Initialize the Database lazily (only when first needed)
    // "by lazy" means it won't be created until you actually ask for it
    private val database by lazy { UserDatabase.getDatabase(this) }

    // 2. Initialize the Repository lazily
    // The repository needs the 'userDao' from the database we just created
    val repository by lazy { UserRepository(database.userDao()) }
}
