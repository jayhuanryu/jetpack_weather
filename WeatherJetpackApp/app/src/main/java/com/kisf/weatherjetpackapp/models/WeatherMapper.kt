package com.kisf.weatherjetpackapp.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
fun ForecastData.toWeatherDataMap(): Map<Int, List<WeatherMappedData>> {
    return forecastday[0].hour.mapIndexed { index, it ->
        IndexedWeatherData(
            index = index,
            data = WeatherMappedData(
                time = LocalDateTime.parse(it.time.toString(), DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = it.temperatureCelsius,
                pressure = it.pressure,
                windSpeed = it.windSpeed,
                humidity = it.humidity,
                weatherType = WeatherType.fromWMO(it.weatherCondition.code)
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun ForecastResponseBody.toWeatherInfo() : WeatherInfo {
    val weatherDataMap = forecast.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30 ) now.hour else now.hour + 1
        it.time.hour ===hour
    }
    return WeatherInfo(weatherDataPerDay = weatherDataMap, currentWeatherData = currentWeatherData)
}