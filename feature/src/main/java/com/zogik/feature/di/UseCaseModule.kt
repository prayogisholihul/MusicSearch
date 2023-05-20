package com.zogik.feature.di

import com.zogik.feature.domain.ArtistDetailInteractor
import com.zogik.feature.domain.ArtistDetailUseCase
import com.zogik.feature.domain.ChartInteractor
import com.zogik.feature.domain.ChartUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun chartUseCase(chartInteractor: ChartInteractor): ChartUseCase

    @Binds
    abstract fun artistDetailUseCase(interactor: ArtistDetailInteractor): ArtistDetailUseCase
}
