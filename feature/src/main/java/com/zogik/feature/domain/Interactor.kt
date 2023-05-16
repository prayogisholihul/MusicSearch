package com.zogik.feature.domain

import com.zogik.core.domain.entity.SearchEntity
import com.zogik.core.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Interactor @Inject constructor(private val repo: Repository) : UseCase {
    override suspend fun search(key: String): Flow<Resource<List<SearchEntity>>> {
        return repo.search(key)
    }

    override suspend fun chart(): Flow<Resource<List<SearchEntity>>> {
        return repo.chart()
    }
}
