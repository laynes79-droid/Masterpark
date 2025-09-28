package com.parking.manager

import android.app.Application
import com.parking.manager.database.AppDatabase
import com.parking.manager.repository.VehicleRepository

class ParkingManagerApplication : Application() {

    // Using by lazy so the database and repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { VehicleRepository(database.vehicleDao()) }
}