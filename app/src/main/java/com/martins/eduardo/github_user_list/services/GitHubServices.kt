package com.martins.eduardo.github_user_list.services

import com.martins.eduardo.github_user_list.models.Repo
import retrofit.http.GET
import retrofit.http.Path
import retrofit2.Call


interface GitHubService {
@GET("users/{user}/repos")
fun getAllRepository(@Path("user") user: String): Call<List<Repo>>
}