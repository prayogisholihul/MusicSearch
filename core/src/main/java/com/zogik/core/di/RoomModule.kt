package com.zogik.core.di

import android.content.Context
import androidx.room.Room
import com.zogik.core.data.DatabaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): DatabaseApp =
        Room.databaseBuilder(appContext, DatabaseApp::class.java, "MusicFavorite.db")
            .fallbackToDestructiveMigration()
            .build()
}
