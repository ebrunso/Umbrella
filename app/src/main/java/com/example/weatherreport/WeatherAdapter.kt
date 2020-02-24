package com.example.weatherreport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherreport.Datasource.Remote.Weather
import kotlinx.android.synthetic.main.daily_report.view.*

class WeatherAdapter(val resultList: List<Weather>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.daily_report, parent, false))

    override fun getItemCount() = resultList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.populateItem(resultList[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun populateItem(weather : Weather){
            itemView.tvClouds.text = "${weather.clouds}"
            itemView.tvVisibility.text = "${weather.visibility}"
            itemView.tvWind.text = "${weather.wind}"

        }
    }

}