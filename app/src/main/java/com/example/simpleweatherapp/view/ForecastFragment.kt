package com.example.simpleweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.adapter.ForecastAdapter
import com.example.simpleweatherapp.databinding.ForecastRecyclerviewBinding
import com.example.simpleweatherapp.databinding.FragmentForecastBinding
import com.example.simpleweatherapp.model.List
import com.example.simpleweatherapp.viewModel.ForecastViewModel

class ForecastFragment : Fragment(R.layout.forecast_recyclerview) {

    private var binding: ForecastRecyclerviewBinding? = null

    private val sharedViewModel: ForecastViewModel by activityViewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = ForecastRecyclerviewBinding.bind(view)
        binding!!.lifecycleOwner = viewLifecycleOwner
        binding!!.recyclerview.apply {
            adapter = ForecastAdapter(sharedViewModel.forecastResult.value?.list!!)

        }
        binding!!.apply {
            viewModel = sharedViewModel
            bind = this@ForecastFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}




