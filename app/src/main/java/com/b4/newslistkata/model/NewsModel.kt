package com.b4.newslistkata.model

import kotlinx.coroutines.Deferred


interface NewsModel {
    suspend fun fetchNews(): Deferred<News>
}