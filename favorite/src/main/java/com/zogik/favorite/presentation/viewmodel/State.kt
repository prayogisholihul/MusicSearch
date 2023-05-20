package com.zogik.favorite.presentation.viewmodel

import com.zogik.core.domain.model.Track

interface State {
    fun getFavorite(data: List<Track>){}
}