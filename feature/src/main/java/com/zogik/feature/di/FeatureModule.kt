package com.zogik.feature.di

import com.zogik.core.data.DatabaseApp
import com.zogik.feature.data.RepositoryImpl
import com.zogik.feature.data.network.ApiClient
import com.zogik.feature.domain.Interactor
import com.zogik.feature.domain.Repository
import com.zogik.feature.domain.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeatureModule {

    @Provides
    @Singleton
    fun getApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Provides
    @Singleton
    fun repo(apiClient: ApiClient, local: DatabaseApp): Repository = RepositoryImpl(apiClient, local)

    @Provides
    @Singleton
    fun interactor(repository: Repository): UseCase = Interactor(repository)
}
