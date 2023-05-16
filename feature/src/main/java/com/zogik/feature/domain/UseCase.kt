package com.zogik.feature.domain

import com.zogik.core.domain.entity.SearchEntity
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UseCase {
    suspend fun search(key: String): Flow<Resource<List<SearchEntity>>>
    suspend fun chart(): Flow<Resource<List<SearchEntity>>>
}
