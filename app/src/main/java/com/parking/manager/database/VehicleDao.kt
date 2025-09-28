package com.parking.manager.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.parking.manager.model.Vehicle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vehicle: Vehicle)

    @Query("SELECT * FROM vehicles ORDER BY entryTime DESC")
    fun getAllVehicles(): Flow<List<Vehicle>>
}