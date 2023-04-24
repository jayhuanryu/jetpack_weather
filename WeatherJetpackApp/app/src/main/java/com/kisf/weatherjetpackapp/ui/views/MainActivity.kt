package com.kisf.weatherjetpackapp.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kisf.weatherjetpackapp.WeatherCard
import com.kisf.weatherjetpackapp.ui.MainViewModel
import com.kisf.weatherjetpackapp.ui.theme.DarkBlue
import com.kisf.weatherjetpackapp.ui.theme.DeepBlue
import com.kisf.weatherjetpackapp.ui.theme.WeatherJetpackAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadWeatherInfo()

        setContent {
            WeatherJetpackAppTheme {
                Box (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(DarkBlue)
                    ) {
                        WeatherCard(state = viewModel.state, backgroundColor = DeepBlue)

                        Spacer(modifier = Modifier.height(20.dp))

                        WeatherForecast(state = viewModel.state)

                    }
                }

            }
        }
    }
}

