package com.zogik.feature.domain

import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArtistDetailInteractor @Inject constructor(private val repo: ArtistDetailRepository) :
    ArtistDetailUseCase {
    override suspend fun artistDetail(
        artistId: String,
    ): Flow<Resource<List<Track>>> {
        return repo.artistDetail(artistId)
    }

    override fun getFavorite(): Flow<List<Track>> {
        return repo.getFavorite()
    }

    override fun setFavorite(data: Track) {
        return repo.setFavorite(data)
    }

    override fun deleteFavorite(data: Track) {
        return repo.deleteFavorite(data)
    }
}
