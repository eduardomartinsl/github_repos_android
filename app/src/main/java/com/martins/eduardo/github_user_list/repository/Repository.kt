@file:Suppress("SENSELESS_COMPARISON")

package com.martins.eduardo.github_user_list.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.martins.eduardo.github_user_list.db.dao.CodeColorsDao
import com.martins.eduardo.github_user_list.db.dao.SugestoesDao
import com.martins.eduardo.github_user_list.models.Color
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.models.Sugestao
import com.martins.eduardo.github_user_list.models.User
import com.martins.eduardo.github_user_list.services.GitHubService
import javax.inject.Inject


class Repository @Inject constructor(
    private val service: GitHubService,
    private val sugestoesDao: SugestoesDao,
    private val codeColorsDao: CodeColorsDao
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

    suspend fun criaTabelaDeCores(jsonCores: String?) {
        val listTutorialType = object : TypeToken<List<Color>>() {}.type
        val coresDecodificadas: List<Color> = Gson().fromJson(jsonCores, listTutorialType)
        codeColorsDao.insertColors(coresDecodificadas)
    }

    suspend fun carregaCor(linguagem: String): String?{
        return codeColorsDao.selectColorHash(linguagem)
    }
}