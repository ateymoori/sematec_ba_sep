package com.sematec.basic.entities

data class StudentModel(
    val studentName: String? = null,
    val studentMobile: String,
    val studentAddress: String,
    val married: Boolean = false
)