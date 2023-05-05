package com.zogik.core.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteDao::class], version = 1, exportSchema = false)
abstract class DatabaseApp : RoomDatabase() {
    abstract fun getFavoriteDao(): FavoriteDao
}
