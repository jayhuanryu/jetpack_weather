package com.kisf.weatherjetpackapp.models

import androidx.annotation.DrawableRes
import com.kisf.weatherjetpackapp.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes:Int
) {
    object ClearSky : WeatherType(
        weatherDesc = "Clear",
        iconRes = R.drawable._113
    )
    object PartlyCloudy : WeatherType(
        weatherDesc = "Partly cloudy",
        iconRes = R.drawable._116
    )
    object Cloudy : WeatherType(
        weatherDesc = "Cloudy",
        iconRes =  R.drawable._119
    )
    object Overcast : WeatherType(
        weatherDesc = "Overcast",
        iconRes = R.drawable._122
    )
    object Mist:WeatherType(
        weatherDesc = "Mist",
        iconRes = R.drawable._143
    )
    object PatchRainyPossible : WeatherType(
        weatherDesc = "Possible Rainy",
        iconRes = R.drawable._176
    )
    object PatchySnowyPossible : WeatherType(
        weatherDesc = "Possible Snowy",
        iconRes = R.drawable._179
    )
    object PatchySleetPossible : WeatherType(
        weatherDesc = "Possible Sleet",
        iconRes = R.drawable._182
    )
    object PatchyFreezingDrizzlePossible : WeatherType(
        weatherDesc = "Possible Freezing Drizzle",
        iconRes = R.drawable._185
    )
    object ThunderOutbreakPossible : WeatherType(
        weatherDesc = "Possible Thunder",
        iconRes = R.drawable._200
    )
    object BlowingSnow : WeatherType(
        weatherDesc = "Snow Blowing",
        iconRes = R.drawable._227
    )
    object Blizzard : WeatherType(
        weatherDesc = "Blizzard",
        iconRes = R.drawable._230
    )
    object Fog : WeatherType(
        weatherDesc = "Fog",
        iconRes = R.drawable._248
    )
    object FreezingFog : WeatherType(
        weatherDesc = "Freezing Fog",
        iconRes = R.drawable._260
    )

    object PatchLightDrizzle : WeatherType(
        weatherDesc = "Patchy Light Drizzle",
        iconRes = R.drawable._263
    )
    object LightDrizzle : WeatherType(
        weatherDesc = "Light Drizzle",
        iconRes = R.drawable._266
    )
    object FreezingDrizzle : WeatherType(
        weatherDesc = "Freezing Drizzle",
        iconRes = R.drawable._281
    )
    object HeavyFreezingDrizzle : WeatherType(
        weatherDesc = "Heavy Freezing Drizzle",
        iconRes = R.drawable._284
    )
    object PatchyLightRain : WeatherType(
        weatherDesc = "Patch Light Rain",
        iconRes = R.drawable._293
    )
    object LightRain : WeatherType(
        weatherDesc = "Light Rain",
        iconRes = R.drawable._296
    )
    object ModerateRainAtTimes : WeatherType(
        weatherDesc = "Moderate Rain At Times",
        iconRes = R.drawable._299
    )
    object ModerateRain : WeatherType(
        weatherDesc = "Moderate Rain",
        iconRes = R.drawable._302
    )
    object HeavyRainAtTimes : WeatherType(
        weatherDesc = "Heavy Rain At Times",
        iconRes = R.drawable._305
    )
    object HeavyRain : WeatherType(
        weatherDesc = "Heavy Rain",
        iconRes = R.drawable._308
    )
    object LightFreezingRain : WeatherType(
        weatherDesc = "Light Freezing Rain",
        iconRes = R.drawable._311
    )
    object ModerateOrHeavyFreezingRain : WeatherType(
        weatherDesc = "Moderate or Heavy Freezing Rain",
        iconRes = R.drawable._314
    )
    object LightSleet : WeatherType(
        weatherDesc = "Light Sleet",
        iconRes = R.drawable._317
    )
    object ModerateOrHeavySleet : WeatherType(
        weatherDesc = "Moderate Or Heavy Sleet",
        iconRes = R.drawable._320
    )
    object PatchyLightSnow : WeatherType(
        weatherDesc = "Patchy Light SNow",
        iconRes = R.drawable._323
    )
    object LightSnow : WeatherType(
        weatherDesc = "Light SNow",
        iconRes = R.drawable._326
    )
    object PatchyModerateSnow : WeatherType(
        weatherDesc = "Patch Moderate Snow",
        iconRes = R.drawable._329
    )
    object ModerateSnow : WeatherType(
        weatherDesc = "Moderate Snow",
        iconRes = R.drawable._332
    )
    object PatchHeavySnow : WeatherType(
        weatherDesc = "Patch Heavy Snow",
        iconRes = R.drawable._335
    )
    object HeavySnow : WeatherType(
        weatherDesc = "Heavy Snow",
        iconRes = R.drawable._338
    )
    object IcePellets : WeatherType(
        weatherDesc = "Ice Pellets",
        iconRes = R.drawable._350
    )
    object LightRainShower : WeatherType(
        weatherDesc = "Light Rain Shower",
        iconRes = R.drawable._353
    )
    object ModerateOrHeavyRainShower : WeatherType(
        weatherDesc = "Moderate Or Heavy Rain Shower",
        iconRes = R.drawable._356
    )
    object TorrentialRainShower : WeatherType(
        weatherDesc = "Torrential Rain Shower",
        iconRes = R.drawable._359
    )
    object LightSleetShowers : WeatherType(
        weatherDesc = "Light Sleet Showers",
        iconRes = R.drawable._362
    )
    object ModerateOrHeavySleetShowers : WeatherType(
        weatherDesc = "Moderate Or Heavy Sleet Showers",
        iconRes = R.drawable._365
    )
    object LightSnowShower : WeatherType(
        weatherDesc = "Light Snow Showers",
        iconRes = R.drawable._368
    )

    object ModerateOrHeavySnowShowers : WeatherType(
        weatherDesc = "Moderate or Heavy Snow Showers",
        iconRes = R.drawable._371
    )
    object LightShowerIcePellets : WeatherType(
        weatherDesc = "Light Showers of Ice Pellets",
        iconRes = R.drawable._374
    )
    object ModerateOrHeavyShowerIce : WeatherType(
        weatherDesc = "Moderate Or Heavy SHowers of Ice",
        iconRes = R.drawable._377
    )
    object PatchyLightRainThunder : WeatherType(
        weatherDesc = "Patch Light Rain With Thunder",
        iconRes = R.drawable._386
    )

    object ModerateOrHeavyRainThunder : WeatherType(
        weatherDesc = "Moderate Or Heavy Rain With Thunder",
        iconRes = R.drawable._389
    )

    object PatchyLightSnowThunder : WeatherType(
        weatherDesc = "Patchy Light Snow With Thunder",
        iconRes = R.drawable._392
    )

    object ModerateOrHeavySnowThunder : WeatherType(
        weatherDesc = "Moderate or Heavy Snow With Thunder",
        iconRes = R.drawable._395
    )

    companion object {
        fun fromWMO(code:Int) : WeatherType {
            return when(code) {
                1000 -> ClearSky
                1003 -> PartlyCloudy
                1006 -> Cloudy
                1009 -> Overcast
                1030 -> Mist
                1063 -> PatchRainyPossible
                1066 -> PatchySnowyPossible
                1069 -> PatchySleetPossible
                1072 -> PatchyFreezingDrizzlePossible
                1087 -> ThunderOutbreakPossible
                1114 -> BlowingSnow
                1117 -> Blizzard
                1135 -> Fog
                1147 -> FreezingFog
                1150 -> PatchLightDrizzle
                1153 -> LightDrizzle
                1168 -> FreezingDrizzle
                1171 -> HeavyFreezingDrizzle
                1180 -> PatchyLightRain
                1183 -> LightRain
                1186 -> ModerateRainAtTimes
                1189 -> ModerateRain
                1192 -> HeavyRainAtTimes
                1195 -> HeavyRain
                1198 -> LightFreezingRain
                1201 -> ModerateOrHeavyFreezingRain
                1204 -> LightSleet
                1207 -> ModerateOrHeavySleet
                1210 -> PatchyLightSnow
                1213 -> LightSnow
                1216 -> PatchyModerateSnow
                1219 -> ModerateSnow
                1222 -> PatchHeavySnow
                1225 -> HeavySnow
                1237 -> IcePellets
                1240 -> LightRainShower
                1243 -> ModerateOrHeavyRainShower
                1246 -> TorrentialRainShower
                1249 -> LightSleetShowers
                1252 -> ModerateOrHeavySleetShowers
                1255 -> LightSnowShower
                1258 -> ModerateOrHeavySnowShowers
                1261 -> LightShowerIcePellets
                1264 -> ModerateOrHeavyShowerIce
                1273 -> PatchyLightRainThunder
                1276 -> ModerateOrHeavyRainThunder
                1279 -> PatchyLightSnowThunder
                1282 -> ModerateOrHeavySnowThunder
                else -> ClearSky
            }

        }
    }
}
