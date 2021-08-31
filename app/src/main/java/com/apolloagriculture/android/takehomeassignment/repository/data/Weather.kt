package com.apolloagriculture.android.takehomeassignment.repository.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    @SerializedName("lowTemp")
    var lowTemp: Double = 0.0,
    @SerializedName("highTemp")
    var highTemp: Double = 0.0,
    @SerializedName("icon")
    var icon: String = "",
    @SerializedName("description")
    var description: String = ""
) : Parcelable
