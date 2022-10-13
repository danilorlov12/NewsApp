package com.example.newsapp.presentation.news_details

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.core.BaseViewModel
import com.example.newsapp.presentation.model.ArticleUI

class NewsDetailsViewModel(application: Application) : BaseViewModel(application) {

    val articleDetails: MutableLiveData<ArticleUI> = MutableLiveData()
}