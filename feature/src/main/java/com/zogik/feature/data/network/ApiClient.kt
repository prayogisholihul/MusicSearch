package com.zogik.feature.data.network

import com.zogik.feature.data.response.ChartResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("chart")
    suspend fun chart(): Response<ChartResponse>
}
