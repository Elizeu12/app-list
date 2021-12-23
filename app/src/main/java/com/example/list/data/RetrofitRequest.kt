package com.example.list.data

import com.example.list.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitRequest {
    @GET("/repositories")
    fun listRepos(@Query("language") language: String?, @Query("page") page: String?,
                  @Query("stars") stars: String?, @Query("name") name: String?): Call<List<Item>>
}