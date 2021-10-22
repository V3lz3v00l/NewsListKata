package com.b4.newslistkata.model

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class NewsModelImpl(private val apiHelper: ApiHelper): NewsModel {
    override suspend fun fetchNews(): Deferred<News> {
        return GlobalScope.async {
            apiHelper.getNews()
        }
    }
}