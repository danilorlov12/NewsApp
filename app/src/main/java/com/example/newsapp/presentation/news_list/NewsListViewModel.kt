package com.example.newsapp.presentation.news_list

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newsapp.core.BaseViewModel
import com.example.newsapp.data.model.ArticlesDTO
import com.example.newsapp.data.model.ResultDTO
import com.example.newsapp.data.repository.TopHeadRepositoryImpl
import com.example.newsapp.domain.GetTopHeadlinesUseCase
import kotlinx.coroutines.launch

class NewsListViewModel(application: Application) : BaseViewModel(application) {

    private val repository = TopHeadRepositoryImpl()
    val topHeadlines: MutableLiveData<ResultDTO> = MutableLiveData()
    val articlesList: MutableLiveData<List<ArticlesDTO>> = MutableLiveData()

    init {
        viewModelScope.launch {
            val getTopHeadlinesUseCase = GetTopHeadlinesUseCase(repository)
            topHeadlines.value = getTopHeadlinesUseCase().value
            articlesList.value = topHeadlines.value!!.articlesList
        }
    }
}