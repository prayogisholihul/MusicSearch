package com.zogik.feature.domain

import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UseCase {
    suspend fun chart(): Flow<Resource<List<Track>>>
    suspend fun getFavorite(): Flow<List<Track>>
    suspend fun setFavorite(data: Track, favorite: Boolean)
}
