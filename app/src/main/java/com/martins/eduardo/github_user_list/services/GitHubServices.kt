package com.martins.eduardo.github_user_list.services

import com.martins.eduardo.github_user_list.models.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun getAllRepository(@Path("user") user: String): List<Repo>
}