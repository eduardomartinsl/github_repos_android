package com.martins.eduardo.github_user_list.services

import com.martins.eduardo.github_user_list.models.Repo
import retrofit.Call
import retrofit.http.GET
import retrofit.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<Repo>
}