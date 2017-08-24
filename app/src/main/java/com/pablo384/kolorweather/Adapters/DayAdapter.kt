package com.pablo384.kolorweather.Adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.pablo384.kolorweather.R
import com.pablo384.kolorweather.models.Day
import kotlinx.android.synthetic.main.daily_item.view.*

/**
 * Created by pablo384 on 23/08/17.
 */
class DayAdapter (val context: Context, val dataSource:ArrayList<Day>): BaseAdapter() {
    override fun getView(position: Int, currentView: View, parentView: ViewGroup): View {
        return currentView
    }

    override fun getItem(position: Int): Any = dataSource[position]
    override fun getItemId(p0: Int): Long=0 //we don't need this
    override fun getCount(): Int =dataSource.size

    private class ViewHolder(v:View){
        val dayTextView:TextView = v.findViewById(R.id.dayTextView)
        val minTextView:TextView = v.findViewById(R.id.minTextView)
        val maxTextView:TextView = v.findViewById(R.id.maxTextView)
    }
}