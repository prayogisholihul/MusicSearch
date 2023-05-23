package com.zogik.feature.presentation.detail.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.zogik.core.utils.Resource

class Observer(
    private val viewModel: DetailViewModel,
    private val state: State,
) : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

        viewModel.trackArtist.observe(owner) {
            when (it.status) {
                Resource.Status.LOADING -> state.onLoadingTrackArtist()
                Resource.Status.SUCCESS -> state.onSuccessTrackArtist(it.data.orEmpty())
                Resource.Status.ERROR -> state.onErrorTrackArtist(it.error.orEmpty())
            }
        }

        viewModel.localTrack.observe(owner) {
            state.onGetLocalTrack(it)
        }
    }
}
