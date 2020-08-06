package com.martins.eduardo.github_user_list.di

import com.martins.eduardo.github_user_list.repository.Repository
import com.martins.eduardo.github_user_list.ui.UserListActivity
import com.martins.eduardo.github_user_list.viewModel.UserListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RemoteModule::class])
interface AppComponent {

    //activity
    fun inject(activity: UserListActivity)

    //viewmodels
    fun inject(viewModel: UserListViewModel)

}