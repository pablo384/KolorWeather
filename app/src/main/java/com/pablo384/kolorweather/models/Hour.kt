package com.pablo384.kolorweather.models

import android.os.Parcel
import android.os.Parcelable
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by pablo384 on 01/09/17.
 */
data class Hour(val time:Long, val temp:Double, val precip:Double) : Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readDouble(),
            parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeLong(time)
        parcel.writeDouble(temp)
        parcel.writeDouble(precip)
    }

    override fun describeContents(): Int =0

    fun getFormattedTime():String{
        val formater = SimpleDateFormat("h:mm a")
        val date = Date(time*1000)
        val dayOfWeek=formater.format(date)
        return dayOfWeek
    }

    companion object CREATOR : Parcelable.Creator<Hour> {
        override fun createFromParcel(parcel: Parcel): Hour {
            return Hour(parcel)
        }

        override fun newArray(size: Int): Array<Hour?> {
            return arrayOfNulls(size)
        }
    }
}