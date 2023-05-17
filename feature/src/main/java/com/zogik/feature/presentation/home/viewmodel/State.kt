package com.zogik.feature.presentation.home.viewmodel

import com.zogik.core.domain.model.Track

interface State {
    fun onLoadingChart() {}
    fun onSuccessChart(data: List<Track>) {}
    fun onErrorChart(error: String) {}
}
