package com.zogik.feature.domain

import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ArtistDetailUseCase {
    suspend fun artistDetail(artistId: String): Flow<Resource<List<Track>>>
    fun getFavoriteById(trackId: String): Track
    fun setFavorite(data: Track, favorite: Boolean)
}