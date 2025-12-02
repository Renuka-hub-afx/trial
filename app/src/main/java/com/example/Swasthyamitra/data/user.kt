package com.example.Swasthyamitra.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userName: String,
    val email: String,
    val password: String,
    val birthDate: String
)
