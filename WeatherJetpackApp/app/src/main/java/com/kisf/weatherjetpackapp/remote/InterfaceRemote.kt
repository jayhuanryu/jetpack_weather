package com.kisf.weatherjetpackapp.remote

import com.kisf.weatherjetpackapp.models.ForecastResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceRemote {

    @GET("forecast.json")
    suspend fun getWeatherForecast(
        @Query("key") apiKey : String,
        @Query("q") cityName : String
    ) : ForecastResponseBody
}