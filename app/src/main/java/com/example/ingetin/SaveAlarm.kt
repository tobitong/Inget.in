package com.example.ingetin

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import java.util.*

class SaveAlarm {

    var context: Context?=null
    var sharedPreferences: SharedPreferences?=null
    constructor(context: Context){
        this.context = context
        sharedPreferences = context.getSharedPreferences("Reminder Alarm Data", Context.MODE_PRIVATE)
    }

    fun saveAlarmData(hour: Int, minute: Int) {
        var editor = sharedPreferences!!.edit()
        editor.putInt("hour", hour)
        editor.putInt("minute", minute)
        editor.commit()
    }

    fun getHour(): Int {
        return sharedPreferences!!.getInt("hour", 0)
    }

    fun getMinute(): Int {
        return sharedPreferences!!.getInt("minute", 0)
    }

    fun setAlarm(){
        val hour: Int = getHour()
        val minute: Int = getMinute()
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE,minute)
        calendar.set(Calendar.SECOND,0)

        val alarmManager = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        var intent = Intent(context,ReminderReceiver::class.java)
        intent.putExtra("message", " alarm time")
        intent.action = "com.tester.alarmmanager"

        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
        AlarmManager.INTERVAL_DAY, pendingIntent)
    }
}