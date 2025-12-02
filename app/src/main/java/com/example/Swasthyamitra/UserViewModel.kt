package com.example.trial.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.trial.data.UserRepository
import com.example.trial.model.User
import kotlinx.coroutines.launch

class UserViewModel(private val repo: UserRepository) : ViewModel() {

    fun getUserByEmail(email: String): LiveData<User?> = repo.getUserByEmail(email)

    fun insertUser(user: User, onComplete: (Long) -> Unit = {}) {
        viewModelScope.launch {
            val id = repo.insertUser(user)
            onComplete(id)
        }
    }

    class UserViewModelFactory(private val repo: UserRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(repo) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
