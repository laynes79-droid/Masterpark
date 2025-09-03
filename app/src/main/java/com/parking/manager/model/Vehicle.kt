package com.parking.manager.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vehicle(
    val plate: String,
    val model: String,
    val entryTime: Long
) : Parcelable
