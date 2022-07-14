package ru.barinov.studyapp

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class ActivityViewModel(private val repo: Repo): ViewModel() {

    val devicesFlow = repo.getAllDevices()
        .flowOn(Dispatchers.IO)
        .stateIn(viewModelScope, SharingStarted.Eagerly, listOf())

}