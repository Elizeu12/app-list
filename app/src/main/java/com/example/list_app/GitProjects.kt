package com.example.list_app

import retrofit2.http.GET
import retrofit2.Call


interface GitProjects {
    @GET("repositories?q=language:kotlin&sort=stars&page=1")
    fun listRepos(): Call<List<Item>>
}
/*

var service: GitHubService = retrofit.create(GitHubService::class.java)

var repos: Call<List<Repo>> = service.listRepos("octocat")*/