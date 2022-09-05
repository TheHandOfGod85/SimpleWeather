package com.example.simpleweatherapp.model


import com.google.gson.annotations.SerializedName

// new gfgf
data class ForecastDTO (

    @SerializedName("cod"     ) var cod     : String?         = null,
    @SerializedName("message" ) var message : Int?            = null,
    @SerializedName("cnt"     ) var cnt     : Int?            = null,
    @SerializedName("list"    ) var list    : ArrayList<List> = arrayListOf(),
    @SerializedName("city"    ) var city    : City?           = City()

)
annotation class JsonClass1(val generateAdapter: Boolean)


data class MainForecast (

    @SerializedName("temp"       ) var temp      : Double? = null,
    @SerializedName("feels_like" ) var feelsLike : Double? = null,
    @SerializedName("temp_min"   ) var tempMin   : Double? = null,
    @SerializedName("temp_max"   ) var tempMax   : Double? = null,
    @SerializedName("pressure"   ) var pressure  : Int?    = null,
    @SerializedName("sea_level"  ) var seaLevel  : Int?    = null,
    @SerializedName("grnd_level" ) var grndLevel : Int?    = null,
    @SerializedName("humidity"   ) var humidity  : Int?    = null,
    @SerializedName("temp_kf"    ) var tempKf    : Double? = null

)

data class WeatherForecast (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("main"        ) var main        : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("icon"        ) var icon        : String? = null

)

data class CloudsForecast (

    @SerializedName("all" ) var all : Int? = null

)

data class WindForecast (

    @SerializedName("speed" ) var speed : Double? = null,
    @SerializedName("deg"   ) var deg   : Int?    = null,
    @SerializedName("gust"  ) var gust  : Double? = null

)

data class SysForecast (

    @SerializedName("pod" ) var pod : String? = null

)

data class List (

    @SerializedName("dt"         ) var dt         : Int?               = null,
    @SerializedName("main"       ) var main       : MainForecast?              = MainForecast(),
    @SerializedName("weatherForecast"    ) var weather    : ArrayList<WeatherForecast> = arrayListOf(),
    @SerializedName("clouds"     ) var clouds     : CloudsForecast?            = CloudsForecast(),
    @SerializedName("wind"       ) var wind       : WindForecast?              = WindForecast(),
    @SerializedName("visibility" ) var visibility : Int?               = null,
    @SerializedName("pop"        ) var pop        : Int?               = null,
    @SerializedName("sys"        ) var sys        : SysForecast?               = SysForecast(),
    @SerializedName("dt_txt"     ) var dtTxt      : String?            = null

)

data class CoordForecast (

    @SerializedName("lat" ) var lat : Double? = null,
    @SerializedName("lon" ) var lon : Double? = null

)

data class City (

    @SerializedName("id"         ) var id         : Int?    = null,
    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("coord"      ) var coord      : CoordForecast?  = CoordForecast(),
    @SerializedName("country"    ) var country    : String? = null,
    @SerializedName("population" ) var population : Int?    = null,
    @SerializedName("timezone"   ) var timezone   : Int?    = null,
    @SerializedName("sunrise"    ) var sunrise    : Int?    = null,
    @SerializedName("sunset"     ) var sunset     : Int?    = null

)

fun ForecastDTO.toModel(): ForecastModel{
    var newForecast = ForecastModel()
    val city = City()

    city.name?.let {
        newForecast.name = it
    }

    if (list.isNotEmpty())
    list.forEach {
        newForecast.date = it.dtTxt.toString()
        newForecast.main = it.main?.temp.toString()
        newForecast.feel = it.main?.feelsLike!!
        newForecast.temp = it.main?.temp!!
        newForecast.min = it.main?.tempMin!!
        newForecast.max = it.main?.tempMax!!
    }
    return newForecast
}

