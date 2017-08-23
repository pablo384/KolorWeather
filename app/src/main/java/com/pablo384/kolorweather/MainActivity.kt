package com.pablo384.kolorweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.pablo384.kolorweather.API.API_KEY
import com.pablo384.kolorweather.API.DARK_SKY_URL
import com.android.volley.VolleyError
import com.android.volley.RequestQueue


class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val latitud = 37.8267
        val longitud = -122.4233

        val url = "$DARK_SKY_URL$API_KEY/$latitud,$longitud"
        Log.d(TAG, url)
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener { response -> Log.d(TAG, response.substring(0, 500))},
                Response.ErrorListener { Log.d(TAG, "ERRROR Volley") })
        queue.add(stringRequest)
    }
}
