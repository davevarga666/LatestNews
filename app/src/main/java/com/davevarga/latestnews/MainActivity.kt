package com.davevarga.latestnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.davevarga.latestnews.databinding.LayoutNewsListItemBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.getNetworkClient(GetData::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            val response = request.getData()
            if (response.isSuccessful) {
                recycler_view.apply {
                    setHasFixedSize(true)


                    // Parsing of response is not proper
                    adapter = NewsRecyclerAdapter(response.body()!!.postList)
                }
            }


        }
    }


}