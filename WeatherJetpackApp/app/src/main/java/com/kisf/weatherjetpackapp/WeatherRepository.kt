package com.kisf.weatherjetpackapp

import android.os.Build
import androidx.annotation.RequiresApi
import com.kisf.weatherjetpackapp.models.ForecastResponseBody
import com.kisf.weatherjetpackapp.models.Response
import com.kisf.weatherjetpackapp.models.WeatherInfo
import com.kisf.weatherjetpackapp.models.toWeatherInfo
import com.kisf.weatherjetpackapp.remote.InterfaceRemote
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api : InterfaceRemote
) : InterfaceWeatherRepository {


    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherForecastData(
        apikey: String,
        cityName: String
    ): Response<WeatherInfo> {
        return try {
            Response.Success(
                data = api.getWeatherForecast(apikey, cityName).toWeatherInfo()
            )
        } catch (e: java.lang.Exception) {
            e.stackTrace
            Response.Error(e.message)
        }
    }
}