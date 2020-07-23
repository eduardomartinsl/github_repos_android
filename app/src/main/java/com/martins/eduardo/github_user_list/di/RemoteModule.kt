package com.martins.eduardo.github_user_list.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import javax.inject.Singleton

@Module
open class RemoteModule {
    private val BASE_URL = "https://api.github.com/"

    @Provides
    @Singleton
    open fun providesRetrofit() =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

}