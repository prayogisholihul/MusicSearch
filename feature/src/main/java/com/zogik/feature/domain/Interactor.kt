package com.zogik.feature.domain

import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Interactor @Inject constructor(private val repo: Repository) : UseCase {
    override suspend fun chart(): Flow<Resource<List<Track>>> {
        return repo.chart()
    }

    override suspend fun getFavorite(): Flow<List<Track>> {
        return repo.getFavorite()
    }

    override suspend fun setFavorite(data: Track, favorite: Boolean) {
        return repo.setFavorite(data, favorite)
    }
}
