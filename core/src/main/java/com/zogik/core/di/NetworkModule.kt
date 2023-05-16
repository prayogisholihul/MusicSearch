package com.zogik.core.di

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.zogik.core.BuildConfig
import com.zogik.core.di.qualifier.RetrofitBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideLoggerInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { message -> Log.d("NetworkError", message) }
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.HEADERS }
        interceptor.apply { interceptor.level = HttpLoggingInterceptor.Level.BODY }
        return interceptor
    }

    @Provides
    @Singleton
    fun getOkHttpClient(
        interceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder().apply {
                    header("Content-Type", "application/json")
                    header("Accept", "application/json")
                    header("Authorization", "Bearer " + BuildConfig.API_KEY)
                }
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        return httpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideBaseUrl(): String = BuildConfig.BASE_URL

    @Provides
    @Singleton
    @RetrofitBase
    fun getRetrofit(
        baseUrl: String,
        client: OkHttpClient,
        gson: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gson)
            .client(client)
            .build()
    }
}
