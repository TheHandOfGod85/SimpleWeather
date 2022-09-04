package com.example.simpleweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.databinding.FragmentWeatherBinding
import com.example.simpleweatherapp.viewModel.WeatherViewModel

class WeatherFragment: Fragment(R.layout.fragment_weather) {
    private var binding: FragmentWeatherBinding? = null



    // the viewModel takes care about the data from the repository so the view doesn't have any connection with it
    private val viewModel by lazy {
        ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentWeatherBinding.bind(view)
        binding!!.viewModel = viewModel

    }
}