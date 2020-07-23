package com.martins.eduardo.github_user_list.di

import com.martins.eduardo.github_user_list.UserListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RemoteModule::class])
interface AppComponent {

    //activity
    fun inject(activity: UserListActivity)

    //viewmodels

}