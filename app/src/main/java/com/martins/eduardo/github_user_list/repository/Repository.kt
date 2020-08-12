package com.martins.eduardo.github_user_list.repository

import android.app.Application
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.services.GitHubService
import javax.inject.Inject


class Repository @Inject constructor(
//    private val service: GitHubService
){

    @Inject lateinit var service: GitHubService

    suspend fun buscaTodosRepositoriosNoGit(
        username: String
    ) : List<Repo>{
        val allRepository = service.getAllRepository(username)
        return allRepository
    }
}