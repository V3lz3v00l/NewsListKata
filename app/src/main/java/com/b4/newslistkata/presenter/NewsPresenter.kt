package com.b4.newslistkata.presenter

import com.b4.newslistkata.model.API
import com.b4.newslistkata.model.APIMethods
import com.b4.newslistkata.model.ApiHelper
import com.b4.newslistkata.model.NewsModelImpl
import com.b4.newslistkata.view.NewsViewContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsPresenter() {

    private val modelImpl = NewsModelImpl(apiHelper = ApiHelper(apiService = API.apiService))
    private var mView: NewsViewContract? = null

    fun setView(view: NewsViewContract) {
        mView = view
    }

    fun fetchNews() {
        CoroutineScope(Dispatchers.IO).launch {
            mView?.loading()
            val news = modelImpl.fetchNews().await()
            withContext(Dispatchers.Main) {
                mView?.showNews(list = news)
            }
        }
    }

}