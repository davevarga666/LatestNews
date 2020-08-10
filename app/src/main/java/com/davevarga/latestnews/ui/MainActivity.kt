package com.davevarga.latestnews.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.davevarga.latestnews.*
import com.davevarga.latestnews.dataSource.database.AppDatabase
import com.davevarga.latestnews.dataSource.network.GetData
import com.davevarga.latestnews.dataSource.network.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var viewModelFactory: NewsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.getNetworkClient(
            GetData::class.java
        )

        viewModelFactory = NewsViewModelFactory(application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            val response = request.getData()
            if (response.isSuccessful) {
                recycler_view.apply {
                    setHasFixedSize(true)
//                    do it in separate coroutine
                    adapter = NewsRecyclerAdapter(response.body()!!.postList)
//                    adapter = NewsRecyclerAdapter(response.body()!!.postList)
//                    db.newsDao().insertNewsFeed(NewsRecyclerAdapter(response.body()!!.postList).items)
                }
                viewModel.insert(NewsRecyclerAdapter(response.body()!!.postList).items)

            }
            else {
                recycler_view.apply {
                    setHasFixedSize(true)

                    val savedNews = viewModel.newsFeed
                    adapter = NewsRecyclerAdapter(savedNews.value!!)
                }
            }

        }
    }

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val n = cm.activeNetwork
            if (n != null) {
                val nc = cm.getNetworkCapabilities(n)
                //It will check for both wifi and cellular network
                return nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI)
            }
            return false
        } else {
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }
    }


}