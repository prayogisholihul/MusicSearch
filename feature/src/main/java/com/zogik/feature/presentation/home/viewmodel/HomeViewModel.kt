package com.zogik.feature.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import com.zogik.feature.domain.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

    private val _track: MutableLiveData<Resource<List<Track>>> = MutableLiveData()
    val track: LiveData<Resource<List<Track>>> = _track

    fun chart() {
        viewModelScope.launch {
            useCase.chart().collectLatest {
                _track.value = it
            }
        }
    }

    fun setFavorite(data: Track, favorite: Boolean) {
        viewModelScope.launch {
            useCase.setFavorite(data, favorite)
        }
    }
}
