package com.davevarga.latestnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.davevarga.latestnews.databinding.LayoutNewsListItemBinding
import kotlinx.android.synthetic.main.layout_news_list_item.*
import kotlinx.android.synthetic.main.layout_news_list_item.view.*

class NewsRecyclerAdapter(val items: List<NewsPost>) :
    RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder>() {

    lateinit var binding: LayoutNewsListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_news_list_item,
            parent,
            false
        )

        return NewsViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        return holder.bind(items.get(position), binding)

    }

    override fun getItemCount(): Int {
        return items.size
    }


    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(newsPiece: NewsPost, binding: LayoutNewsListItemBinding) {

            binding.newsItem = newsPiece

            val circularProgressDrawable = CircularProgressDrawable(itemView.context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.start()


            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load("https://raw.githubusercontent.com/bumptech/glide/master/static/glide_logo.png")
                .placeholder(circularProgressDrawable)
                .load(newsPiece.urlToImage)
//                .errorPlaceholder
                .into(binding.newsImage)

        }

    }

}