package com.zogik.feature.presentation.viewmodel.home

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.zogik.core.utils.Resource

class Observer(
    private val vm: HomeViewModel,
    private val state: State,
) : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

        vm.chart.observe(owner) {
            when (it.status) {
                Resource.Status.LOADING -> state.onLoadingChart()
                Resource.Status.SUCCESS -> state.onSuccessChart(it.data.orEmpty())
                Resource.Status.ERROR -> state.onErrorChart(it.error.orEmpty())
            }
        }
    }
}
