package com.zogik.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zogik.core.domain.entity.SearchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(SearchEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: SearchEntity)

    @Query("SELECT * FROM Search")
    fun getAll(): Flow<List<SearchEntity>>
}
