package com.martins.eduardo.github_user_list.services

import com.martins.eduardo.github_user_list.models.Repo
import retrofit.Call
import retrofit.http.GET
import retrofit.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}