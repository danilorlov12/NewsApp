package com.example.newsapp.presentation.news_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ItemNewsListBinding
import com.example.newsapp.presentation.model.ArticleUI

class NewsListAdapter(
    private val clickListener: ClickListener,
) : ListAdapter<ArticleUI, NewsListViewHolder>(NewsListDiffCallback) {

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
                tvTitle.text = title.ifEmpty { description }
                tvSourceName.text = sourceName
                tvPublishedDate.text = publishedAt
                root.setOnClickListener {
                    clickListener.click(this)
                }
                Glide.with(holder.itemView.context)
                    .load(urlToImage)
                    .into(ivImage)
            }
        }
    }
}

interface ClickListener {
    fun click(article: ArticleUI?)
}