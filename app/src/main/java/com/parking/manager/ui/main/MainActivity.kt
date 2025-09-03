package com.parking.manager.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.parking.manager.databinding.ActivityMainBinding
import com.parking.manager.model.Vehicle
import com.parking.manager.ui.add.AddVehicleActivity
import com.parking.manager.ui.main.adapter.VehicleAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val vehicleAdapter = VehicleAdapter()

    private val addVehicleLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.getParcelableExtra<Vehicle>(AddVehicleActivity.EXTRA_NEW_VEHICLE)?.let { newVehicle ->
                viewModel.addVehicle(newVehicle)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setupRecyclerView()
        setupFab()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewVehicles.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = vehicleAdapter
        }
    }

    private fun setupFab() {
        binding.fabAddVehicle.setOnClickListener {
            val intent = Intent(this, AddVehicleActivity::class.java)
            addVehicleLauncher.launch(intent)
        }
    }

    private fun observeViewModel() {
        viewModel.vehicles.observe(this) { vehicles ->
            vehicleAdapter.submitList(vehicles)
        }
    }
}
