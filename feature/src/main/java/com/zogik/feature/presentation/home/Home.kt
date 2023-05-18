package com.zogik.feature.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.zogik.core.domain.model.Track
import com.zogik.core.presentation.BaseFragment
import com.zogik.feature.databinding.FragmentHomeBinding
import com.zogik.feature.presentation.home.viewmodel.HomeViewModel
import com.zogik.feature.presentation.home.viewmodel.Observer
import com.zogik.feature.presentation.home.viewmodel.State
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : BaseFragment<FragmentHomeBinding>(), View.OnClickListener, State {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        initObserver()
        initAction()
        initData()
    }

    override fun initData() {
        viewModel.chart()
    }

    override fun initUI() {
    }

    override fun initObserver() {
        lifecycle.addObserver(Observer(viewModel, this))
    }

    override fun initAction() {
        binding.textView.setOnClickListener(this)
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

    override fun onClick(v: View?) = with(binding) {
        when (v) {
            textView -> {
                val direction = HomeDirections.homeToDetail()
                findNavController().navigate(direction)
            }
        }
    }
}
