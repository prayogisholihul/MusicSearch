package com.zogik.feature.domain

import com.zogik.core.data.entity.SearchEntity
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun search(key: Map<String, List<String>>): Flow<Resource<List<SearchEntity>>>
}
