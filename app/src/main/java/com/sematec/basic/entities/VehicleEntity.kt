package com.sematec.basic.entities

data class VehicleEntity(
    val color: String,
    val color_rgb: String,
    val created_at: String,
    val default_vehicle: Boolean,
    val deleted_at: String,
    val id: Int,
    val model: String,
    val plate_number: String,
    val state: String,
    val updated_at: String,
    val user_owner: String
)