package com.pablo384.kolorweather.API

import com.pablo384.kolorweather.models.CurrentWeather
import com.pablo384.kolorweather.models.Day
import com.pablo384.kolorweather.Extensions.iterator
import com.pablo384.kolorweather.models.Hour
import org.json.JSONObject

/**
 * Created by pablo384 on 23/08/17.
 */

fun getCurrentWeatherJSON(response: JSONObject): CurrentWeather {
    with(response.getJSONObject(CURRENTLY)) {
        return CurrentWeather(
                getString(ICON),
                getString(SUMMARY),
                getDouble(TEMPERATURE),
                getDouble(PRECIPPROBABILITY)
        )
    }
}

fun getDailyWeatherJSON(response: JSONObject): ArrayList<Day> {
    with(response.getJSONObject(DAILY)) {
        val dayArray = getJSONArray(DATA)
        val days = ArrayList<Day>()
        for (i in dayArray) {
            with(i) {
                val min = getDouble(TEMPERATUREMIN)
                val max = getDouble(TEMPERATUREMAX)
                val time = getLong(TIME)
                days.add(Day(time, min, max))
            }

        }
        return days
    }
}
fun getHourlyWeatherJSON(response: JSONObject): ArrayList<Hour> {
    val timeZone = response.getString(TIMEZONE)
    with(response.getJSONObject(HOURLY)) {
        val hourArray = getJSONArray(DATA)
        val hour = ArrayList<Hour>()
        for (i in hourArray) {
            with(i) {
                val time = getLong(TIME)
                val temp = getDouble(TEMPERATURE)
                val precip = getDouble(PRECIPPROBABILITY)

                hour.add(Hour(time, temp, precip, timeZone))
            }
        }
        return hour
    }
}
