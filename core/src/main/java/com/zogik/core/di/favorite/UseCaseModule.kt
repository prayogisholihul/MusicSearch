package com.zogik.core.di.favorite

import com.zogik.core.domain.favorite.FavoriteInteractor
import com.zogik.core.domain.favorite.FavoriteRepository
import com.zogik.core.domain.favorite.FavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(repo: FavoriteRepository): FavoriteUseCase = FavoriteInteractor(repo = repo)

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface DfDependency {

        fun favoriteUseCase(): FavoriteUseCase
    }
}
