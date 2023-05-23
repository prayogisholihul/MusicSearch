package com.zogik.feature.data.response

import com.google.gson.annotations.SerializedName

data class DataItem(

    @field:SerializedName("readable")
    val readable: Boolean? = null,

    @field:SerializedName("preview")
    val preview: String? = null,

    @field:SerializedName("md5_image")
    val md5Image: String? = null,

    @field:SerializedName("artist")
    val artistResponse: ArtistResponse? = null,

    @field:SerializedName("contributors")
    val contributors: List<ArtistResponse>? = null,

    @field:SerializedName("album")
    val album: AlbumResponse? = null,

    @field:SerializedName("link")
    val link: String? = null,

    @field:SerializedName("explicit_content_cover")
    val explicitContentCover: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("title_version")
    val titleVersion: String? = null,

    @field:SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("title_short")
    val titleShort: String? = null,

    @field:SerializedName("duration")
    val duration: Int? = null,

    @field:SerializedName("rank")
    val rank: Int? = null,

    @field:SerializedName("position")
    val position: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int? = null,
)