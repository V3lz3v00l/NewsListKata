package com.b4.newslistkata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.b4.newslistkata.R
import com.b4.newslistkata.model.News
import com.b4.newslistkata.presenter.NewsPresenter
import com.b4.newslistkata.viewstates.NewsEvent
import com.b4.newslistkata.viewstates.NewsViewState

class MainActivity : AppCompatActivity(), NewsViewContract {
    private val presenter = NewsPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
        presenter.obtainEvent(NewsEvent.NewsFetch)
    }

    override fun render(state: NewsViewState) {
        when(state) {
            is NewsViewState.NewsLoadingState -> {
                Log.d("MainActivity", "render() NewsLoadingState")
            }
            is NewsViewState.NewsNoItemsState -> {

            }
            is NewsViewState.NewsErrorState -> {

            }
            is NewsViewState.NewsLoadedState -> {
                Log.d("MainActivity", "render() NewsLoadedState")
            }
        }
    }


}