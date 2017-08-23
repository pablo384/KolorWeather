package com.pablo384.kolorweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pablo384.kolorweather.API.API_KEY
import com.pablo384.kolorweather.API.DARK_SKY_URL

class MainActivity : AppCompatActivity() {
    val TAG= MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val latitud = 37.8267
        val longitud =-122.4233

        val url = "$DARK_SKY_URL$API_KEY/$latitud,$longitud"
        Log.d(TAG,url)
    }
}
