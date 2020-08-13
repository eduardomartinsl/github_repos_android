package com.martins.eduardo.github_user_list.di

import com.martins.eduardo.github_user_list.repository.Repository
import com.martins.eduardo.github_user_list.services.GitHubService
import com.martins.eduardo.github_user_list.ui.SearchActivity
import com.martins.eduardo.github_user_list.ui.UserListActivity
import com.martins.eduardo.github_user_list.viewModel.SearchViewModel
import com.martins.eduardo.github_user_list.viewModel.UserListViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [(AppModule::class), (RemoteModule::class), (DbModule::class)])
@Singleton
interface AppComponent {

    //activity
    fun inject(activity: UserListActivity)
    fun inject(activity: SearchActivity)

    //viewModel
    fun inject(viewModel: UserListViewModel)
    fun inject(viewModel: SearchViewModel)
}