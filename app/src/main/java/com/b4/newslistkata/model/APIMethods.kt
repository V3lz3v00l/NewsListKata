package com.b4.newslistkata.model

import retrofit2.http.GET


interface APIMethods {
    @GET("v2/everything?domains=wsj.com&apiKey=179f611067d34efd8670e39a2ea2c123")
    suspend fun getNews(): News

}