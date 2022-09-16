package com.example.newsapp.presentation.news_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.newsapp.utils.DateFormat
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
                tvTitle.text = title.ifEmpty { description }
                tvAuthor.text = author
                val formattedDate = DateFormat.DATE.parse(publishedAt)
                tvPublishedDate.text
                tvPublishedDate.text = if (formattedDate != null) {
                    DateFormat.ACT_TIME_SHORT.format(formattedDate)
                } else {
                    ""
                }
                //TODO ivImage.drawable =
            }
        }
    }
}