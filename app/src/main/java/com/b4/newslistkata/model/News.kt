package com.b4.newslistkata.model

data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val title: String,
    val description: String,
    val urlToImage: String
)
