package com.apolloagriculture.android.takehomeassignment.repository.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationWeatherInfo(
    @SerializedName("today")
    var today: Weather = Weather(),
    @SerializedName("tomorrow")
    var tomorrow: Weather = Weather(),
    @SerializedName("dayAfterTomorrow")
    var dayAfterTomorrow: Weather = Weather(),
) : Parcelable
