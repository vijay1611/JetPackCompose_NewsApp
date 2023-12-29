package com.vijay.jetpacknews.domain.usecases.news

import androidx.paging.PagingData
import com.vijay.jetpacknews.domain.Repository.NewsRepository
import com.vijay.jetpacknews.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SearchNews (
    private val newsRepository: NewsRepository
    ) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery, sources = sources)

    }
}