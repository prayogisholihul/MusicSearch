package com.zogik.favorite.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zogik.core.domain.favorite.FavoriteUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val useCase: FavoriteUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass != FavoriteViewModel::class.java) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        return FavoriteViewModel(
            useCase,
        ) as T
    }
}
