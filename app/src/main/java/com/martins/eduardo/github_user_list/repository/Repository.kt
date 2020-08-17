package com.martins.eduardo.github_user_list.repository

import com.martins.eduardo.github_user_list.db.dao.SugestoesDao
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.models.Sugestao
import com.martins.eduardo.github_user_list.models.User
import com.martins.eduardo.github_user_list.services.GitHubService
import javax.inject.Inject


class Repository @Inject constructor(
    private val service: GitHubService,
    private val sugestoesDao: SugestoesDao
){

    suspend fun buscaTodosRepositoriosNoGit(
        username: String
    ) : List<Repo>{
        val allRepository = service.getAllRepositoryByUsername(username)
        return allRepository
    }

    suspend fun carregaListaSugestoes() : List<Sugestao> {
        val listaSugestoes = sugestoesDao.getAllSugestoes()
        return listaSugestoes
    }

    suspend fun salvaSugestao(sugestao: Sugestao) {
        sugestoesDao.atualizaHistoricoBusca(sugestao)
    }

    suspend fun buscaUsuario(username: String) : User{
        val usuarioRemoto = service.findUser(username)
        return usuarioRemoto
   }
}