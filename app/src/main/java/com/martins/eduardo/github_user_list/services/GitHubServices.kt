package com.martins.eduardo.github_user_list.services

import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.models.User
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun getAllRepositoryByUsername(@Path("user") user: String): List<Repo>

    @GET("users/{user}")
    suspend fun findUser(@Path("user") user: String): User
}