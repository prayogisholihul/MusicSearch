package com.zogik.feature.di

import com.zogik.feature.data.ChartRepositoryImpl
import com.zogik.feature.domain.ChartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun repo(repoImpl: ChartRepositoryImpl): ChartRepository
}
