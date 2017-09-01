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
import com.pablo384.kolorweather.API.*
import com.pablo384.kolorweather.Extensions.action
import com.pablo384.kolorweather.Extensions.displaySnack
import com.pablo384.kolorweather.R
import com.pablo384.kolorweather.models.CurrentWeather
import com.pablo384.kolorweather.models.Day
import com.pablo384.kolorweather.models.Hour
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    var days:ArrayList<Day> = ArrayList()
    var hours:ArrayList<Hour> = ArrayList()
    companion object {
        val DAILY_WEATHER="DAILY_WEATHER"
        val HOURLY_WEATHER="HOURLY_WEATHER"
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
                Response.Listener {
                    val responseJSON=JSONObject(it)
                    buildCurrentWeather(getCurrentWeatherJSON(responseJSON))
                    days = getDailyWeatherJSON(responseJSON)
                    hours= getHourlyWeatherJSON(responseJSON)
                },
                Response.ErrorListener {
                    errorDisplayMessage()
                })
        queue.add(stringRequest)
    }

    private fun errorDisplayMessage() {
        main.displaySnack(getString(R.string.network_error),Snackbar.LENGTH_LONG){
            action(getString(R.string.retry)){
                getWeather()
            }
        }
    }

    fun buildCurrentWeather(weather:CurrentWeather){
        descriptionTextView.text = weather.summary
        precipTextView.text = getString(R.string.precip_placeholder, (weather.precip * 100).toInt())
        tempTextView.text = getString(R.string.tem_placeholder, weather.temp.toInt())
        iconImageView.setImageDrawable(resources.getDrawable(weather.getIconResource()))
    }


    fun startHourlyActivity(v:View)=startActivity(Intent(this,HourlyWeatherActivity::class.java)
            .putParcelableArrayListExtra(HOURLY_WEATHER, hours))
    fun startDailyActivity(v:View)=startActivity(Intent(this,DailyWeatherActivity::class.java)
            .putParcelableArrayListExtra(DAILY_WEATHER, days))
}
