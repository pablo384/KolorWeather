package com.pablo384.kolorweather.Extensions

import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewGroup
import com.pablo384.kolorweather.R
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by pablo384 on 23/08/17.
 */
operator fun JSONArray.iterator():Iterator<JSONObject>
=(0 until length()).asSequence().map { get(it) as JSONObject }.iterator()

fun View.displaySnack(message:String, legth:Int=Snackbar.LENGTH_LONG, f:Snackbar.() -> Unit){
    val snackbar = Snackbar.make(this, message, legth)
    snackbar.f()
    snackbar.show()
}
fun Snackbar.action(message:String, listener:(View) -> Unit){
    setAction(message,listener)
}