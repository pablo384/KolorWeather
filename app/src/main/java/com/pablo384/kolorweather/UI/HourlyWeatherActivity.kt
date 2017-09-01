package com.pablo384.kolorweather.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.pablo384.kolorweather.R
import com.pablo384.kolorweather.models.Hour
import kotlinx.android.synthetic.main.activity_hourly_weather.*
import java.util.ArrayList

class HourlyWeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hourly_weather)
        hourlyRecyclerView.setHasFixedSize(true)
        hourlyRecyclerView.layoutManager=LinearLayoutManager(this)
//        hourlyRecyclerView.adapter=HourAdapter()
        intent.let {
            val hour:ArrayList<Hour> = it.getParcelableArrayListExtra(MainActivity.HOURLY_WEATHER)
            Log.d("TAG123", hour[0].toString())
        }


    }
}
