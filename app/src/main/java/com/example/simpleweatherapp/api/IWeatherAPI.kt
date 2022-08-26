package com.example.simpleweatherapp.api

import com.example.simpleweatherapp.model.WeatherDTO
import com.example.simpleweatherapp.model.WeatherModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IWeatherAPI {
    @GET("weather?appid=d6bfb53bd9ca4a082bd1cd1d942405d3&units=metric")
    fun getWeatherByCity(@Query("q") cityName: String): Deferred<Response<WeatherDTO>>


}