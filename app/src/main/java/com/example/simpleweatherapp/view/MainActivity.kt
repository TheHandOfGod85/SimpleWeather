package com.example.simpleweatherapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.simpleweatherapp.databinding.ActivityMainBinding
import com.example.simpleweatherapp.viewModel.WeatherViewModel

class MainActivity : AppCompatActivity() {


    private var _binding : ActivityMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // the viewModel takes care about the data from the repository so the view doesn't have any connection with it
    val viewModel by lazy {
        ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        setContentView(binding.root)
    }

}