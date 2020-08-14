package com.davevarga.latestnews.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.request.RequestOptions
import com.davevarga.latestnews.*
import com.davevarga.latestnews.dataSource.database.AppDatabase
import com.davevarga.latestnews.dataSource.network.GetData
import com.davevarga.latestnews.dataSource.network.ServiceBuilder
import com.davevarga.latestnews.databinding.LayoutNewsListItemBinding
import com.davevarga.latestnews.models.NewsPost
import com.davevarga.latestnews.utils.GlideApp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    //watch the factory creation and activity parameter
    private val viewModel: NewsViewModel by lazy {
        val activity = requireNotNull(this) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProviders.of(this, NewsViewModelFactory(application))
            .get(NewsViewModel::class.java)
    }

    private var emptyList: List<NewsPost> = emptyList()

    private var viewModelAdapter = NewsRecyclerAdapter(emptyList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.newsFeed.observe(this, Observer<List<NewsPost>> { items ->
            items?.apply {
                viewModelAdapter.items = items
                Log.i("MainActivityV", items.size.toString())
            }
        })
        
        Log.i("MainActivity", viewModelAdapter.items.size.toString())

            recycler_view.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = viewModelAdapter

        }

//        val request = ServiceBuilder.getNetworkClient(
//            GetData::class.java
//        )
//
//        viewModelFactory = NewsViewModelFactory(application)
//        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel::class.java)

//        CoroutineScope(Dispatchers.Main).launch {
//            val response = request.getData()
//            if (response.isSuccessful) {
//                recycler_view.apply {
//                    setHasFixedSize(true)
////                    do it in separate coroutine
//                    adapter = NewsRecyclerAdapter(response.body()!!.postList)
////                    adapter = NewsRecyclerAdapter(response.body()!!.postList)
////                    db.newsDao().insertNewsFeed(NewsRecyclerAdapter(response.body()!!.postList).items)
//                }
//                viewModel.refreshNews()
//
//            } else {
//                recycler_view.apply {
//                    setHasFixedSize(true)
//
//                    val savedNews = viewModel.newsFeed
//                    adapter = NewsRecyclerAdapter(savedNews.value!!)
//                }
//            }
//
//        }
//    }

    }


}
