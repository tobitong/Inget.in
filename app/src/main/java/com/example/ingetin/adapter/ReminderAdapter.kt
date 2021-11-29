package com.example.ingetin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.ingetin.R
import com.example.ingetin.entity.Reminder

class ReminderAdapter(
    var datas: LiveData<List<Reminder>>
) : RecyclerView.Adapter<ReminderAdapter.ViewHolder>() {
    private val allReminders = ArrayList<Reminder>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reminder_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            val tvTitle = findViewById<TextView>(R.id.tvReminderTitle)
            val tvAlarm = findViewById<TextView>(R.id.tvReminderAlarm)

            tvTitle.setText(allReminders.get(position).title)
            tvAlarm.setText("" + allReminders.get(position).hours + ":" + allReminders.get(position).hours)
        }
    }

    fun updateList(newList: List<Reminder>) {
        allReminders.clear()
        allReminders.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return allReminders.size
    }

}