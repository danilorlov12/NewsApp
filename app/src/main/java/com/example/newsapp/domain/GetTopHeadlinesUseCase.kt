package com.example.newsapp.domain

class GetTopHeadlinesUseCase(
    private val topHeadRepository: TopHeadRepository
) {
    suspend operator fun invoke() = topHeadRepository.getTopHeadlines()
}