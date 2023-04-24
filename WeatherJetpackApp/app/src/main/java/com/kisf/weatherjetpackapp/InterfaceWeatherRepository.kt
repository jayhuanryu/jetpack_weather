package com.kisf.weatherjetpackapp

import com.kisf.weatherjetpackapp.models.Response
import com.kisf.weatherjetpackapp.models.WeatherInfo

interface InterfaceWeatherRepository {

    suspend fun getWeatherForecastData(apikey: String, cityName : String) : Response<WeatherInfo>

}