package com.example.ingetin.dao

import android.icu.text.IDNA
import androidx.room.*
import com.example.ingetin.entity.Reminder

@Dao
interface ReminderDao {
    @get:Query("SELECT * FROM Info ORDER BY id DESC")
    val allReminder:List<Reminder>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note:Reminder)
    @Delete
    fun delete(note: Reminder)
}