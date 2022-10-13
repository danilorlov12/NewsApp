package com.example.newsapp.presentation.model

import com.example.newsapp.data.model.ArticlesDTO
import java.io.Serializable

data class ArticleUI(
    val sourceId: String,
    val sourceName: String,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) : Serializable {
    companion object {
        fun fromArticleDTO(newsDTO: ArticlesDTO?): ArticleUI {
            return ArticleUI(
                sourceId = newsDTO?.sourceDto?.id ?: "",
                sourceName = newsDTO?.sourceDto?.name ?: "",
                author = newsDTO?.author ?: "",
                title = newsDTO?.title ?: "",
                description = newsDTO?.description ?: "",
                url = newsDTO?.url ?: "",
                urlToImage = newsDTO?.urlToImage ?: "",
                publishedAt = newsDTO?.publishedAt ?: "",
                content = newsDTO?.content ?: ""
            )
        }
    }
}