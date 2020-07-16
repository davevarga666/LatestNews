package com.davevarga.latestnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_news_list_item.view.*

class NewsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private val TAG: String = "AppDebug"

    private var items: List<NewsPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_news_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is NewsViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<NewsPost>){
        items = blogList
    }

    class NewsViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val news_image = itemView.news_image
        val news_title = itemView.news_title
        val news_author = itemView.news_author

        fun bind(NewsPost: NewsPost){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(NewsPost.image)
                .into(news_image)
            news_title.setText(NewsPost.title)
            news_author.setText(NewsPost.source)

        }

    }

}