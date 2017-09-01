package com.pablo384.kolorweather.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pablo384.kolorweather.R
import com.pablo384.kolorweather.models.Hour
import kotlinx.android.synthetic.main.hourly_item.view.*

/**
 * Created by pablo384 on 01/09/17.
 */
class HourAdapter(val daysList:ArrayList<Hour>) : RecyclerView.Adapter<HourAdapter.HourViewHolder>() {
    override fun onBindViewHolder(holder: HourViewHolder, position: Int) {
        return holder.bind(daysList[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourViewHolder
            =HourViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.hourly_item,parent,false))


    override fun getItemCount(): Int= daysList.size


    class HourViewHolder(hourlyItemView:View):RecyclerView.ViewHolder(hourlyItemView){
        fun bind(hour:Hour)= with(itemView){
            hourTextView.text=hour.getFormattedTime()
            hourprecipTextView.text="${hour.precip.toInt()} %"
            hourtempTextView.text="${hour.temp.toInt()} C"
        }
    }
}