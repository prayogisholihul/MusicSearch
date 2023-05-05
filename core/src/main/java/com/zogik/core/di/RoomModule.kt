package com.zogik.core.di

import android.content.Context
import androidx.room.Room
import com.zogik.core.data.DatabaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): DatabaseApp =
        Room.databaseBuilder(appContext, DatabaseApp::class.java, "MusicFavorite.db")
            .fallbackToDestructiveMigration()
            .build()
}
