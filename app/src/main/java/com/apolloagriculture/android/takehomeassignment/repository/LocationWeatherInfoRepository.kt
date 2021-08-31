package com.apolloagriculture.android.takehomeassignment.repository

import com.apolloagriculture.android.takehomeassignment.network.ResultData
import com.apolloagriculture.android.takehomeassignment.repository.data.LocationWeatherInfo

interface LocationWeatherInfoRepository {
    suspend fun getLocationWeatherInfo(): ResultData<LocationWeatherInfo?>
}
