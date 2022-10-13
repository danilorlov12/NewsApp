package com.example.newsapp.presentation.news_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.newsapp.data.model.ArticlesDTO
import com.example.newsapp.databinding.ItemNewsListBinding
import com.example.newsapp.utils.DateFormat

class NewsListAdapter(
    private val clickListener: ClickListener,
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
                root.setOnClickListener {
                    clickListener.click(this)
                }
                //TODO ivImage.drawable =
            }
        }
    }
}

interface ClickListener {
    fun click(article: ArticlesDTO?)
}