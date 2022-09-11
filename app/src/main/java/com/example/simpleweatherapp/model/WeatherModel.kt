package com.example.simpleweatherapp.model
// this class represent the data retrieved from the api, so a model
class WeatherModel{
    var main: String = ""
    var description: String = ""
    var temp: Double = 0.0
    var feel: Double = 0.0
    var min: Double = 0.0
    var max: Double = 0.0
    var pressure: Int = 0
    var humidity: Int = 0
    var name: String = ""

//    override fun toString(): String {
//        return "Today weather condition in: $name\n Actual Temp= $temp\n Feel Like= $feel\n Temp Min=$min\n Temp Max= $max\n Pressure= $pressure\n Humidity= $humidity\n"
//    }


}