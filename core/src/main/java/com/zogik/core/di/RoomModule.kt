package com.zogik.core.di

import android.content.Context
import androidx.room.Room
import com.zogik.core.data.DatabaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun providePass(): ByteArray = SQLiteDatabase.getBytes("ZOGIK".toCharArray())

    @Provides
    @Singleton
    fun provideFactorySecurity(pass: ByteArray) = SupportFactory(pass)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context, securityFactory: SupportFactory): DatabaseApp =
        Room.databaseBuilder(appContext, DatabaseApp::class.java, "MusicFavorite.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .openHelperFactory(securityFactory)
            .build()
}
