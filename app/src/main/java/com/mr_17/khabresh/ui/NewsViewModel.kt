package com.mr_17.khabresh.ui

import androidx.lifecycle.ViewModel
import com.mr_17.khabresh.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel(){

}