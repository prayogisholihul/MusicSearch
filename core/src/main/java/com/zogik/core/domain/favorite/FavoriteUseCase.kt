package com.zogik.core.domain.favorite

import com.zogik.core.domain.model.Track
import kotlinx.coroutines.flow.Flow

interface FavoriteUseCase {
    suspend fun getFavorite(): Flow<List<Track>>
    suspend fun deleteFavorite(data: Track, isFavorite: Boolean)
}
