package com.apolloagriculture.android.takehomeassignment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.apolloagriculture.android.takehomeassignment.core.BaseFragment
import com.apolloagriculture.android.takehomeassignment.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : BaseFragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SecondFragmentViewModel

    override fun obtainViewModel() = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            SecondFragmentViewModelFactory()
        ).get(SecondFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        defineObservables()
        viewModel.getLocalWeatherInfo()
        return binding.root
    }

    private fun defineObservables() {
        viewModel.localWeatherInfo.observe(viewLifecycleOwner, {
            it?.getContentIfNotHandled()?.let { localWeatherInfo ->

                with(localWeatherInfo.today) {
                    binding.iconToday.setImageResource(
                        WeatherIconHelper.getWeatherIcon(icon)
                    )
                    binding.temperatureToday.text = WeatherTemperatureHelper
                        .getWeatherTemperature(lowTemp, highTemp)
                    binding.resumeToday.text = description
                }

                with(localWeatherInfo.tomorrow) {
                    binding.iconTomorrow.setImageResource(
                        WeatherIconHelper.getWeatherIcon(icon)
                    )
                    binding.temperatureTomorrow.text = WeatherTemperatureHelper
                        .getWeatherTemperature(lowTemp, highTemp)
                    binding.resumeTomorrow.text = description
                }

                with(localWeatherInfo.dayAfterTomorrow) {
                    binding.iconDayAfterTomorrow.setImageResource(
                        WeatherIconHelper.getWeatherIcon(icon)
                    )
                    binding.temperatureDayAfterTomorrow.text = WeatherTemperatureHelper
                        .getWeatherTemperature(lowTemp, highTemp)
                    binding.resumeDayAfterTomorrow.text = description
                }

                binding.weatherCard.visibility = View.VISIBLE
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
