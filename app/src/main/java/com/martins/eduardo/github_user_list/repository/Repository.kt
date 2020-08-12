package com.martins.eduardo.github_user_list.repository

import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.services.GitHubService
import javax.inject.Inject


class Repository @Inject constructor(
    private val service: GitHubService
){

    suspend fun buscaTodosRepositoriosNoGit(
        username: String
    ) : List<Repo>{
        val allRepository = service.getAllRepositoryByUsername(username)
        return allRepository
    }
}