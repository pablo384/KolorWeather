package com.pablo384.kolorweather.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.pablo384.kolorweather.Adapters.HourAdapter
import com.pablo384.kolorweather.R
import com.pablo384.kolorweather.models.Hour
import kotlinx.android.synthetic.main.activity_hourly_weather.*


class HourlyWeatherActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hourly_weather)
        hourlyRecyclerView.setHasFixedSize(true)
        hourlyRecyclerView.layoutManager=LinearLayoutManager(this)
        var hour:ArrayList<Hour> = ArrayList()
        intent.let {
            hour= it.getParcelableArrayListExtra(MainActivity.HOURLY_WEATHER)
            Log.d("TAG123", hour[0].toString())
            hourlyRecyclerView.adapter= HourAdapter(hour)

        }
        if (hour.isEmpty()){
            textViewNoDataHour.visibility= View.VISIBLE
        }else{
            textViewNoDataHour.visibility= View.INVISIBLE
        }


    }
}
