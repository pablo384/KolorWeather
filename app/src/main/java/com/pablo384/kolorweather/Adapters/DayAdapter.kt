package com.pablo384.kolorweather.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.pablo384.kolorweather.R
import com.pablo384.kolorweather.models.Day
import kotlinx.android.synthetic.main.daily_item.view.*
import java.text.DateFormat

/**
 * Created by pablo384 on 23/08/17.
 */
class DayAdapter (val context: Context, val dataSource:ArrayList<Day>): BaseAdapter() {

    private val mInflator = LayoutInflater.from(context)


    override fun getItem(position: Int): Any = dataSource[position]
    override fun getItemId(p0: Int): Long=0 //we don't need this
    override fun getCount(): Int =dataSource.size

    override fun getView(position: Int, convertView: View?, parentView: ViewGroup): View {
        val view:View
        val vh:ViewHolder
        if (convertView==null){
            view = this.mInflator.inflate(R.layout.daily_item,parentView, false)
            vh = ViewHolder(view)
            view.tag=vh
        }else{
            view=convertView
            vh=view.tag as ViewHolder
        }
        vh.dayTextView.text=dataSource[position].getFormattedTime()
        vh.maxTextView.text="Max ${dataSource[position].maxTemp.toString()} C"
        vh.minTextView.text="Min ${dataSource[position].minTemp.toString()} C"



        return view
    }

    private class ViewHolder(v:View){
        val dayTextView:TextView = v.findViewById(R.id.dayTextView)
        val minTextView:TextView = v.findViewById(R.id.minTextView)
        val maxTextView:TextView = v.findViewById(R.id.maxTextView)
    }
}