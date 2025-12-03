package com.zybooks.csc436_scheduling_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "reminder")
data class Reminder(
    val title: String,
    val location: String?,
    val date: Date,
    val time: Date,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)