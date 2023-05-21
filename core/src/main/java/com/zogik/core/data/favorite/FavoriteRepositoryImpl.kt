package com.zogik.core.data.favorite

import com.zogik.core.data.DatabaseApp
import com.zogik.core.data.mapper.MapperFavorite
import com.zogik.core.domain.favorite.FavoriteRepository
import com.zogik.core.domain.model.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoriteRepositoryImpl(private val local: DatabaseApp) : FavoriteRepository {
    override suspend fun getFavorite(): Flow<List<Track>> {
        return flow {
            val favorite = local.getFavDao().getFavorite()
            val mapper = MapperFavorite.entityToDomain(favorite)
            emit(mapper)
        }
    }

    override suspend fun deleteFavorite(data: Track, isFavorite: Boolean) {
        val mapper = MapperFavorite.domainToEntity(data)
        mapper.isFavorite = isFavorite
        local.getFavDao().setFavorite(mapper)
    }
}
