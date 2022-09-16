package com.example.simpleweatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweatherapp.databinding.FragmentForecastBinding
import com.example.simpleweatherapp.model.ListForecastModel

class ForecastAdapter(private  var  listForecastModel: ArrayList<ListForecastModel?>): RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {


    inner class ForecastViewHolder(val forecastBinding: FragmentForecastBinding)
        : RecyclerView.ViewHolder(forecastBinding.root){
            fun bind(listForecastmodel1: ListForecastModel){
                forecastBinding.list = listForecastmodel1
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = FragmentForecastBinding.inflate(inflater,parent,false)
        return ForecastViewHolder(listItemBinding)

    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(listForecastModel[position]!!)
    }

    override fun getItemCount(): Int = listForecastModel.size
}