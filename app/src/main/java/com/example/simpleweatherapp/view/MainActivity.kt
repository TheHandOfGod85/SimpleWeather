package com.example.simpleweatherapp.view


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.databinding.ActivityMainBinding
import com.example.simpleweatherapp.viewModel.WeatherViewModel


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnToWeather.setOnClickListener{
            replaceFragment(WeatherFragment())
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment).addToBackStack(null)
        fragmentTransaction.commit()
    }

}