package com.example.simpleweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.adapter.ForecastAdapter
import com.example.simpleweatherapp.databinding.ForecastRecyclerviewBinding
import com.example.simpleweatherapp.viewModel.ForecastViewModel

class ForecastFragment : Fragment(R.layout.forecast_recyclerview) {
    // binding to fragment
    private lateinit var binding: ForecastRecyclerviewBinding
    // getting the view model
    private val viewModel: ForecastViewModel by activityViewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = ForecastRecyclerviewBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner



        // binding the variable in the xml to the fragment
        binding.viewModel = viewModel
        // observe the viewModel
        viewModel.forecastResult.observe(viewLifecycleOwner, Observer { forecastResult ->
            // setting the adapter to recyclerview
            binding.recyclerview.adapter = ForecastAdapter(forecastResult.list)
        })
    }

}




