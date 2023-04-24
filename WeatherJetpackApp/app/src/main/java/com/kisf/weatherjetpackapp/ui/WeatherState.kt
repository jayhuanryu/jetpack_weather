package com.kisf.weatherjetpackapp.ui

import com.kisf.weatherjetpackapp.models.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo?= null,
    val isLoading : Boolean = true,
    val error: String? = null
)
