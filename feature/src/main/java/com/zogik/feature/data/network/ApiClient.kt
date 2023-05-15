package com.zogik.feature.data.network

import com.zogik.feature.data.response.ResponseMovie
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("movie/now_playing")
    fun fetchMovie(): Response<ResponseMovie>
}
