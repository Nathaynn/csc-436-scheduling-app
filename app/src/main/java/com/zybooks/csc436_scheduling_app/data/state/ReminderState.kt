package com.zybooks.csc436_scheduling_app.data.state

import com.zybooks.csc436_scheduling_app.data.model.Reminder
import java.util.Date

data class ReminderState(
    val reminders: List<Reminder> = emptyList(),
    val title: String = "",
    val location: String? = null,
    val date: Date = Date(0),
    val time: Date = Date(0),
    val isAddingReminder: Boolean = false
    )