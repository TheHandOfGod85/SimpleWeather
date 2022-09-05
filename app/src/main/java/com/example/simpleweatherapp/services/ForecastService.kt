package com.example.simpleweatherapp.services

import com.example.simpleweatherapp.api.IForecastAPI
import com.example.simpleweatherapp.api.IWeatherAPI
import com.example.simpleweatherapp.model.ForecastDTO
import com.example.simpleweatherapp.model.ForecastModel
import com.example.simpleweatherapp.model.toForecast
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ForecastService() {
    private val forecastAPI: IForecastAPI

    init {
        forecastAPI = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(IForecastAPI::class.java)

    }

    suspend fun getForecastByCityName(cityName: String): ForecastModel{
        var result = ForecastModel()
        try {
            val response: Response<ForecastDTO> = forecastAPI.getForecastByCity(cityName).await()
            if (response.isSuccessful) {
                // API response code 200
                response.body()?.let { data ->
                    return data.toForecast()
                }
            }
        } catch (ex: Exception) {
            // manage error
            val error = ex.message
            val x = 1

        }

        return result
    }


}