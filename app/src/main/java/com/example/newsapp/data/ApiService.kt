package com.example.newsapp.data

import com.example.newsapp.data.QueryConstants.CATEGORY
import com.example.newsapp.data.QueryConstants.COUNTRY
import com.example.newsapp.data.model.ResultDTO
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getEverythingNews(): Response<ResponseBody>

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query(COUNTRY) country: String = "ua",
        @Query(CATEGORY) category: String = ""
    ): Response<ResultDTO>
}