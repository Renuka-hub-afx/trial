package com.example.trial

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trial.data.User // Make sure this path is correct
import com.example.trial.data.UserRepository // Make sure this path is correct

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    // This is the function the LoginActivity is trying to call
    fun getUserByEmail(email: String): LiveData<User> {
        return repository.getUserByEmail(email)
    }

    // Factory class required to initialize the ViewModel with the Repository
    class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}