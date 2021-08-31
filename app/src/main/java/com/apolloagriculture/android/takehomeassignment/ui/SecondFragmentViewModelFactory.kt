package com.apolloagriculture.android.takehomeassignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apolloagriculture.android.takehomeassignment.repository.LocationWeatherInfoRepositoryImpl
import kotlinx.coroutines.Dispatchers

class SecondFragmentViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelo: Class<T>): T {
        return SecondFragmentViewModel(
            Dispatchers.Main,
            LocationWeatherInfoRepositoryImpl()
        ) as T
    }
}
