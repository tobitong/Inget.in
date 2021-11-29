package com.example.ingetin.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Info")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name ="title")
    val title: String,
    @ColumnInfo(name="hours")
    val hours: Int,
    @ColumnInfo(name="minutes")
    val minutes: Int,
    @ColumnInfo(name="switch")
    val switch: Boolean) {
}