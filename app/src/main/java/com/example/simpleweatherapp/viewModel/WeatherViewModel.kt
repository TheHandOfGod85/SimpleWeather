package com.example.simpleweatherapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleweatherapp.model.WeatherModel
import com.example.simpleweatherapp.services.WeatherService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel() : ViewModel() {
    private val weatherRepository = WeatherService()

    val cityName : MutableLiveData<String> = MutableLiveData("")
    val weatherResult : MutableLiveData<WeatherModel> = MutableLiveData(WeatherModel())

    fun getWeatherByCityName() {
        cityName.value?.let {
            CoroutineScope(Dispatchers.IO).launch {
                weatherResult.postValue(weatherRepository.getWeatherByCityName(it))
            }
        }
    }

}