package com.pablo384.kolorweather.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pablo384.kolorweather.R
import com.pablo384.kolorweather.models.Day

class DailyWeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_weather)
        //se ejecuta solo sino es nulo
        intent.let {
            //rellenar Lista
            val days:ArrayList<Day> = it.getParcelableArrayListExtra(MainActivity.DAILY_WEATHER)
            Log.d("TAG",days.get(0).toString())
        }
    }
}
