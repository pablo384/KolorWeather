package com.pablo384.kolorweather.models

import com.pablo384.kolorweather.R

/**
 * Created by pablo384 on 23/08/17.
 */
class CurrentWeather(var icon:String, var summary:String, var temp:Double, var precip:Double){
    fun getIconResource():Int{
        when(icon){
            "clear-night"-> return R.drawable.clear_night
            "clear-day"-> return R.drawable.clear_day
            "cloudy"-> return R.drawable.cloudy
            "cloudy-night"-> return R.drawable.cloudy_night
            "partly-cloudy"-> return R.drawable.partly_cloudy
            "partly-cloudy-night"-> return R.drawable.partly_cloudy_night
            "partly-cloudy-day"-> return R.drawable.partly_cloudy_day
            "rain"-> return R.drawable.rain
            "sleet"-> return R.drawable.sleet
            "snow"-> return R.drawable.snow
            "sunny"-> return R.drawable.sunny
            "wind"-> return R.drawable.wind
            else -> return R.drawable.na
        }
    }
}