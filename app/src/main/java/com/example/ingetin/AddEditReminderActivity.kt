package com.example.ingetin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker

class AddEditReminderActivity : AppCompatActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_reminder)

        val btnCancel = findViewById<Button>(R.id.btnCancel)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val tpAlarm = findViewById<TimePicker>(R.id.tpReminder)

        btnCancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        btnSave.setOnClickListener {
            val saveAlarm = SaveAlarm(applicationContext)
            saveAlarm.setAlarm(tpAlarm.hour, tpAlarm.minute)
            saveAlarm.saveAlarmData(tpAlarm.hour, tpAlarm.minute)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    fun setTime(hour: Int, minute: Int){

    }
}