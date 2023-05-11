package com.zogik.feature.data.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("data")
    val data: List<DataItem>? = null,
)
