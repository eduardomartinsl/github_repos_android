package com.martins.eduardo.github_user_list.extensions

import android.app.Application
import com.martins.eduardo.github_user_list.di.AppComponent
import com.martins.eduardo.github_user_list.di.AppModule
import com.martins.eduardo.github_user_list.di.DaggerAppComponent
import com.martins.eduardo.github_user_list.di.RemoteModule

val Application.component: AppComponent
    get() = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .remoteModule(RemoteModule())
        .build()