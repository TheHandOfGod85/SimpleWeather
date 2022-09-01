package com.example.simpleweatherapp.api

import com.example.simpleweatherapp.model.ForecastDTO
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IForecastAPI {

    @GET("forecast?appid=d6bfb53bd9ca4a082bd1cd1d942405d3&cnt=3&units=metric")
    fun getForecastByCity(@Query("q") cityName: String): Deferred<Response<ForecastDTO>>
}