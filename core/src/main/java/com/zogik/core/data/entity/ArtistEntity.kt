package com.zogik.core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArtistEntity(
    @PrimaryKey
    var id: String,
    var pictureXl: String,
    var tracklist: String,
    var pictureBig: String,
    var name: String,
    var link: String,
    var pictureSmall: String,
    var type: String,
    var picture: String,
    var pictureMedium: String,
)
