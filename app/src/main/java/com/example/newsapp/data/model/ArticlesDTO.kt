package com.example.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class ArticlesDTO(
    @SerializedName("source") val sourceDto: SourceDTO,
    @SerializedName("author") val author: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("url") val url: String,
    @SerializedName("urlToImage") val urlToImage: String,
    @SerializedName("publishedAt") val publishedAt: String,
    @SerializedName("content") val content: String
)