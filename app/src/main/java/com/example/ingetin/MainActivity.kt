package com.example.ingetin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ingetin.adapter.ReminderAdapter
import com.example.ingetin.repository.ReminderRepo
import com.example.ingetin.viewmodel.ReminderVM
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addFAB = findViewById<FloatingActionButton>(R.id.btnAddReminder)
        val reminderRepo = ReminderRepo()
        val reminderVM = ReminderVM(reminderRepo)
        val rv = findViewById<RecyclerView>(R.id.rvReminder)
        val reminderAdapter = ReminderAdapter(reminderVM.getReminders())

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = reminderAdapter

        reminderVM.reminders.observe(this, { list ->
            list?.let {
                reminderAdapter.updateList(it)
            }
        })

        addFAB.setOnClickListener {
            val intent = Intent(this, AddEditReminderActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}