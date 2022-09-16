package com.example.simpleweatherapp.model


import com.google.gson.annotations.SerializedName

// new gfgf
annotation class JsonClass2(val generateAdapter: Boolean)

data class ForecastDTO (

    @SerializedName("cod"     ) var cod     : String?         = null,
    @SerializedName("message" ) var message : Int?            = null,
    @SerializedName("cnt"     ) var cnt     : Int?            = null,
    @SerializedName("list"    ) var listForecastDTO    : ArrayList<ListForecastDTO> = arrayListOf(),
    @SerializedName("city"    ) var cityForecastDTO    : CityForecastDTO?           = CityForecastDTO(),
    )



data class MainForecastDTO (

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

data class WeatherForecastDTO (

    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("main"        ) var main        : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("icon"        ) var icon        : String? = null

)

data class CloudsForecastDTO (

    @SerializedName("all" ) var all : Int? = null

)

data class WindForecastDTO (

    @SerializedName("speed" ) var speed : Double? = null,
    @SerializedName("deg"   ) var deg   : Int?    = null,
    @SerializedName("gust"  ) var gust  : Double? = null

)

data class SysForecastDTO (

    @SerializedName("pod" ) var pod : String? = null

)

data class RainForecastDTO(
    @SerializedName("3h") var h: Double? = null
)

data class ListForecastDTO (

    @SerializedName("dt"         ) var dt         : Int?               = null,
    @SerializedName("main"       ) var main       : MainForecastDTO?              = MainForecastDTO(),
    @SerializedName("weather"    ) var weather    : ArrayList<WeatherForecastDTO> = arrayListOf(),
    @SerializedName("clouds"     ) var clouds     : CloudsForecastDTO?            = CloudsForecastDTO(),
    @SerializedName("wind"       ) var wind       : WindForecastDTO?              = WindForecastDTO(),
    @SerializedName("visibility" ) var visibility : Int?               = null,
    @SerializedName("pop"        ) var pop        : Double?               = null,
    @SerializedName("sys"        ) var sys        : SysForecastDTO?               = SysForecastDTO(),
    @SerializedName("dt_txt"     ) var dtTxt      : String?            = null,
    @SerializedName("rain") var rainForecastDTO : RainForecastDTO? = RainForecastDTO()

)

data class CoordForecastDTO (

    @SerializedName("lat" ) var lat : Double? = null,
    @SerializedName("lon" ) var lon : Double? = null

)

data class CityForecastDTO (

    @SerializedName("id"         ) var id         : Int?    = null,
    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("coord"      ) var coord      : CoordForecastDTO?  = CoordForecastDTO(),
    @SerializedName("country"    ) var country    : String? = null,
    @SerializedName("population" ) var population : Int?    = null,
    @SerializedName("timezone"   ) var timezone   : Int?    = null,
    @SerializedName("sunrise"    ) var sunrise    : Int?    = null,
    @SerializedName("sunset"     ) var sunset     : Int?    = null

)

fun ForecastDTO.toModel(): ForecastModel{
    var newForecast = ForecastModel()

    listForecastDTO.forEach {
        newForecast.list.get(0)!!.temp = it.main?.temp!!
        newForecast.list.get(0)!!.tempFelt = it.main?.feelsLike!!
        newForecast.list.get(0)!!.tempMin = it.main?.tempMin!!
        newForecast.list.get(0)!!.tempMax = it.main?.tempMax!!
        newForecast.list.get(0)!!.description = it.weather.get(0)?.description!!
        newForecast.list.get(0)!!.date = it.dtTxt!!
    }



    return newForecast
}



