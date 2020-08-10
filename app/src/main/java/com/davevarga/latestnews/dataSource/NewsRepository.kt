package com.davevarga.latestnews.dataSource

import androidx.lifecycle.LiveData
import com.davevarga.latestnews.dataSource.NewsDao
import com.davevarga.latestnews.models.NewsPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository(private val newsDao: NewsDao) {

    fun getNewsFeed(): LiveData<List<NewsPost>> = newsDao.getNewsFeed()

    suspend fun insert(newsFeed: List<NewsPost>) {
        newsDao.insertNewsFeed(newsFeed)
    }

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
        }
    }

}
