package com.martins.eduardo.github_user_list.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.repository.Repository
import kotlinx.coroutines.launch
import java.io.Console
import java.lang.Exception
import javax.inject.Inject

class UserListViewModel (application: Application) : AndroidViewModel(application){

    @Inject lateinit var repository: Repository

    init {
        getApplication<Application>().component.inject(this)
    }

    private val _listaRepositorios = MutableLiveData<List<Repo>>()
    val listaRepositorio : LiveData<List<Repo>>
    get() = _listaRepositorios

    fun buscaTodosRepositorios(username: String) {
        viewModelScope.launch {
            try {
                val repositoriosEncontrados = repository.buscaTodosRepositoriosNoGit(username)
                _listaRepositorios.postValue(repositoriosEncontrados)
            }catch (e: Exception){
                Log.e("Erro de comunicação", e.message!!)
            }

        }
    }
}