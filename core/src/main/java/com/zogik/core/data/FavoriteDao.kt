package com.zogik.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(postList: List<String>)

//    @Query("SELECT * FROM favorite")
    fun getAll(): Flow<List<String>>
}
