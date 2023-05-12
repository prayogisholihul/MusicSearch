package com.zogik.core.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Search")
data class SearchEntity(
    @PrimaryKey
    val id: String,
    val readable: Boolean,
    val preview: String,
    val md5Image: String,
    val artist: ArtistEntity,
    val album: AlbumEntity,
    val link: String,
    val explicitContentCover: Int,
    val title: String,
    val titleVersion: String,
    val explicitLyrics: Boolean,
    val type: String,
    val titleShort: String,
    val duration: Int,
    val rank: Int,
    val explicitContentLyrics: Int,
)
