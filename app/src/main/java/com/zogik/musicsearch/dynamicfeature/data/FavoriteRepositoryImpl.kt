package com.zogik.musicsearch.dynamicfeature.data

import com.zogik.core.data.DatabaseApp
import com.zogik.core.domain.model.Track
import com.zogik.feature.data.mapper.MapperTrack
import com.zogik.musicsearch.dynamicfeature.domain.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoriteRepositoryImpl(private val local: DatabaseApp) : FavoriteRepository {
    override suspend fun getFavorite(): Flow<List<Track>> {
        return flow {
            val favorite = local.getChartDao().getFavorite()
            val mapper = MapperTrack.entityToDomain(favorite)
            emit(mapper)
        }
    }

    override suspend fun deleteFavorite(data: Track, isFavorite: Boolean) {
        val mapper = MapperTrack.domainToEntity(data)
        mapper.isFavorite = isFavorite
        local.getChartDao().setFavorite(mapper)
    }
}
