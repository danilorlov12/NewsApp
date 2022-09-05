package com.example.newsapp.data

import com.example.newsapp.data.QueryConstants.CATEGORY
import com.example.newsapp.data.QueryConstants.COUNTRY
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getEverythingNews(): ResponseBody

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query(COUNTRY) country: String = "ua",
        @Query(CATEGORY) category: String = ""
    ): ResponseBody
}