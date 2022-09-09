package com.example.simpleweatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleweatherapp.databinding.FragmentForecastBinding
import com.example.simpleweatherapp.viewModel.ForecastViewModel

class ForecastAdapter(val forecastList: ArrayList<ForecastViewModel>): RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    inner class ForecastViewHolder(val forecastBinding: FragmentForecastBinding)
        : RecyclerView.ViewHolder(forecastBinding.root){
            fun bindForecast(forecastViewModel: ForecastViewModel){
                forecastBinding.txtDate.text = forecastViewModel.forecastResult.value?.date!!
                forecastBinding.txtFeel.text = forecastViewModel.forecastResult.value?.feel!!.toString()
                forecastBinding.txtMin.text = forecastViewModel.forecastResult.value?.max!!.toString()
                forecastBinding.txtMax.text = forecastViewModel.forecastResult.value?.min!!.toString()
                forecastBinding.txtTemp.text = forecastViewModel.forecastResult.value?.temp!!.toString()
                forecastBinding.txtDescription.text = forecastViewModel.forecastResult.value?.description!!
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(FragmentForecastBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val forecast = forecastList[position]
        holder.bindForecast(forecast)
    }

    override fun getItemCount(): Int = forecastList.size
}