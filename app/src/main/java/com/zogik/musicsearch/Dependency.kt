package com.zogik.musicsearch

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Dependency {

    @Provides
    @Singleton
    fun provideApp(): Application {
        return ApplicationModule.instance
    }
}
