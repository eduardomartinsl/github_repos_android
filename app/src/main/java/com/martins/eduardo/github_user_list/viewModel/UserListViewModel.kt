package com.martins.eduardo.github_user_list.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.martins.eduardo.github_user_list.extensions.component
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.repository.Repository
import com.martins.eduardo.github_user_list.services.GitHubService
import javax.inject.Inject


class UserListViewModel(application: Application) : AndroidViewModel(application){

    @Inject lateinit var repository: Repository

    init {
        getApplication<Application>().component.inject(this)
    }

    fun buscaTodosRepositorios() : LiveData<List<Repo>>{
        return repository.buscaTodosRepositorios()
    }

}