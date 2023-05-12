package com.zogik.core.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Album")
data class AlbumEntity(
    @PrimaryKey
    val id: String,
    val cover: String,
    val md5Image: String,
    val tracklist: String,
    val coverXl: String,
    val coverMedium: String,
    val coverSmall: String,
    val title: String,
    val type: String,
    val coverBig: String,
)
