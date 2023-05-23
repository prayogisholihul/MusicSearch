package com.zogik.core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Track")
data class TrackEntity(
    @PrimaryKey
    var id: String,
    var readable: Boolean,
    var preview: String,
    var md5Image: String,
    var artist: ArtistEntity,
    var album: AlbumEntity,
    var link: String,
    var explicitContentCover: Int,
    var title: String,
    var titleVersion: String,
    var explicitLyrics: Boolean,
    var type: String,
    var titleShort: String,
    var duration: Int,
    var rank: Int,
    var position: String,
    var explicitContentLyrics: Int
)
