package com.example.newsapp.presentation.news_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.data.model.ArticlesDTO

object NewsListDiffCallback : DiffUtil.ItemCallback<ArticlesDTO>() {

    override fun areItemsTheSame(oldItem: ArticlesDTO, newItem: ArticlesDTO): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ArticlesDTO, newItem: ArticlesDTO): Boolean {
        return oldItem == newItem
    }
}