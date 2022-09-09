package com.example.simpleweatherapp.services

import com.example.simpleweatherapp.api.IOpenWeatherAPI
import com.example.simpleweatherapp.model.WeatherDTO
import com.example.simpleweatherapp.model.WeatherModel
import com.example.simpleweatherapp.model.toModel
import retrofit2.Retrofit
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class WeatherService() {


    private val weatherAPI: IOpenWeatherAPI

    init {
        weatherAPI = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(IOpenWeatherAPI::class.java)

    }

     // a function to retrieve the data from the api using retrofit request
    suspend fun getWeatherByCityName(cityName: String): WeatherModel{
        var result = WeatherModel()

         try {
             val response: Response<WeatherDTO> = weatherAPI.getWeatherByCity(cityName).await()
             if (response.isSuccessful) {
                 // API response code 200
                 response.body()?.let { data ->
                     return data.toModel()
                 }
             }
         } catch (ex: Exception) {
            // gestire l'errore
            val error = ex.message
            val x = 1

         }

         return result
    }
}