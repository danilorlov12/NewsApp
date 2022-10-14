package com.example.newsapp.presentation.news_details

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
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
            with(article) {
                Glide.with(requireContext())
                    .load(urlToImage)
                    .apply(
                        RequestOptions()
                            .fitCenter()
                            .format(DecodeFormat.PREFER_ARGB_8888)
                            .override(SIZE_ORIGINAL)
                    )
                    .into(binding.ivHeader)
                binding.tvSourceName.text = sourceName
                binding.tvPublishedDate.text = publishedAt
                binding.tvTitle.text = title
                binding.tvDescription.text = description

                binding.tvSourceUrl.paintFlags = Paint.UNDERLINE_TEXT_FLAG
                binding.tvSourceUrl.text = url
            }
        }
    }
}