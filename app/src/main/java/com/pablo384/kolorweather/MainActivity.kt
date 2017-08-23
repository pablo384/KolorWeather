package com.pablo384.kolorweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.pablo384.kolorweather.API.API_KEY
import com.pablo384.kolorweather.API.DARK_SKY_URL
import com.pablo384.kolorweather.API.JSONParser
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName

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
                    with(JSONParser().getCurrentWeatherJSON(JSONObject(response))) {
                        descriptionTextView.text = summary
                        precipTextView.text = getString(R.string.precip_placeholder, (precip * 100).toInt())
                        tempTextView.text = getString(R.string.tem_placeholder, temp.toInt())
                        iconImageView.setImageDrawable(resources.getDrawable(getIconResource()))
                    }
                },
                Response.ErrorListener {displayErrorMessage()})
        queue.add(stringRequest)
    }

    private fun displayErrorMessage() {
        val snackbar = Snackbar.make(main, "NETWORK ERROR", Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY?", {
                    getWeather()
                })
        snackbar.show()
    }
}
