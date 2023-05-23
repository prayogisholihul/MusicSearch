package com.zogik.feature.presentation.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import com.zogik.feature.domain.ArtistDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: ArtistDetailUseCase) : ViewModel() {

    private val _trackArtist: MutableLiveData<Resource<List<Track>>> = MutableLiveData()
    val trackArtist: LiveData<Resource<List<Track>>> = _trackArtist

    fun getTrackArtist(artistId: String) {
        _trackArtist.value = Resource.loading()
        viewModelScope.launch {
            useCase.artistDetail(artistId).collectLatest {
                _trackArtist.value = it
            }
        }
    }

    fun getLocalTrack(trackId: String): Track {
        return useCase.getFavoriteById(trackId)
    }

    fun setFavorite(data: Track) = useCase.setFavorite(data)

    fun deleteFavorite(data: Track) = useCase.deleteFavorite(data)
}
