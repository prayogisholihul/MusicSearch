package com.zogik.feature.domain

import com.zogik.core.domain.model.Track
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChartInteractor @Inject constructor(private val repo: ChartRepository) : ChartUseCase {
    override suspend fun chart(): Flow<Resource<List<Track>>> {
        return repo.chart()
    }
}
