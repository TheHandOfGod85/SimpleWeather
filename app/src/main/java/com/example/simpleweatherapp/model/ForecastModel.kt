package com.example.simpleweatherapp.model

class ForecastModel {
    var list: ArrayList<ListForecastModel?> = arrayListOf()
}

data class ListForecastModel(
    var date: String? = null,
    var tempFelt: Double? = null,
    var temp: Double? = null,
    var tempMin: Double? = null,
    var tempMax: Double? = null,
    var description: String? = null

)