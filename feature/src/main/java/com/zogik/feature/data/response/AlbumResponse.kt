package com.zogik.feature.data.response

import com.google.gson.annotations.SerializedName

data class AlbumResponse(

    @field:SerializedName("cover")
    val cover: String? = null,

    @field:SerializedName("md5_image")
    val md5Image: String? = null,

    @field:SerializedName("tracklist")
    val tracklist: String? = null,

    @field:SerializedName("cover_xl")
    val coverXl: String? = null,

    @field:SerializedName("cover_medium")
    val coverMedium: String? = null,

    @field:SerializedName("cover_small")
    val coverSmall: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("cover_big")
    val coverBig: String? = null,
)
