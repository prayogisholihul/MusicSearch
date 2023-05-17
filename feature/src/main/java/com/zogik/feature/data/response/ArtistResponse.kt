package com.zogik.feature.data.response

import com.google.gson.annotations.SerializedName

data class ArtistResponse(

    @field:SerializedName("picture_xl")
    val pictureXl: String? = null,

    @field:SerializedName("tracklist")
    val tracklist: String? = null,

    @field:SerializedName("picture_big")
    val pictureBig: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("link")
    val link: String? = null,

    @field:SerializedName("picture_small")
    val pictureSmall: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("picture")
    val picture: String? = null,

    @field:SerializedName("picture_medium")
    val pictureMedium: String? = null,
)
