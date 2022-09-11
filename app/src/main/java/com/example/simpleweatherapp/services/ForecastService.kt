package com.example.simpleweatherapp.services

import com.example.simpleweatherapp.api.IOpenWeatherAPI
import com.example.simpleweatherapp.model.ForecastDTO
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ForecastService() {
    private val forecastAPI: IOpenWeatherAPI

    init {
        forecastAPI = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(IOpenWeatherAPI::class.java)

    }

    suspend fun getForecastByCityName(cityName: String): ForecastDTO{
        var result = ForecastDTO()
        try {
            val response: Response<ForecastDTO> = forecastAPI.getForecastByCity(cityName).await()
            if (response.isSuccessful) {
                // API response code 200
                response.body()?.let { data ->
                    return data

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