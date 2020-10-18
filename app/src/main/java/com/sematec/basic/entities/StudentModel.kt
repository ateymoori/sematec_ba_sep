package com.sematec.basic.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class StudentModel(
    val studentName: String? = null,
    val studentMobile: String,
    val studentAddress: String,
    val married: Boolean = false
):Parcelable