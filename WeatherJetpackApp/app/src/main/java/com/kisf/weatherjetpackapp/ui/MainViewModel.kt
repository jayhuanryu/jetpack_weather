package com.kisf.weatherjetpackapp.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kisf.weatherjetpackapp.InterfaceWeatherRepository
import com.kisf.weatherjetpackapp.models.Response
import com.kisf.weatherjetpackapp.models.WeatherInfo
import com.kisf.weatherjetpackapp.models.WeatherMappedData
import com.kisf.weatherjetpackapp.models.WeatherType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: InterfaceWeatherRepository
) : ViewModel() {

    val TAG = javaClass.simpleName

    /** Fake State and Fake Repository **/

    var state by mutableStateOf(WeatherState())
        private set

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadWeatherInfo() {
        state = state.copy(
            isLoading = true,
            weatherInfo = WeatherInfo(
                weatherDataPerDay = getWeateherDataPerDay(),
                currentWeatherData = getWeatherMappedData()
            )

        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeateherDataPerDay() : Map<Int, List<WeatherMappedData>>{
        val tempMappedWeatherList = listOf(
            WeatherMappedData(LocalDateTime.parse("2023-04-25T01:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1003)),
            WeatherMappedData(LocalDateTime.parse("2023-04-25T02:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1006)),
            WeatherMappedData(LocalDateTime.parse("2023-04-25T03:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1009)),
            WeatherMappedData(LocalDateTime.parse("2023-04-25T04:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1072)),
            WeatherMappedData(LocalDateTime.parse("2023-04-25T05:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1066)),
            WeatherMappedData(LocalDateTime.parse("2023-04-25T06:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1135)),
            WeatherMappedData(LocalDateTime.parse("2023-04-25T07:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1195)),
            WeatherMappedData(LocalDateTime.parse("2023-04-25T08:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1219)),
            WeatherMappedData(LocalDateTime.parse("2023-04-25T09:00"), 11.0, 0.0,0.0,0.0, WeatherType.fromWMO(1276)),

        )
        val map = mutableMapOf<Int, List<WeatherMappedData>>()
        map[0] = tempMappedWeatherList
        return map
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getWeatherMappedData() : WeatherMappedData {
        return WeatherMappedData(
            time = LocalDateTime.now(),
            temperatureCelsius = 16.0,
            pressure = 1060.9,
            windSpeed = 5.2,
            humidity = 23.4,
            weatherType = WeatherType.fromWMO(1003)
        )
    }


    /**
    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo() {
        Log.d(TAG, "[loadWeatherInfo] >>")
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            val result = repository.getWeatherForecastData("c1422402fb174072af801931232204","Tokyo")
            Log.d(TAG, "[loadWeatherInfo] >>> result : ${result.message}")
            when (result) {
                is Response.Success -> {
                    Log.d(TAG, "[loadWeatherInfo] >> Response.Success")
                    state = state.copy(
                        weatherInfo = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Response.Error -> {
                    Log.d(TAG, "[loadWeatherInfo] >> Response.Error")
                    state = state.copy(
                        weatherInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }


        }
    }

    **/
}