package com.example.list_app.data

import com.example.list_app.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Retrofit {
    @GET("/repositories")
    fun listRepos(@Query("page") page: String?): Call<List<Item>>
}