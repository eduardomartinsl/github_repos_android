package com.martins.eduardo.github_user_list.di

import com.martins.eduardo.github_user_list.services.GitHubService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class RemoteModule{

    val BASE_URL = "http://api.github.com/"

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideGitHubApi(retrofit: Retrofit) = retrofit.create(GitHubService::class.java)

}