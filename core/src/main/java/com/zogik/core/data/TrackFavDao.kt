package com.zogik.core.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zogik.core.data.entity.FavoriteTrack

@Dao
interface TrackFavDao {

    @Query("SELECT * FROM FavoriteTrack")
    fun getFavorite(): List<FavoriteTrack>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setFavorite(data: FavoriteTrack)

    @Delete
    fun deleteFavorite(data: FavoriteTrack)
}
