package com.zogik.feature.domain

import com.zogik.core.utils.Resource
import com.zogik.feature.data.response.SearchResponse
import kotlinx.coroutines.flow.Flow

interface UseCase {
    suspend fun search(key: Map<String, List<String>>): Flow<Resource<SearchResponse>>
}
