package com.tanvi.newsappdemo.Model

import com.tanvi.newsappdemo.Model.Article

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)