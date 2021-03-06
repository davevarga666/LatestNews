package com.davevarga.latestnews.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.request.RequestOptions
import com.davevarga.latestnews.R
import com.davevarga.latestnews.databinding.LayoutNewsListItemBinding
import com.davevarga.latestnews.models.NewsPost
import com.davevarga.latestnews.utils.GlideApp

class NewsRecyclerAdapter(var items: List<NewsPost>) :
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


        return NewsViewHolder(
            binding.root
        )

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        return holder.bind(items.get(position), binding)

    }

    fun getItem(position: Int): NewsPost {
        return items.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //to remove duplicates
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
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

            GlideApp.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(newsPiece.postImage)
                .error(R.drawable.error_image)
                .placeholder(circularProgressDrawable)
//                .error(R.drawable.imagenotfound)
//                .errorPlaceholder
                .into(binding.newsImage)

        }

    }

}