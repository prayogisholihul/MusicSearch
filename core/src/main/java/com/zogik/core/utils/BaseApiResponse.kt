package com.zogik.core.utils

import android.util.Log
import org.json.JSONObject
import retrofit2.Response

abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.success(body)
                }
                return Resource.success(null)
            }

            Log.d("searchRespond", response.toString())
            val jsonObj = JSONObject(response.errorBody()?.charStream()?.readText().orEmpty())
            return error("${response.code()} ${jsonObj.getJSONObject("message")}")
        } catch (e: Exception) {
            return when {
                e.message?.contains("Unauthorized") == true -> {
                    error("Unauthorized")
                }

                else -> error(e.message ?: e.toString())
            }
        }
    }

    private fun <T> error(errorMessage: String): Resource<T> =
        Resource.error(errorMessage)
}
