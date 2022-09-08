package com.example.newsapp.presentation.news_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.newsapp.data.model.ArticlesDTO
import com.example.newsapp.databinding.ItemNewsListBinding

class NewsListAdapter(
    private val context: Context
) : ListAdapter<ArticlesDTO, NewsListViewHolder>(NewsListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val binding = ItemNewsListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val news = getItem(position)
        with(holder.binding) {
            with(news) {
                tvTitle.text = title
                tvDescription.text = description
            }
        }
    }
}