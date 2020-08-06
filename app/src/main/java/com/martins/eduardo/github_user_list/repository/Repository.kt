package com.martins.eduardo.github_user_list.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.retrofit.webClient.GitHubWebClient

class Repository(
    private val webClient : GitHubWebClient = GitHubWebClient()
) {
    fun buscaTodosRepositoriosNoGit(
        username: String
    ): LiveData<RepositoryResource<List<Repo>>> {

        //mutablelivedata responsável por armazenar a informação a ser passada para a ViewModel
        val liveData = MutableLiveData<RepositoryResource<List<Repo>>>()

        webClient.buscaTodosRepositorios(
            username,
            whenSuccess = { listaRepositorios ->
                //em sucesso, retornar lista de repositorios

                liveData.value = RepositoryResource(data = listaRepositorios)
            },
            whenFailure = {erro ->
                RepositoryResource(null, erro)
            }
        )

        return liveData
    }
}