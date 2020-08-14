package com.davevarga.latestnews.ui

import android.app.Application
import androidx.lifecycle.*
import com.davevarga.latestnews.dataSource.NewsRepository
import com.davevarga.latestnews.dataSource.database.AppDatabase
import com.davevarga.latestnews.models.NewsPost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.IOException

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NewsRepository =
        NewsRepository(AppDatabase.getInstance(application).newsDao())

    val newsFeed: LiveData<List<NewsPost>> = repository.getNewsFeed()
    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                repository.refreshNews()
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false

            } catch (networkError: IOException) {
                // Show a Toast error message and hide the progress bar.
                if (newsFeed.value.isNullOrEmpty())
                    _eventNetworkError.value = true
            }
        }

    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
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