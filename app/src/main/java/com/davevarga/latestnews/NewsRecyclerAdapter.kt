package com.davevarga.latestnews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_news_list_item.*
import kotlinx.android.synthetic.main.layout_news_list_item.view.*

class NewsRecyclerAdapter(val items: List<NewsPost>) :
    RecyclerView.Adapter<NewsRecyclerAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_news_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        return holder.bind(items.get(position))

    }

    override fun getItemCount(): Int {
        return items.size
    }


    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val news_image = itemView.news_image
        val news_title = itemView.news_title
        val news_source = itemView.news_source
        val news_date = itemView.news_date

        fun bind(newsPiece: NewsPost) {

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
                .into(news_image)
            news_title.setText(newsPiece.title)
            news_source.setText(newsPiece.source.name)
            news_date.setText(newsPiece.publishedAt)

        }

    }

}