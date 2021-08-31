package com.apolloagriculture.android.takehomeassignment.ui

import com.apolloagriculture.android.takehomeassignment.R

object WeatherIconHelper {

    fun getWeatherIcon(iconString: String): Int {
        return when (iconString) {
            "CLEAR_DAY" -> R.drawable.ic_weather_clear_day
            "CLEAR_NIGHT" -> R.drawable.ic_weather_clear_night
            "CLOUD_SUN" -> R.drawable.ic_weather_cloud_sun
            "DRIZZLE_SOME_RAIN" -> R.drawable.ic_weather_drizzle_some_rain
            "FOG" -> R.drawable.ic_weather_fog
            "ONE_CLOUD" -> R.drawable.ic_weather_one_cloud
            "RAIN" -> R.drawable.ic_weather_rain
            "SNOW" -> R.drawable.ic_weather_snow
            "SOME_CLOUDS" -> R.drawable.ic_weather_some_clouds
            "THUNDER" -> R.drawable.ic_weather_thunder

            "SCATTERED_CLOUDS_DAY" -> R.drawable.ic_weather_cloud_sun
            "BROKEN_OVERCAST_CLOUDS_DAY" -> R.drawable.ic_weather_one_cloud

            else -> R.drawable.ic_weather_clear_day
        }
    }
}

object WeatherTemperatureHelper {

    fun getWeatherTemperature(low: Double, high: Double): String {
        val lowAsText = low.toString()
        val highAsText = high.toString()

        var lowDecimal = Integer.parseInt(lowAsText.split(".")[0])
        val lowFraction = Integer.parseInt(lowAsText.split(".")[1].first().toString())

        var highDecimal = Integer.parseInt(highAsText.split(".")[0])
        val highFraction = Integer.parseInt(highAsText.split(".")[1].first().toString())

        if (lowFraction > 5) lowDecimal++
        if (highFraction > 5) highDecimal++

        return "$lowDecimal - $highDecimal C"
    }
}