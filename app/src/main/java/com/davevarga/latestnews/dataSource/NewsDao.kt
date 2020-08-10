package com.davevarga.latestnews.dataSource

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.davevarga.latestnews.models.NewsPost

@Dao
interface NewsDao {
    @Query("SELECT * FROM news_table")
    fun getNewsFeed(): LiveData<List<NewsPost>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsFeed(newsFeed: List<NewsPost>)


}