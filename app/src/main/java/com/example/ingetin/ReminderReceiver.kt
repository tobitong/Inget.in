package com.example.ingetin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("com.tester.alarmmanager")){
            var b = intent.extras
            Toast.makeText(context, b?.getString("message"), Toast.LENGTH_LONG).show()
        } else if(intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){
            val saveAlarm = SaveAlarm(context!!)
            saveAlarm.setAlarm()
        }
    }
}