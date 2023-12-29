package com.vijay.jetpacknews.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vijay.jetpacknews.data.remote.NewsPagingSource
import com.vijay.jetpacknews.data.remote.SearchNewsPagingSource
import com.vijay.jetpacknews.data.remote.dto.NewsApi
import com.vijay.jetpacknews.domain.Repository.NewsRepository
import com.vijay.jetpacknews.domain.model.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
):NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
                return Pager(
                    config = PagingConfig(pageSize = 10),
                    pagingSourceFactory = {
                        NewsPagingSource(
                            newsApi = newsApi,
                            sources=sources.joinToString(separator = ",")
                            )
                    }
                ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery=searchQuery,
                    newsApi = newsApi,
                    sources=sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}