package com.zogik.core.domain.favorite

import com.zogik.core.domain.model.Track
import kotlinx.coroutines.flow.Flow

class FavoriteInteractor(private val repo: FavoriteRepository) : FavoriteUseCase {
    override suspend fun getFavorite(): Flow<List<Track>> {
        return repo.getFavorite()
    }

    override suspend fun deleteFavorite(data: Track, isFavorite: Boolean) {
        return repo.deleteFavorite(data, isFavorite)
    }
}
