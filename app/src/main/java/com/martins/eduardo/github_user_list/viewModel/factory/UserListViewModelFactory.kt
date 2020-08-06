package com.martins.eduardo.github_user_list.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.martins.eduardo.github_user_list.repository.Repository
import com.martins.eduardo.github_user_list.viewModel.UserListViewModel

@Suppress("UNCHECKED_CAST")
class UserListViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserListViewModel(repository) as T
    }
}