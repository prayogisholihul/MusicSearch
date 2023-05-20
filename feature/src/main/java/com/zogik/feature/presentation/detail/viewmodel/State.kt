package com.zogik.feature.presentation.detail.viewmodel

import com.zogik.core.domain.model.Track

interface State {

    fun onLoadingTrackArtist() {}
    fun onSuccessTrackArtist(data: List<Track>) {}
    fun onErrorTrackArtist(error: String) {}
}
