package com.kisf.weatherjetpackapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kisf.weatherjetpackapp.ui.WeatherState
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${
                        data.time.format(
                            DateTimeFormatter.ofPattern("HH:mm")
                        )
                    }",
                    modifier = Modifier.align(Alignment.End),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = "Weather Type Image",
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = Color.White
                )
                
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    DisplayCurrentDetailData(
                        text = data.pressure.toString()+"hpa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_air_pressure))

                    DisplayCurrentDetailData(
                        text = data.humidity.toString()+"%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_humidity))

                    DisplayCurrentDetailData(
                        text = data.windSpeed.toString()+"kph",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind_speed))

                }

            }
        }
    }

}

@Composable
fun DisplayCurrentDetailData(
    text: String,
    icon : ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    iconTine: Color = Color.White
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Current Detail Data Icon",
            tint = iconTine,
            modifier = modifier.size(25.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text  = text,
            style = textStyle,
            color = Color.White
        )
    }
}
