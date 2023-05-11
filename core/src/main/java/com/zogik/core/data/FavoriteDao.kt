package com.zogik.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zogik.core.domain.entity.SearchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(postList: List<String>)

    @Query("SELECT * FROM SearchEntity")
    fun getAll(): Flow<List<SearchEntity>>
}
