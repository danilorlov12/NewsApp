package com.example.newsapp.presentation.news_list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.newsapp.core.BaseFragment
import com.example.newsapp.data.model.ArticlesDTO
import com.example.newsapp.databinding.FragmentNewsListBinding
import com.example.newsapp.presentation.model.ArticleUI
import com.example.newsapp.presentation.news_list.adapter.ClickListener
import com.example.newsapp.presentation.news_list.adapter.NewsListAdapter

class NewsListFragment : BaseFragment<NewsListViewModel, FragmentNewsListBinding>() {

    override fun viewModelClass() = NewsListViewModel::class.java

    override fun getViewBinding() = FragmentNewsListBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NewsListAdapter(
            object : ClickListener {
                override fun click(article: ArticlesDTO?) {
                    if (article == null) {
                        Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_LONG).show()
                        return
                    }
                    val action = NewsListFragmentDirections
                        .actionFirstSceneFragmentToSecondSceneFragment(ArticleUI.fromArticleDTO(article))
                    navController.navigate(action)
                }
            }
        )
        binding.recyclerView.adapter = adapter

        viewModel.articlesList.observe(viewLifecycleOwner) { articles ->
            adapter.submitList(articles)
        }
    }
}