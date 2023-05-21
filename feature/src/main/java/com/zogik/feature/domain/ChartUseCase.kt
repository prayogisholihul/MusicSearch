package com.zogik.feature.domain

import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ChartUseCase {
    suspend fun chart(): Flow<Resource<List<Track>>>
}
