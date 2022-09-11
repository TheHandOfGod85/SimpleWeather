package com.example.simpleweatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweatherapp.databinding.FragmentForecastBinding
import com.example.simpleweatherapp.model.List
import com.example.simpleweatherapp.viewModel.ForecastViewModel

class ForecastAdapter(private  var  list: ArrayList<List>): RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {


    inner class ForecastViewHolder(val forecastBinding: FragmentForecastBinding)
        : RecyclerView.ViewHolder(forecastBinding.root){
            fun bind(list1: List){
                forecastBinding.list = list1
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItemBinding = FragmentForecastBinding.inflate(inflater,parent,false)
        return ForecastViewHolder(listItemBinding)

    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}