package com.zogik.feature.data.network

import com.zogik.feature.data.response.ChartResponse
import com.zogik.feature.data.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("search")
    suspend fun search(
        @Query("q", encoded = true) searchKey: String,
    ): Response<SearchResponse>

    @GET("chart")
    suspend fun chart(): Response<ChartResponse>
}
