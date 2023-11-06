package com.example.justyoutube.apiService

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiPortal {
    private val BASE_URL = "https://dev-d2xyb079dx1bvki.api.raw-labs.com"
    private val loggerInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

        val httpBuilder = OkHttpClient.Builder().apply {
            addInterceptor(loggerInterceptor)
        }
        val httpClient = httpBuilder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(YoutubeService::class.java)

}