package com.kisf.weatherjetpackapp.models

import com.squareup.moshi.Json
import java.time.LocalDateTime

data class ForecastResponseBody(
    @field:Json(name="forecast") val forecast : ForecastData,
    @field:Json(name="current") val current : CurrentData,
    @field:Json(name="location") val location : LocationData

)

data class WeatherMappedData(
    val time : LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType : WeatherType

)
data class WeatherRawData(
    @field:Json(name="time")         val time : LocalDateTime,
    @field:Json(name="temp_c")       val temperatureCelsius: Double,
    @field:Json(name="pressure_mb")  val pressure: Double,
    @field:Json(name="wind_kph")     val windSpeed: Double,
    @field:Json(name ="humidity")    val humidity: Double,
    @field:Json(name="condition")    val weatherCondition: WeatherCondition
)
data class WeatherCondition(
    @field:Json(name="text") val text:String,
    @field:Json(name="icon") val icon:String,
    @field:Json(name="code") val code:Int
)

data class ForecastData(
    @field:Json(name="forecastday") val forecastday : List<ForecastDayData>

)

data class ForecastDayData(
    @field:Json(name="date")    val date : String,
    @field:Json(name="date_epoch") val date_epoch : Double,
    @field:Json(name="day")         val day : WeatherRawData,
    @field:Json(name="hour")        val hour : List<WeatherRawData>
)

data class IndexedWeatherData(
    val index : Int,
    val data : WeatherMappedData
)

data class LocationData (
    @field:Json(name="name")    val name: String? = null,
    @field:Json(name="region")  val region: String? = null,
    @field:Json(name="country") val country: String? = null,
    @field:Json(name="lat")     val lat : Double,
    @field:Json(name="lon")     val lon : Double,
    @field:Json(name="tz_id")   val tz_id: String? = null,
    @field:Json(name="localtime_epoch") val time : Double,
    @field:Json(name="localtime")   val localtime: String? = null
)

class Condition {
    var text: String? = null
    var icon: String? = null
    var code = 0
}

data class CurrentData (
    @field:Json(name="last_updated_epoch")    val last_updated_epoch : Double,
    @field:Json(name="last_updated")    val last_updated: String? = null,
    @field:Json(name="temp_c")    val temp_c : Double,
    @field:Json(name="temp_f")    val temp_f : Double,
    @field:Json(name="is_day")    val is_day : Int,
    @field:Json(name="condition")    val condition: WeatherCondition,
    @field:Json(name="wind_mph")    val wind_mph : Double,
    @field:Json(name="wind_kph")    val wind_kph : Double,
    @field:Json(name="wind_degree")    val wind_degree :String?,
    @field:Json(name="wind_dir")    val wind_dir: String?,
    @field:Json(name="pressure_mb")    val pressure_mb : Double,
    @field:Json(name="pressure_in")    val pressure_in : Double,
    @field:Json(name="precip_mm")    val precip_mm : Double,
    @field:Json(name="precip_in")    val precip_in : Double,
    @field:Json(name="humidity")    val humidity : Double,
    @field:Json(name="cloud")    val cloud : Int,
    @field:Json(name="feelslike_c")    val feelslike_c : Double,
    @field:Json(name="feelslike_f")    val feelslike_f : Double,
    @field:Json(name="vis_km")    val vis_km : Double,
    @field:Json(name="vis_miles")    val vis_miles : Double,
    @field:Json(name="uv")    val uv : Double,
    @field:Json(name="gust_mph")    val gust_mph : Double,
    @field:Json(name="gust_kph")    val gust_kph : Double,
)
