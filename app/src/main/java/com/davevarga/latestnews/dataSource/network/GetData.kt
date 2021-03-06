package com.davevarga.latestnews.dataSource.network

import com.davevarga.latestnews.models.RecentPosts
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.Response

interface GetData {


    @GET("top-headlines?country=us&apiKey=1b5314588cbf4d7fa1fa5d55ea1eda95")
    suspend fun getData(): Response<RecentPosts>

}
