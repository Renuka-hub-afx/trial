package com.example.trial.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "goals",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Goal(
    @PrimaryKey(autoGenerate = true)
    val goalId: Long = 0,

    val userId: Long,          // This matches 'userId' in your error
    val goalType: String,      // This matches 'goalType' in your error
    val dailyCalorieTarget: Int, // This matches 'dailyCalorieTarget'
    val waterGoalMl: Int,      // This matches 'waterGoalMl'
    val status: String         // This matches 'status'
)