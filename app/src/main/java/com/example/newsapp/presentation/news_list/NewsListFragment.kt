package com.example.newsapp.presentation.news_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsapp.core.BaseFragment
import com.example.newsapp.databinding.NewsListFragmentBinding
import com.example.newsapp.presentation.news_list.adapter.NewsListAdapter

class NewsListFragment : BaseFragment<NewsListViewModel, NewsListFragmentBinding>() {

    override fun viewModelClass() = NewsListViewModel::class.java

    override fun getViewBinding() = NewsListFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NewsListAdapter(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.articlesList.observe(viewLifecycleOwner) { articles ->
            adapter.submitList(articles)
        }
    }

    companion object {
        fun newInstance(): Fragment {
            return NewsListFragment()
        }
    }
}