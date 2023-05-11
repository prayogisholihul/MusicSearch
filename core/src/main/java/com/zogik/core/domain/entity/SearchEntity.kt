package com.zogik.core.domain.entity

import androidx.room.Entity

@Entity(tableName = "SearchEntity")
data class SearchEntity(
    val readable: Boolean? = null,
    val preview: String? = null,
    val md5Image: String? = null,
    val artist: ArtistEntity? = null,
    val album: AlbumEntity? = null,
    val link: String? = null,
    val explicitContentCover: Int? = null,
    val title: String? = null,
    val titleVersion: String? = null,
    val explicitLyrics: Boolean? = null,
    val type: String? = null,
    val titleShort: String? = null,
    val duration: Int? = null,
    val rank: Int? = null,
    val id: Int? = null,
    val explicitContentLyrics: Int? = null,
)
