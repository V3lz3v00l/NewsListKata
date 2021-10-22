package com.b4.newslistkata.presenter

import android.util.Log
import com.b4.newslistkata.model.API
import com.b4.newslistkata.model.APIMethods
import com.b4.newslistkata.model.ApiHelper
import com.b4.newslistkata.model.NewsModelImpl
import com.b4.newslistkata.view.NewsViewContract
import com.b4.newslistkata.viewstates.NewsEvent
import com.b4.newslistkata.viewstates.NewsViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class NewsPresenter() {

    private val modelImpl = NewsModelImpl(apiHelper = ApiHelper(apiService = API.apiService))
    private var mView: NewsViewContract? = null

    fun setView(view: NewsViewContract) {
        mView = view
    }

    fun obtainEvent(event: NewsEvent) {
        when (event) {
            is NewsEvent.NewsFetch -> {
                fetchNews()
            }
            is NewsEvent.NewsClick -> {
                Log.d("NewsPresenter", "obtainEvent() NewsClick to ${event.articleName}")
            }
        }
    }

    private fun fetchNews() {
        mView?.render(NewsViewState.NewsLoadingState)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val news = modelImpl.fetchNews().await()
                withContext(Dispatchers.Main) {
                    if (news.articles.isEmpty()) {
                        mView?.render(NewsViewState.NewsNoItemsState)
                    } else {
                        mView?.render(NewsViewState.NewsLoadedState(news))
                    }

                }
            } catch (e: Exception) {
                mView?.render(NewsViewState.NewsErrorState(e.stackTraceToString()))
            }
        }
    }

}