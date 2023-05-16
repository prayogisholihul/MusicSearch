package com.zogik.core.utils

import android.util.Log
import org.json.JSONObject
import retrofit2.Response

abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {
        try {
            val response = apiCall()
            Log.d("searchRespond", response.toString())
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.success(body)
                }
                return Resource.success(null)
            }
            val jsonObj = JSONObject(response.errorBody()?.charStream()?.readText().orEmpty())
            return error("${response.code()} ${jsonObj.getJSONObject("message")}")
        } catch (error: Exception) {
            Log.d("searchRespondError", error.message.orEmpty())
            return when {
                error.message?.contains("Unauthorized") == true -> {
                    error("Unauthorized")
                }

                else -> error(error.message ?: error.toString())
            }
        }
    }

    private fun <T> error(errorMessage: String): Resource<T> =
        Resource.error(errorMessage)
}
