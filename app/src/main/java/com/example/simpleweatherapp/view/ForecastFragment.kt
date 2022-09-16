package com.example.simpleweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.adapter.ForecastAdapter
import com.example.simpleweatherapp.databinding.ForecastRecyclerviewBinding
import com.example.simpleweatherapp.viewModel.ForecastViewModel

class ForecastFragment : Fragment(R.layout.forecast_recyclerview) {
    // binding to fragment
    private var binding: ForecastRecyclerviewBinding? = null
    // getting the view model
    private val sharedViewModel: ForecastViewModel by activityViewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = ForecastRecyclerviewBinding.bind(view)
        binding!!.lifecycleOwner = viewLifecycleOwner

        // setting the adapter to recyclerview
        binding!!.recyclerview.apply {
            adapter = ForecastAdapter(sharedViewModel.forecastResult.value?.list!!)
        }
        // binding the variable in the xml to the fragment
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




