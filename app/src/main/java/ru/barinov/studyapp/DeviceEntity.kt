package ru.barinov.studyapp

import androidx.room.Entity

@Entity(tableName = "devices_table")
data class DeviceEntity(
    val mac: String
)