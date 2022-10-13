package com.example.newsapp.presentation.news_details

import android.os.Bundle
import android.view.View
import com.example.newsapp.core.BaseFragment
import com.example.newsapp.databinding.FragmentNewsDetailsBinding

class NewsDetailsFragment : BaseFragment<NewsDetailsViewModel, FragmentNewsDetailsBinding>() {

    override fun getViewBinding() = FragmentNewsDetailsBinding.inflate(layoutInflater)

    override fun viewModelClass() = NewsDetailsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = NewsDetailsFragmentArgs.fromBundle(requireArguments())
        viewModel.articleDetails.value = args.singleNews

        viewModel.articleDetails.observe(viewLifecycleOwner) { article ->
            binding.tvDescription.text = article.description
            //TODO binding.ivHeader =
        }
    }
}