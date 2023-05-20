package com.zogik.feature.di

import com.zogik.feature.data.ArtistDetailRepositoryImpl
import com.zogik.feature.data.ChartRepositoryImpl
import com.zogik.feature.domain.ArtistDetailRepository
import com.zogik.feature.domain.ChartRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun chartRepo(repoImpl: ChartRepositoryImpl): ChartRepository

    @Binds
    abstract fun artistDetailRepo(repositoryImpl: ArtistDetailRepositoryImpl): ArtistDetailRepository
}
