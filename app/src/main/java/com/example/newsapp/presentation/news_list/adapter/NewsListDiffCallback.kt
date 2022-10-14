package com.example.newsapp.presentation.news_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.presentation.model.ArticleUI

object NewsListDiffCallback : DiffUtil.ItemCallback<ArticleUI>() {

    override fun areItemsTheSame(oldItem: ArticleUI, newItem: ArticleUI): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ArticleUI, newItem: ArticleUI): Boolean {
        return oldItem == newItem
    }
}