package com.mr_17.khabresh.repository

import androidx.room.Query
import com.mr_17.khabresh.api.RetrofitInstance
import com.mr_17.khabresh.db.ArticleDatabase
import com.mr_17.khabresh.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getTopHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getTopHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSaveNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}