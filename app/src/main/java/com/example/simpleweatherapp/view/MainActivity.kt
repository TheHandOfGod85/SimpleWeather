package com.example.simpleweatherapp.view


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModel
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.databinding.ActivityMainBinding
import com.example.simpleweatherapp.viewModel.WeatherViewModel


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        // changing fragment with a button
        binding!!.btnToWeather.setOnClickListener{
            replaceFragment(WeatherFragment())
        }
        // changing fragment with a button
        binding!!.btnToForecast.setOnClickListener {
            replaceFragment(ForecastFragment())
        }

    }
    // a function to change fragment using a frgment container in the main xml
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null)
        fragmentTransaction.commit()
    }

}