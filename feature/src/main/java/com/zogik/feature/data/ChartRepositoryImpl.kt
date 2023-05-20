package com.zogik.feature.data

import android.util.Log
import com.zogik.core.data.DatabaseApp
import com.zogik.core.domain.model.Track
import com.zogik.core.utils.BaseApiResponse
import com.zogik.core.utils.Resource
import com.zogik.feature.data.mapper.MapperTrack
import com.zogik.feature.data.network.ApiClient
import com.zogik.feature.domain.ChartRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import networkBoundResource
import javax.inject.Inject

class ChartRepositoryImpl @Inject constructor(
    private val api: ApiClient,
    private val local: DatabaseApp,
) :
    BaseApiResponse(),
    ChartRepository {

    override suspend fun chart(): Flow<Resource<List<Track>>> {
        return networkBoundResource(
            query = {
                val data = local.getChartDao().getAll()
                val mapper = MapperTrack.entityToDomain(data)
                flow { emit(mapper) }
            },
            fetch = {
                safeApiCall {
                    api.chart()
                }
            },
            saveFetchResult = {
                val mapper = MapperTrack.responseToEntity(it.data?.tracks?.data.orEmpty())
                Log.d("TrackDataRepo", mapper.toString())
                local.getChartDao().insert(mapper)
            },
            shouldFetch = { it.isNullOrEmpty() },
            coroutineDispatcher = Dispatchers.IO,
        )
    }

    override suspend fun getFavorite(): Flow<List<Track>> {
        return flow {
            val entity = local.getChartDao().getFavorite()
            val mapper = MapperTrack.entityToDomain(entity)
            emit(mapper)
        }
    }

    override suspend fun setFavorite(data: Track, favorite: Boolean) {
        val entity = MapperTrack.domainToEntity(data)
        entity.isFavorite = favorite
        local.getChartDao().setFavorite(entity)
    }
}
