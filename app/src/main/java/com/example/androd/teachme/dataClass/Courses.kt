package com.example.androd.teachme

import android.os.Parcelable
import android.widget.ImageView
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Courses(
    val title : String,
    val subTitle : String,
    val adapterImage : Int):Parcelable