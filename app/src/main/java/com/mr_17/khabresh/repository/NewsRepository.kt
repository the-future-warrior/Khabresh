package com.mr_17.khabresh.repository

import androidx.room.Query
import com.mr_17.khabresh.api.RetrofitInstance
import com.mr_17.khabresh.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getTopHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getTopHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
}