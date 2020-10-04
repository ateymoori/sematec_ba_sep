package com.sematec.basic.entities

data class PixabayEntity(
    val hits: List<HitsEntity>,
    val total: Int,
    val totalHits: Int
)