package com.zogik.core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AlbumEntity(
    @PrimaryKey
    var id: String,
    var cover: String,
    var md5Image: String,
    var tracklist: String,
    var coverXl: String,
    var coverMedium: String,
    var coverSmall: String,
    var title: String,
    var type: String,
    var coverBig: String,
)
