package com.parking.manager.ui.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.parking.manager.databinding.ActivityAddVehicleBinding
import com.parking.manager.model.Vehicle

class AddVehicleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddVehicleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddVehicleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupSaveButton()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarAddVehicle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.toolbarAddVehicle.setNavigationOnClickListener {
            // Same as pressing the back button
            finish()
        }
    }

    private fun setupSaveButton() {
        binding.buttonSave.setOnClickListener {
            val plate = binding.editTextPlate.text.toString().trim()
            val model = binding.editTextModel.text.toString().trim()

            if (plate.isEmpty() || model.isEmpty()) {
                Toast.makeText(this, "Placa e modelo são obrigatórios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newVehicle = Vehicle(
                plate = plate.uppercase(),
                model = model,
                entryTime = System.currentTimeMillis()
            )

            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_NEW_VEHICLE, newVehicle)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    companion object {
        const val EXTRA_NEW_VEHICLE = "com.parking.manager.EXTRA_NEW_VEHICLE"
    }
}
