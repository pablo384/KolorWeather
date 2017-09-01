package com.pablo384.kolorweather.UI

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.pablo384.kolorweather.API.API_KEY
import com.pablo384.kolorweather.API.DARK_SKY_URL
import com.pablo384.kolorweather.API.JSONParser
import com.pablo384.kolorweather.R
import com.pablo384.kolorweather.models.CurrentWeather
import com.pablo384.kolorweather.models.Day
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    lateinit var days:ArrayList<Day>
    companion object {
        val DAILY_WEATHER="DAILY_WEATHER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        precipTextView.text = getString(R.string.precip_placeholder,0)
        tempTextView.text = getString(R.string.tem_placeholder, 0)
        getWeather()


    }

    private fun getWeather() {
        val latitud = 37.8267
        val longitud = -122.4233
        val language = getString(R.string.language)
        val units = getString(R.string.units)

        val url = "$DARK_SKY_URL$API_KEY/$latitud,$longitud?lang=$language&units=$units"
        Log.d(TAG, url)
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener { response ->
                    val responseJSON=JSONObject(response)
                    buildCurrentWeather(JSONParser().getCurrentWeatherJSON(responseJSON))
                    days = JSONParser().getDailyWeatherJSON(responseJSON)
                },
                Response.ErrorListener {displayErrorMessage()})
        queue.add(stringRequest)
    }
    fun buildCurrentWeather(weather:CurrentWeather){
        descriptionTextView.text = weather.summary
        precipTextView.text = getString(R.string.precip_placeholder, (weather.precip * 100).toInt())
        tempTextView.text = getString(R.string.tem_placeholder, weather.temp.toInt())
        iconImageView.setImageDrawable(resources.getDrawable(weather.getIconResource()))
    }

    private fun displayErrorMessage() {
        val snackbar = Snackbar.make(main, getString(R.string.network_error), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.retry), {
                    getWeather()
                })
        snackbar.show()
    }
    fun startHourlyActivity(v:View)=startActivity(Intent(this,HourlyWeatherActivity::class.java))
    fun startDailyActivity(v:View)=startActivity(Intent(this,DailyWeatherActivity::class.java)
            .putParcelableArrayListExtra(DAILY_WEATHER, days))
}
