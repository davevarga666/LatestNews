package com.davevarga.latestnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.getNetworkClient(GetData::class.java)
        val call = request.getData()

        call.enqueue(object : Callback<RecentPosts>{
            override fun onResponse(call: Call<RecentPosts>, response: Response<RecentPosts>) {
                if (response.isSuccessful){
                    recycler_view.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)

                        // Pasing of response is not proper
                        adapter = NewsRecyclerAdapter(response.body()!!.articles)
                    }
                }
            }

            override fun onFailure(call: Call<RecentPosts>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

//        initRecyclerView()

    })
    }

//    private fun initRecyclerView() {
//
//        recycler_view.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            val topSpacingDecorator = TopSpacingItemDecoration(30)
//            addItemDecoration(topSpacingDecorator)
//            adapter = NewsRecyclerAdapter(items)
//        }
//    }


}