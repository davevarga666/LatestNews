package com.davevarga.latestnews.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_table")
data class NewsPost(
//nullable fields?
    @SerializedName("author")
    val postAuthor: String?,

    @SerializedName("title")
    val postTitle: String?,

    @SerializedName("description")
    val postDescription: String?,

    @SerializedName("url")
    val postUrl: String?,

    @SerializedName("urlToImage")
    val postImage: String?,

    @SerializedName("source")
    val postSource: Source?,

    @SerializedName("publishedAt")
    val postDate: String?,

    @SerializedName("content")
    val postContent: String?
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

//    val postTitle: String?
//        get() {
//            val delimiter = " - ${postSource?.sourceName}"
//            return _postTitle?.split(delimiter)?.joinToString()?.replace(",", "")
//
//        }
}

data class Source(
    @SerializedName("id")
    val sourceId: String?,

    @SerializedName("name")
    val sourceName: String?
)

data class RecentPosts(
    @SerializedName("status")
    val postStatus: String,

    @SerializedName("articles")
    val postList: List<NewsPost>
)

