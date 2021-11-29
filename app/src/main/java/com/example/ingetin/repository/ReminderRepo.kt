package com.example.ingetin.repository

import com.example.ingetin.entity.Reminder

class ReminderRepo {
    var listReminders = mutableListOf<Reminder>()

    init {
        listReminders.add(Reminder("Test", 8, 20, true))
    }

    fun getReminder() = listReminders

    fun addReminder(reminder: Reminder){
        listReminders.add(reminder)
    }
}