package com.zogik.feature.data.network

import com.zogik.feature.data.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("search")
    fun search(
        @Query("q") searchKey: Map<String, List<String>>,
    ): Response<SearchResponse>
}
