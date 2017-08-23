package com.pablo384.kolorweather.API

import com.pablo384.kolorweather.models.CurrentWeather
import org.json.JSONObject

/**
 * Created by pablo384 on 23/08/17.
 */
class JSONParser {
    fun getCurrentWeatherJSON(response:JSONObject):CurrentWeather{
        val currentJSON = response.getJSONObject(CURRENTLY)
        with(currentJSON){
            return CurrentWeather(
                    getString(ICON),
                    getString(SUMMARY),
                    getDouble(TEMPERATURE),
                    getDouble(PRECIPPROBABILITY)
            )
        }
    }
}