package com.parking.manager.repository

import com.parking.manager.database.VehicleDao
import com.parking.manager.model.Vehicle
import kotlinx.coroutines.flow.Flow

class VehicleRepository(private val vehicleDao: VehicleDao) {

    val allVehicles: Flow<List<Vehicle>> = vehicleDao.getAllVehicles()

    suspend fun insert(vehicle: Vehicle) {
        vehicleDao.insert(vehicle)
    }
}