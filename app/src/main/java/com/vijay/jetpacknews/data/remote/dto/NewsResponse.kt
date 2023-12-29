package com.vijay.jetpacknews.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.vijay.jetpacknews.domain.model.Article

data class  NewsResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)