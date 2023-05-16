package com.zogik.feature.di

import RetrofitBase
import com.zogik.feature.data.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideApiClient(@RetrofitBase retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }
}
