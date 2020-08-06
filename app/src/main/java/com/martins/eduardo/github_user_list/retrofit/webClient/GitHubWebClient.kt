package com.martins.eduardo.github_user_list.retrofit.webClient

import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.retrofit.AppRetrofit
import com.martins.eduardo.github_user_list.services.GitHubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val REQUISICAO_NAO_SUCEDIDA = "Requisição não sucedida"

class GitHubWebClient (
    private val service : GitHubService = AppRetrofit().gitHubService
){
    private fun <T> executeRequisition(
        call: Call<T>,
        whenSuccess: (response: T?) -> Unit,
        whenFailure: (error: String?) -> Unit
    ){
        call.enqueue(object: Callback<T>{
            override fun onFailure(call: Call<T>, t: Throwable) {
                whenFailure(t.message)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if(response.isSuccessful){
                    //respondeu corretamente
                    whenSuccess(response.body())

                } else{
                    //não respondeu corretamente
                    whenFailure(REQUISICAO_NAO_SUCEDIDA)

                }
            }

        })
    }

    fun buscaTodosRepositorios(
        nomeUsuario: String,
        whenSuccess: (listaRepositorios: List<Repo>?) -> Unit,
        whenFailure: (erro: String?) -> Unit
    ){
        executeRequisition(service.getAllRepository(nomeUsuario), whenSuccess, whenFailure)
    }
}