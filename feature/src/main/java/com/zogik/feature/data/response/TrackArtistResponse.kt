package com.zogik.feature.data.response

import com.google.gson.annotations.SerializedName

data class TrackArtistResponse(

    @field:SerializedName("next")
    val next: String? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("data")
    val data: List<DataItem>? = null,
)
