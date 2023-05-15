package com.zogik.feature.di

import com.zogik.feature.data.RepositoryImpl
import com.zogik.feature.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun repo(repoImpl: RepositoryImpl): Repository
}
