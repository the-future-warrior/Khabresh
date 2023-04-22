package com.mr_17.khabresh.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mr_17.khabresh.models.NewsResponse
import com.mr_17.khabresh.repository.NewsRepository
import com.mr_17.khabresh.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel(){
    val topHeadlines: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var topHeadlinesPage = 1

    init {
        getTopHeadlines("in")
    }

    fun getTopHeadlines(countryCode: String) = viewModelScope.launch {
        topHeadlines.postValue(Resource.Loading())
        val response = newsRepository.getTopHeadlines(countryCode, topHeadlinesPage)
        topHeadlines.postValue(handleTopHeadlinesResponse(response))
    }

    private fun handleTopHeadlinesResponse(response: Response<NewsResponse>) : Resource<NewsResponse> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}