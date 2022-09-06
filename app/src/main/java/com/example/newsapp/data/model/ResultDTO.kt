package com.example.newsapp.data.model

import com.example.newsapp.data.model.ArticlesDTO
import com.google.gson.annotations.SerializedName

data class ResultDTO(
    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articlesList: List<ArticlesDTO>
)
