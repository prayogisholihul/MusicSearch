package com.zogik.core.di.favorite

import com.zogik.core.data.DatabaseApp
import com.zogik.core.data.favorite.FavoriteRepositoryImpl
import com.zogik.core.domain.favorite.FavoriteRepository
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
