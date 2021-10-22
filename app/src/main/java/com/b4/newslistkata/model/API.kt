package com.b4.newslistkata.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private const val BASE_URL = "https://newsapi.org/"
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: APIMethods = getRetrofit().create(APIMethods::class.java)
}

class ApiHelper(private val apiService: APIMethods) {

    suspend fun getNews() = apiService.getNews()
}