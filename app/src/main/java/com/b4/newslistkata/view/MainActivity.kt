package com.b4.newslistkata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.b4.newslistkata.R
import com.b4.newslistkata.model.News
import com.b4.newslistkata.presenter.NewsPresenter

class MainActivity : AppCompatActivity(), NewsViewContract {
    private val presenter = NewsPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.setView(this)
        presenter.fetchNews()
    }

    override fun loading() {
        Log.d("MainActivity", "loading()")
    }

    override fun showNews(list: News) {
        Log.d("MainActivity", "showNews()")
    }
}