package com.example.newsapp.domain

import androidx.lifecycle.LiveData
import com.example.newsapp.data.model.ResultDTO

interface TopHeadRepository {

    suspend fun getTopHeadlines(): LiveData<ResultDTO>
}