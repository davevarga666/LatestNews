package com.davevarga.latestnews

import com.davevarga.latestnews.RecentPosts
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response

interface GetData {


    @GET("top-headlines?country=us&apiKey=1b5314588cbf4d7fa1fa5d55ea1eda95")
    suspend fun getData(): Response<RecentPosts>

}
