package com.zogik.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Track(
    val id: String,
    val readable: Boolean,
    val preview: String,
    val md5Image: String,
    val artist: Artist,
    val album: Album,
    val link: String,
    val explicitContentCover: Int,
    val title: String,
    val titleVersion: String,
    val explicitLyrics: Boolean,
    val type: String,
    val titleShort: String,
    val duration: Int,
    val rank: Int,
    val position: String,
    val explicitContentLyrics: Int
) : Parcelable {
}
