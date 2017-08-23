package com.pablo384.kolorweather.models

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by pablo384 on 23/08/17.
 */
class Day(val time:Long, val minTemp:Double, val maxTemp:Double) {
    fun getFormattedTime():String{
        val formater = SimpleDateFormat("EEEE", Locale.US)
        val date = Date(time*1000)
        val dayOfWeek=formater.format(date)
        return dayOfWeek
    }
}