package com.b4.newslistkata.view

import com.b4.newslistkata.model.News
import com.b4.newslistkata.viewstates.NewsViewState

interface NewsViewContract {
    fun render(state: NewsViewState)
}