package com.martins.eduardo.github_user_list.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.martins.eduardo.github_user_list.models.Repo
import com.martins.eduardo.github_user_list.repository.Repository
import com.martins.eduardo.github_user_list.repository.RepositoryResource


class UserListViewModel(private val repository: Repository) : ViewModel(){

    fun buscaTodosRepositorios(username: String) : LiveData<RepositoryResource<List<Repo>>> {
        return repository.buscaTodosRepositoriosNoGit(username)
    }

}