package com.zogik.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
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
) : Parcelable
