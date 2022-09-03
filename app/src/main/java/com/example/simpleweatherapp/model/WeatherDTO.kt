package com.example.simpleweatherapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import java.util.*
import kotlin.collections.ArrayList

data class WeatherDTO (
    @SerializedName("coord"      ) var coord      : Coord?             = Coord(),
    @SerializedName("weather"    ) var weather    : ArrayList<Weather> = arrayListOf(),
    @SerializedName("base"       ) var base       : String?            = null,
    @SerializedName("main"       ) var main       : Main?              = Main(),
    @SerializedName("visibility" ) var visibility : Int?               = null,
    @SerializedName("wind"       ) var wind       : Wind?              = Wind(),
    @SerializedName("clouds"     ) var clouds     : Clouds?            = Clouds(),
    @SerializedName("dt"         ) var dt         : Int?               = null,
    @SerializedName("sys"        ) var sys        : Sys?               = Sys(),
    @SerializedName("timezone"   ) var timezone   : Int?               = null,
    @SerializedName("id"         ) var id         : Int?               = null,
    @SerializedName("name"       ) var name       : String?            = null,
    @SerializedName("cod"        ) var cod        : Int?               = null
)

annotation class JsonClass(val generateAdapter: Boolean)

data class Coord (

    @SerializedName("lon" ) var lon : Double? = null,
    @SerializedName("lat" ) var lat : Double? = null

)

data class Weather (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("main"        ) var main        : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("icon"        ) var icon        : String? = null

)

data class Main (

    @SerializedName("temp"       ) var temp      : Double? = null,
    @SerializedName("feels_like" ) var feelsLike : Double? = null,
    @SerializedName("temp_min"   ) var tempMin   : Double? = null,
    @SerializedName("temp_max"   ) var tempMax   : Double? = null,
    @SerializedName("pressure"   ) var pressure  : Int?    = null,
    @SerializedName("humidity"   ) var humidity  : Int?    = null

)

data class Wind (

    @SerializedName("speed" ) var speed : Double? = null,
    @SerializedName("deg"   ) var deg   : Int?    = null

)

data class Clouds (

    @SerializedName("all" ) var all : Int? = null

)

data class Sys (

    @SerializedName("type"    ) var type    : Int?    = null,
    @SerializedName("id"      ) var id      : Int?    = null,
    @SerializedName("message" ) var message : Double? = null,
    @SerializedName("country" ) var country : String? = null,
    @SerializedName("sunrise" ) var sunrise : Int?    = null,
    @SerializedName("sunset"  ) var sunset  : Int?    = null

)

// Extension method
// converts objects WeatherDTO in WeatherModel
fun WeatherDTO.toModel(): WeatherModel {

    // default result
    var newWeather = WeatherModel()

    this.name?.let {
        newWeather.name = it.uppercase()
    }

    if (weather.isNotEmpty()) {
        var arrayWeather = this.weather[0]
        arrayWeather.description?.let {
            newWeather.description = it.uppercase()
        }
    }



    this.main?.let {
        newWeather.temp = it.temp!!
        newWeather.max = it.tempMax!!
        newWeather.min = it.tempMin!!
        newWeather.feel = it.feelsLike!!
        newWeather.humidity = it.humidity!!
        newWeather.pressure = it.pressure!!
    }

    return newWeather
}

