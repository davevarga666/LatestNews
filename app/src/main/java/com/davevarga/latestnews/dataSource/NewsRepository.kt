package com.davevarga.latestnews.dataSource

import androidx.lifecycle.LiveData
import com.davevarga.latestnews.dataSource.NewsDao
import com.davevarga.latestnews.dataSource.network.GetData
import com.davevarga.latestnews.dataSource.network.ServiceBuilder
import com.davevarga.latestnews.models.NewsPost
import com.davevarga.latestnews.ui.NewsRecyclerAdapter
import kotlinx.coroutines.*

class NewsRepository(private val newsDao: NewsDao) {

    fun getNewsFeed(): LiveData<List<NewsPost>> = newsDao.getNewsFeed()


    suspend fun refreshNews() {
        withContext(Dispatchers.IO) {
            val newsFeed = ServiceBuilder.getNetworkClient(GetData::class.java).getData()
            newsDao.insertNewsFeed(NewsRecyclerAdapter(newsFeed.body()!!.postList).items)
        }
    }

}
