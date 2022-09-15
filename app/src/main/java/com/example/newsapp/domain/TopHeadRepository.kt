package com.example.newsapp.domain

import com.example.newsapp.core.ResponseResult
import com.example.newsapp.data.model.ResultDTO

interface TopHeadRepository {

    suspend fun getTopHeadlines(): ResponseResult<ResultDTO>
}