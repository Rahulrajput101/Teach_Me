package com.example.androd.teachme.dataClass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class words(
    val text: String,
    val cateogry: String,
    val meaning: String ): Parcelable