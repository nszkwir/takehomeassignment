package com.apolloagriculture.android.takehomeassignment.repository

import com.apolloagriculture.android.takehomeassignment.repository.data.LocationWeatherInfo
import retrofit2.Response
import retrofit2.http.GET

interface LocationWeatherInfoService {
    @GET("weather.json")
    suspend fun getLocationWeatherInfo(): Response<LocationWeatherInfo>
}
