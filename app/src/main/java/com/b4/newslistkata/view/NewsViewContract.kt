package com.b4.newslistkata.view

import com.b4.newslistkata.model.News

interface NewsViewContract {
    fun loading()
    fun showNews(list: News)
}