package com.zogik.feature.data.network

import com.zogik.feature.data.response.ChartResponse
import com.zogik.feature.data.response.TrackArtistResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("chart")
    suspend fun chart(): Response<ChartResponse>

    @GET("artist/{id}/top?limit=10")
    suspend fun getTrackByArtist(@Path("id") id: String): Response<TrackArtistResponse>
}
