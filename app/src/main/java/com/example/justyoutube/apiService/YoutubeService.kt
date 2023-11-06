package com.example.justyoutube.apiService

import com.example.justyoutube.model.BaseApiResponse
import com.example.justyoutube.model.Youtube
import retrofit2.http.GET

interface YoutubeService {
    @GET("/youtubelist")
    suspend fun getYoutubeList():BaseApiResponse<MutableList<Youtube>>
}