package com.zogik.core.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Artist")
data class ArtistEntity(
    @PrimaryKey
    val id: String,
    val pictureXl: String,
    val tracklist: String,
    val pictureBig: String,
    val name: String,
    val link: String,
    val pictureSmall: String,
    val type: String,
    val picture: String,
    val pictureMedium: String,
)
