package com.parking.manager.ui.main

import androidx.lifecycle.*
import com.parking.manager.model.Vehicle
import com.parking.manager.repository.VehicleRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: VehicleRepository) : ViewModel() {

    val vehicles: LiveData<List<Vehicle>> = repository.allVehicles.asLiveData()

    fun addVehicle(vehicle: Vehicle) {
        viewModelScope.launch {
            repository.insert(vehicle)
        }
    }
}

class MainViewModelFactory(private val repository: VehicleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
