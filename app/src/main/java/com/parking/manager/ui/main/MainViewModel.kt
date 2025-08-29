package com.parking.manager.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.parking.manager.model.Vehicle
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {

    private val _vehicles = MutableLiveData<List<Vehicle>>()
    val vehicles: LiveData<List<Vehicle>> = _vehicles

    init {
        // Carregar dados iniciais para teste
        loadVehicles()
    }

    private fun loadVehicles() {
        // Dados de exemplo com placas no padrão antigo e Mercosul
        val currentTime = System.currentTimeMillis()
        val dummyVehicles = listOf(
            Vehicle("BRA2E19", "Honda Civic", currentTime - TimeUnit.HOURS.toMillis(1)), // Mercosul
            Vehicle("ABC-1234", "VW Fusca", currentTime - TimeUnit.HOURS.toMillis(2)),      // Antiga
            Vehicle("PAU1A23", "Fiat Argo", currentTime - TimeUnit.MINUTES.toMillis(15)) // Mercosul
        )
        _vehicles.value = dummyVehicles
    }
}
