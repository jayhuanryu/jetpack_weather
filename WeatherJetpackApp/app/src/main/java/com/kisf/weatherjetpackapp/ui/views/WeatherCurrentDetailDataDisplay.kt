package com.kisf.weatherjetpackapp.ui.views

import android.icu.lang.UCharacter
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kisf.weatherjetpackapp.models.WeatherMappedData
import com.kisf.weatherjetpackapp.ui.WeatherState

@Composable
fun WeatherForecast(
    state : WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Today",
                fontSize = 20.sp,
                color = Color.White
            )

            Spacer(modifier = modifier.height(20.dp))

            LazyRow(content = {
                items(data) {
                    HourlyDisplay(weatherData = it)
                }
            })
        }

    }
}

@Composable
fun HourlyDisplay(
    weatherData: WeatherMappedData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    Column (
        modifier = modifier.height(150.dp).width(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = weatherData.weatherType.weatherDesc,
            color = Color.LightGray,
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = "Forecast Icon",
            modifier = modifier.width(40.dp)
        )

        Text(
            text = "${weatherData.temperatureCelsius}C",
            color = textColor,
            fontWeight = FontWeight.Bold
        )

    }
}
