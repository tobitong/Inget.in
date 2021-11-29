package com.example.ingetin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ingetin.entity.Reminder
import com.example.ingetin.repository.ReminderRepo

class ReminderVM(val reminderRepo: ReminderRepo) : ViewModel() {
    var reminders = MutableLiveData<List<Reminder>>()

    fun addReminders(reminder: Reminder) {
        reminderRepo.addReminder(reminder)
        reminders.value = reminderRepo.getReminder()
    }

    fun getReminders(): LiveData<List<Reminder>> {
        reminders.value = reminderRepo.getReminder()
        return reminders
    }
}