package com.zogik.favorite.presentation.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class Observer(
    private val viewModel: FavoriteViewModel,
    private val state: State,
) : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

        viewModel.favorite.observe(owner) {
            state.getFavorite(it)
        }
    }
}
