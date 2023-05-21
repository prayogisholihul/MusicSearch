package com.zogik.favorite.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zogik.core.domain.favorite.FavoriteUseCase
import com.zogik.core.domain.model.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase,
) : ViewModel() {
    private val _favorite: MutableLiveData<List<Track>> = MutableLiveData()
    val favorite: LiveData<List<Track>> = _favorite

    fun getFavorite() {
        viewModelScope.launch {
            favoriteUseCase.getFavorite().collectLatest {
                _favorite.value = it
            }
        }
    }

    fun setDeleteFavorite(data: Track) {
        CoroutineScope(Dispatchers.IO).launch {
            favoriteUseCase.deleteFavorite(data, false)
        }
    }
}
