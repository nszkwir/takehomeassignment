package com.apolloagriculture.android.takehomeassignment.repository

import com.apolloagriculture.android.takehomeassignment.network.ApiClient
import com.apolloagriculture.android.takehomeassignment.network.ResultData
import com.apolloagriculture.android.takehomeassignment.network.safeCall
import com.apolloagriculture.android.takehomeassignment.repository.data.LocationWeatherInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationWeatherInfoRepositoryImpl constructor(
    private val service: LocationWeatherInfoService = ApiClient()
        .createService(LocationWeatherInfoService::class.java),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : LocationWeatherInfoRepository {

    override suspend fun getLocationWeatherInfo(): ResultData<LocationWeatherInfo?> {
        return withContext(dispatcher) {
            return@withContext safeCall {
                service.getLocationWeatherInfo()
            }
        }
    }
}
