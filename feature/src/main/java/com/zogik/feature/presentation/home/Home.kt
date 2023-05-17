package com.zogik.feature.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zogik.core.domain.model.Track
import com.zogik.feature.R
import com.zogik.feature.presentation.mapExt
import com.zogik.feature.presentation.home.viewmodel.HomeViewModel
import com.zogik.feature.presentation.home.viewmodel.Observer
import com.zogik.feature.presentation.home.viewmodel.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : Fragment(), State {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val key: Map<String, String> = mapOf("artist" to "Avenged")
        Log.d("key", key.mapExt())
        viewModel.chart()

        lifecycle.addObserver(Observer(viewModel, this))
    }

    override fun onLoadingChart() {
        super.onLoadingChart()
        Log.d("loading", "loading")
    }

    override fun onSuccessChart(data: List<Track>) {
        super.onSuccessChart(data)
        Log.d("success", data[0].artist.name)
    }

    override fun onErrorChart(error: String) {
        super.onErrorChart(error)
        Log.d("error", error)
    }
}
