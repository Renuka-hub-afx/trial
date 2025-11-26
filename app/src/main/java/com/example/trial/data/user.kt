package com.example.trial.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "user_email")
    val email: String,

    @ColumnInfo(name = "password_hash")
    val password: String,

    @ColumnInfo(name = "user_name")
    val userName: String
)