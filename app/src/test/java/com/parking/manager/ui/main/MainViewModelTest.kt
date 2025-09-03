package com.parking.manager.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.parking.manager.model.Vehicle
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `addVehicle should add new vehicle to the top of the list`() {
        // Arrange
        val viewModel = MainViewModel()
        val initialList = viewModel.vehicles.value ?: emptyList()
        val newVehicle = Vehicle("NEW-0000", "Test Car", System.currentTimeMillis())

        // Act
        viewModel.addVehicle(newVehicle)
        val updatedList = viewModel.vehicles.value

        // Assert
        assertEquals(initialList.size + 1, updatedList?.size)
        assertEquals(newVehicle, updatedList?.first())
    }
}
