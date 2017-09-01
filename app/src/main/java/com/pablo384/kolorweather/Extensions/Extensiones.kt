package com.pablo384.kolorweather.Extensions

import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by pablo384 on 23/08/17.
 */
operator fun JSONArray.iterator():Iterator<JSONObject>
=(0 until length()).asSequence().map { get(it) as JSONObject }.iterator()