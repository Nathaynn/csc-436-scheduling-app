package com.zybooks.csc436_scheduling_app.data.events

import java.util.Date

sealed interface ReminderEvent {
    object saveReminder: ReminderEvent
    object showDialog: ReminderEvent
    object hideDialog: ReminderEvent
    data class setTitle(val title: String): ReminderEvent
    data class setLocation(val location: String): ReminderEvent
    data class setDate(val date: Date): ReminderEvent
    data class setTime(val time: Date): ReminderEvent
}