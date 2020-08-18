@file:Suppress("SENSELESS_COMPARISON")

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
        if(sugestoesDao.findSugestao(sugestao.sugestao) == null){
            sugestoesDao.atualizaHistoricoBusca(sugestao)
        }
    }

    suspend fun buscaUsuario(username: String) : User{
        val usuarioRemoto = service.findUser(username)
        return usuarioRemoto
   }

    suspend fun removeSugestao(sugestao: Sugestao) {
        sugestoesDao.deletaSugestao(sugestao)
    }
}