package ru.barinov.studyapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDAO {

    @Query("SELECT * FROM DEVICES_TABLE WHERE mac =:mac")
    fun getDeviceByMac(mac: String): Flow<List<DeviceEntity>>

    @Query("SELECT * FROM DEVICES_TABLE ")
    fun getDevices(): Flow<List<DeviceEntity>>
}