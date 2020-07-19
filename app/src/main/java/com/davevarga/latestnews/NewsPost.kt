package com.davevarga.latestnews

import java.sql.ClientInfoStatus

data class NewsPost(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val source: Source,
    val publishedAt: String,
    val content: String
)

data class Source(
    val id: String,
    val name: String
)

data class RecentPosts(
    val status :   String,
    val articles: List<NewsPost>
)