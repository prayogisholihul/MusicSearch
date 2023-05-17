package com.zogik.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.zogik.core.data.entity.TrackEntity

@Dao
interface ChartDao {

    @Insert(TrackEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<TrackEntity>)

    @Query("SELECT * FROM Track")
    fun getAll(): List<TrackEntity>

    @Query("SELECT * FROM Track WHERE isFavorite = 1")
    fun getFavorite(): List<TrackEntity>

    @Update
    fun setFavorite(data: TrackEntity)
}
