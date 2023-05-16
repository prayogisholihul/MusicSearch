package com.zogik.feature.presentation.viewmodel.home

import com.zogik.core.domain.entity.SearchEntity

interface State {
    fun onLoadingChart() {}
    fun onSuccessChart(data: List<SearchEntity>) {}
    fun onErrorChart(error: String) {}
}
