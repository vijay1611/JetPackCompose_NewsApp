package com.vijay.jetpacknews.domain.Repository

import androidx.paging.PagingData
import com.vijay.jetpacknews.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources:List<String>):Flow<PagingData<Article>>
    fun searchNews(searchQuery:String,sources:List<String>):Flow<PagingData<Article>>
}