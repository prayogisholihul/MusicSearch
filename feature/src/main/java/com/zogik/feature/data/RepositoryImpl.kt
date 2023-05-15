package com.zogik.feature.data

import com.zogik.core.data.DatabaseApp
import com.zogik.core.domain.entity.SearchEntity
import com.zogik.core.utils.BaseApiResponse
import com.zogik.core.utils.Resource
import com.zogik.feature.data.mapper.SearchDb
import com.zogik.feature.data.network.ApiClient
import com.zogik.feature.domain.Repository
import kotlinx.coroutines.flow.Flow
import networkBoundResource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ApiClient,
    private val local: DatabaseApp,
) :
    BaseApiResponse(),
    Repository {

    override suspend fun search(key: Map<String, List<String>>): Flow<Resource<List<SearchEntity>>> {
        return networkBoundResource(
            query = {
                local.getFavoriteDao().getAll()
            },
            fetch = {
                safeApiCall {
                    api.fetchMovie()
                }
            },
            saveFetchResult = {
//                val mapper = SearchDb.mapper(it.data?.data.orEmpty())
//                mapper.map { searchResult ->
//                    local.getFavoriteDao().insert(searchResult)
//                }
            },
            onFetchFailed = { },
            shouldFetch = { it.isEmpty() },
        )
    }
}
