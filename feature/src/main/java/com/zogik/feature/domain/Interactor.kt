package com.zogik.feature.domain

import com.zogik.core.utils.Resource
import com.zogik.feature.data.response.SearchResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Interactor @Inject constructor(private val repo: Repository) : UseCase {
    override suspend fun search(key: Map<String, List<String>>): Flow<Resource<SearchResponse>> {
        return repo.search(key)
    }
}
