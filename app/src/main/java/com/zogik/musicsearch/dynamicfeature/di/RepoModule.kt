package com.zogik.musicsearch.dynamicfeature.di

import com.zogik.core.data.DatabaseApp
import com.zogik.musicsearch.dynamicfeature.data.FavoriteRepositoryImpl
import com.zogik.musicsearch.dynamicfeature.domain.FavoriteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideRepo(local: DatabaseApp): FavoriteRepository = FavoriteRepositoryImpl(local)
}
