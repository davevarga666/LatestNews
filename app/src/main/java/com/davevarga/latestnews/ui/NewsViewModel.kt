package com.davevarga.latestnews.ui

import android.app.Application
import androidx.lifecycle.*
import com.davevarga.latestnews.dataSource.NewsRepository
import com.davevarga.latestnews.dataSource.database.AppDatabase
import com.davevarga.latestnews.models.NewsPost
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    val repository: NewsRepository
    val newsFeed: LiveData<List<NewsPost>>

    init {
        val newsDao = AppDatabase.getInstance(application).newsDao()
        repository = NewsRepository(newsDao)
        newsFeed = repository.getNewsFeed()
    }

    fun insert(newsFeed: List<NewsPost>) {
        viewModelScope.launch {
            repository.insert(newsFeed)
        }
    }
}

    @Suppress("UNCHECKED_CAST")
    class NewsViewModelFactory(val application: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
                return NewsViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}