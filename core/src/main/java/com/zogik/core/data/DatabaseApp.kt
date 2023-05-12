package com.zogik.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zogik.core.data.model.Converter
import com.zogik.core.domain.entity.AlbumEntity
import com.zogik.core.domain.entity.ArtistEntity
import com.zogik.core.domain.entity.SearchEntity

@Database(
    entities = [SearchEntity::class, ArtistEntity::class, AlbumEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converter::class)
abstract class DatabaseApp : RoomDatabase() {
    abstract fun getFavoriteDao(): FavoriteDao
}
