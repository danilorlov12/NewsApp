package com.example.newsapp.data.repository

import com.example.newsapp.core.BaseRepository
import com.example.newsapp.data.ApiFactory
import com.example.newsapp.domain.TopHeadRepository

class TopHeadRepositoryImpl : BaseRepository(), TopHeadRepository {

    private val apiService = ApiFactory.apiService

    override suspend fun getTopHeadlines() = wrapRequest {
        apiService.getTopHeadlines()
    }
}