package com.zogik.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zogik.core.data.entity.AlbumEntity
import com.zogik.core.data.entity.ArtistEntity
import com.zogik.core.data.entity.FavoriteTrack
import com.zogik.core.data.entity.TrackEntity
import com.zogik.core.data.model.Converter

@Database(
    entities = [TrackEntity::class, ArtistEntity::class, AlbumEntity::class, FavoriteTrack::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converter::class)
abstract class DatabaseApp : RoomDatabase() {
    abstract fun getChartDao(): ChartDao
    abstract fun getFavDao(): TrackFavDao
}
