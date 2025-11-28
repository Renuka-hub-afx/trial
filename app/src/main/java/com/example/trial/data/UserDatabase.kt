package com.example.trial.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.trial.data.User // Ensure this points to data.User
import com.example.trial.data.Goal // Added Goal import

@Database(entities = [User::class, Goal::class], version = 2, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user-db"
                )
                    .fallbackToDestructiveMigration() // Wipes data if version changes (good for dev)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}