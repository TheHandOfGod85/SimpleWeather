package com.example.simpleweatherapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleweatherapp.model.ForecastDTO
import com.example.simpleweatherapp.model.ForecastModel
import com.example.simpleweatherapp.services.ForecastService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForecastViewModel(): ViewModel() {
    private val forecastRepository = ForecastService()

    val cityName : MutableLiveData<String> = MutableLiveData("")
    val forecastResult : MutableLiveData<ForecastModel> = MutableLiveData(ForecastModel())


    fun getForecastByCityName(){
        cityName.value?.let {
            CoroutineScope(Dispatchers.IO).launch {
                forecastResult.postValue(forecastRepository.getForecastByCityName(it))
            }
        }

    }



}