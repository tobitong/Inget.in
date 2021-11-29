package com.example.ingetin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ingetin.dao.ReminderDao
import com.example.ingetin.entity.Reminder

@Database(entities = [Reminder::class],version = 1,exportSchema = false)
abstract class ReminderDatabase:RoomDatabase() {
    companion object{
        var notesDatabase:ReminderDatabase? =null
        @Synchronized
        fun getDatabase(context: Context):ReminderDatabase{
            if(notesDatabase!=null){
                notesDatabase= Room.databaseBuilder(
                    context,
                    ReminderDatabase::class.java,
                    "reminder.db"
                ).build()
            }
            return notesDatabase!!
        }
    }
    abstract fun reminderDao():ReminderDao

}