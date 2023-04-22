package com.mr_17.khabresh.api;

import com.mr_17.khabresh.models.NewsResponse
import com.mr_17.khabresh.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET;
import retrofit2.http.Query;

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") countryCode: String = "in",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>
}
