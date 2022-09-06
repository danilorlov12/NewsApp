package com.example.newsapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.ApiFactory
import com.example.newsapp.data.mapper.NewsMapper
import com.example.newsapp.domain.TopHeadRepository
import com.example.newsapp.data.model.ResultDTO

class TopHeadRepositoryImpl : TopHeadRepository {

    private val apiService = ApiFactory.apiService

    override suspend fun getTopHeadlines(): LiveData<ResultDTO> {
        val response = apiService.getTopHeadlines()
        return MutableLiveData(NewsMapper.map(response))
    }
}