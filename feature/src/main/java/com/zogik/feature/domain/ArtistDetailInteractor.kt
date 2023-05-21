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

    override fun getFavoriteById(trackId: String): Track {
        return repo.getFavoriteById(trackId)
    }

    override fun setFavorite(data: Track, favorite: Boolean) {
        return repo.setFavorite(data, favorite)
    }
}