package com.example.exploscreenshottesting.Models

import com.example.exploscreenshottesting.R

data class DeviceDataItem(val name: String, val osVersion: String, val releaseYear: String, val image: Int)

fun getDevices(): List<DeviceDataItem> {
    return listOf(
        DeviceDataItem("Iphone 15 Pro", "11", "2023", R.drawable.iphone_15_pro),
        DeviceDataItem("Samsung Galaxy", "11", "2021", R.drawable.samsung_galaxy)
    )
}