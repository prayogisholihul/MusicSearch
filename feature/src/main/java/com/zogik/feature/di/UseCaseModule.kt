package com.zogik.feature.di

import com.zogik.feature.domain.Interactor
import com.zogik.feature.domain.UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun useCase(interactor: Interactor): UseCase
}
