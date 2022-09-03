package com.example.simpleweatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.databinding.ActivityMainBinding
import com.example.simpleweatherapp.viewModel.ForecastViewModel

class ForecastActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = DataBindingUtil.setContentView(this, R.layout.activity_forecast)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // the viewModel takes care about the data from the repository so the view doesn't have any connection with it
    val forecastViewModel by lazy {
        ViewModelProvider(this)[ForecastViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        _binding = ActivityMainBinding.inflate(layoutInflater)



        binding.lifecycleOwner = this

        setContentView(binding.root)

    }
}