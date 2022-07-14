package ru.barinov.studyapp

import kotlinx.coroutines.flow.Flow

class Repo(val dao: DeviceDAO) {

    fun getDevicesByMac(mac: String): Flow<List<DeviceEntity>> {
        return dao.getDeviceByMac(mac)
    }

    fun getAllDevices(): Flow<List<DeviceEntity>>{
        return dao.getDevices()
    }
}