package com.davevarga.latestnews

import io.reactivex.Observable
import retrofit2.http.GET

interface GetData {

//Describe the request type and the relative URL//

    @GET("top-headlines?country=us&apiKey=1b5314588cbf4d7fa1fa5d55ea1eda95")
    fun getData(): Observable<List<NewsPost>>

}
