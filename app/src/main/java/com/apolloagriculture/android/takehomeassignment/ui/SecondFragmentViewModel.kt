package com.apolloagriculture.android.takehomeassignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apolloagriculture.android.takehomeassignment.R
import com.apolloagriculture.android.takehomeassignment.core.BaseViewModel
import com.apolloagriculture.android.takehomeassignment.core.Event
import com.apolloagriculture.android.takehomeassignment.network.ResultData
import com.apolloagriculture.android.takehomeassignment.repository.LocationWeatherInfoRepository
import com.apolloagriculture.android.takehomeassignment.repository.LocationWeatherInfoRepositoryImpl
import com.apolloagriculture.android.takehomeassignment.repository.data.LocationWeatherInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SecondFragmentViewModel(
    override val coroutineContext: CoroutineContext,
    private val repository: LocationWeatherInfoRepository = LocationWeatherInfoRepositoryImpl()
) : BaseViewModel(), CoroutineScope {

    private var _localWeatherInfo = MutableLiveData<Event<LocationWeatherInfo>>()
    var localWeatherInfo: LiveData<Event<LocationWeatherInfo>> =
        _localWeatherInfo


//    fun navigateForward() {
//        val action = MachinePairingFragmentDirections
//            .actionMachinePairingFragmentToCoffeeStyleFragment(
//                coffeeSelectionModel.value!!
//            )
//        _navigation.value = Event(NavigationCommand.To(action))
//    }

    fun getLocalWeatherInfo() {
        _loading.value = Event(true)
        this.requestLocalWeatherInfo()
    }

    private fun requestLocalWeatherInfo() = launch {
        when (val result = repository.getLocationWeatherInfo()) {

            is ResultData.Success -> {
                _loading.value = Event(false)
                if (result.data != null) {
                    _localWeatherInfo.value = Event(result.data!!)
                } else {
                    _snackbarError.value = Event(R.string.snackbar_could_not_fetch)
                }
            }
            is ResultData.Error -> {
                _loading.value = Event(false)
                if (result.isNetworkError()) {
                    _snackbarError.value = Event(R.string.snackbar_network_error)
                } else {
                    _snackbarError.value = Event(R.string.snackbar_error)
                }
            }
        }
    }
}
