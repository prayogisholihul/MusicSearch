package com.zogik.feature.domain

import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ArtistDetailRepository {
    suspend fun artistDetail(artistId: String): Flow<Resource<List<Track>>>
    fun getFavorite(): Flow<List<Track>>
    fun setFavorite(data: Track)

    fun deleteFavorite(data: Track)
}
