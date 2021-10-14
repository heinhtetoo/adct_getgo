package com.heinhtetoo.getgo.model

data class CarFound(
    val id: Int,
    val model: String,
    val plateNumber: String,
    val type: String,
    val distance: String,
    val rentalFee: String,
    val mileageFee: String
)