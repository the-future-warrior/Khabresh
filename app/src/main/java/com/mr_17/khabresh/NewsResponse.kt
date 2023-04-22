package com.mr_17.khabresh

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)