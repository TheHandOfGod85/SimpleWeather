package com.example.simpleweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.databinding.FragmentForecastBinding
import com.example.simpleweatherapp.viewModel.ForecastViewModel
import com.example.simpleweatherapp.viewModel.WeatherViewModel
import kotlin.concurrent.fixedRateTimer

class ForecastFragment: Fragment(R.layout.fragment_forecast) {

    private  var binding: FragmentForecastBinding? = null
    private val sharedViewModel: ForecastViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentForecastBinding.bind(view)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            forecastViewModel = sharedViewModel
            forecastFragment = this@ForecastFragment
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}