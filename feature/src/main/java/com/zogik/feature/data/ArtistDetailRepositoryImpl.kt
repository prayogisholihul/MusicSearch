package com.zogik.feature.data

import com.zogik.core.data.DatabaseApp
import com.zogik.core.domain.model.Track
import com.zogik.core.utils.BaseApiResponse
import com.zogik.core.utils.Resource
import com.zogik.feature.data.mapper.MapperArtistDetail.entityToDomain
import com.zogik.feature.data.mapper.MapperArtistDetail.responseToDomain
import com.zogik.feature.data.network.ApiClient
import com.zogik.feature.domain.ArtistDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArtistDetailRepositoryImpl @Inject constructor(
    private val local: DatabaseApp,
    private val api: ApiClient,
) : BaseApiResponse(), ArtistDetailRepository {
    override suspend fun artistDetail(
        artistId: String,
    ): Flow<Resource<List<Track>>> {
        return flow {
            val call = safeApiCall { api.getTrackByArtist(artistId) }
            val mapper = call.data?.data?.responseToDomain()
            val resource = Resource(call.status, mapper, call.error)
            emit(resource)
        }
    }

    override fun getFavoriteById(trackId: String): Track {
        val dataBase = local.getChartDao().getFavorite()
        val data = dataBase.find { it.id == trackId }

        return data.entityToDomain()
    }
}
