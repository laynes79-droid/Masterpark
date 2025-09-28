package com.parking.manager.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "vehicles")
data class Vehicle(
    @PrimaryKey
    val plate: String,
    val model: String,
    val entryTime: Long
) : Parcelable
