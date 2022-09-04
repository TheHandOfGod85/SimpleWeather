package com.example.simpleweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.databinding.FragmentForecastBinding

class ForecastFragment: Fragment(R.layout.fragment_forecast) {

    private  var binding: FragmentForecastBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentForecastBinding.bind(view)

    }


}