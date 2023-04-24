package com.kisf.weatherjetpackapp.models

data class WeatherInfo (
    val weatherDataPerDay : Map<Int, List<WeatherMappedData>>,
    val currentWeatherData : WeatherMappedData?
        )