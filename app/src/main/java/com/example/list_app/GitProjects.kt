package com.example.list_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GitProjects {
    @GET("/repositories")
    fun listRepos(@Query("page") page: String?): Call<List<Item>>
}