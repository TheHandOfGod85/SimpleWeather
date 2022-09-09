package com.example.simpleweatherapp.model

class ForecastModel {
    var main: String = ""
    var description: String = ""
    var temp: Double = 0.0
    var feel: Double = 0.0
    var min: Double = 0.0
    var max: Double = 0.0
    var pressure: Int = 0
    var humidity: Int = 0
    var name: String = ""
    var date: String = ""



    override fun toString(): String {
        return "$date\n" +
                "$name\n" +
                "$temp\n" +
                "$feel\n" +
                "$min\n" +
                "$max\n" +
                "$pressure\n" +
                "$humidity\n" +
                "$description"
    }


}
